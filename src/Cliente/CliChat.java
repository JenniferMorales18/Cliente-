package Cliente;
/**
 * @author jammj
 */
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class CliChat extends Frame{

    public static void main(String[] arg) throws IOException {
            String host=(arg.length>0)?arg[0]:"localhost";
            int port=(arg.length>1)?Integer.parseInt(arg[1]):29029;
            new CliChat(host,port);
    }
    private final TextField orden;
    private BufferedReader in;
    private PrintWriter out;
    
    private CliChat(String host, int port) throws IOException {
         super("Cliente Chat");
         
         orden= new TextField(40);
         List conversacion=new List(20,false);
         
         add("Center",conversacion); add("South",orden);
         addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e) {adios();}
    });
       orden.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            envia(); orden.setText("");
        }
    });
         
       setSize(600,300); show();

    try {   Socket s=new Socket(host,port);
        in= new BufferedReader(new InputStreamReader(s.getInputStream()));
        out= new PrintWriter(s.getOutputStream());
    } catch (IOException e) {System.exit(-1);}

    while(true) conversacion.add(procesa(in.readLine()), 0);
    }
    
    
    public static String procesa(String s) {
        System.out.println(s); // para facilitar la depuración
        if (s.equals("/nt")) return "SERVIDOR: Ese apodo ya está en uso. Intenta con otro";
        else return s;
    }
    public void envia() {out.println(orden.getText()); out.flush();}
    
    public void adios() {out.println("/d"); out.flush(); System.exit(0);}
    
}
