package Cliente;
/**
 * @author jammj
 */
public class Conversacion {
    Cliente C=null;     // cabeza lista clientes
    Msg M=null;     // cabeza lista mensajes
    
    public void nuevoMsg(Msg m) {m.sig=M; M=m;}

    public void altaCliente(Socket s) {
        System.out.println("nuevo cliente");
        (C=new Cliente(this,s,null,C)).start(); // para atender al nuevo cliente
    }

    public void bajaCliente(Cliente c) { // elimina de la lista OJO.- sabemos que c existe
        if (c==C) C=c.sig;
        else {
            Cliente p;
            for (p=C; p.sig!=c; p=p.sig) {}
            p.sig=p.sig.sig;
        }
    }

    public Cliente apodado(String s) {
        Cliente c;
        for (c=C; (c!=null) && (!s.equals(c.apodo)); c=c.sig) {}
        return c;
    }

    public void difunde(String s) {
        for (Cliente c=C; c!=null; c=c.sig) c.envia(s);
    }

    private static class Cliente {

        private Cliente sig;
        private Object apodo;

        public Cliente() {
        }

        private Cliente(Conversacion aThis, Socket s, Object object, Cliente C) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void start() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void envia(String s) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class Socket {

        public Socket() {
        }
    }
    
}
