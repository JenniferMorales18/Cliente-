package Cliente;

/**
 * @author jammj
 */
    public class ServChat { // clase principal
        public static void main(String[] arg) {
            int port=(arg.length>0)?Integer.parseInt(arg[0]):29029;
            Conversacion conv= new Conversacion();
            System.out.println("Servidor activado en port: "+port);
            try {   ServerSocket ss= new ServerSocket(port);
                System.out.println("Espero conexiones ..");
                while (true) conv.altaCliente(ss.accept());
            } catch (IOException e) {System.exit(-1);}
        }
        
    //  while (true) conv.altaCliente(ss.accept());
    }
