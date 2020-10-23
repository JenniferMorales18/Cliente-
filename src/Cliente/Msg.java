package Cliente;
/**
 * @author jammj
 */
 abstract class Msg {
        Msg sig;
        public static Msg decodifica(String s) {
            if (0==s.compareTo("/nt"))  return new MsgRechazoApodo();
            if (0==s.compareTo("/d"))   return new MsgDesconexion();
            if (s.startsWith("/n:"))    return new MsgApodo(s.substring(3));
            if (s.startsWith("/p:"))    return new MsgPrivado(s.substring(3));
            return new MsgPublico(s);
        }
        abstract public String toString();
    }
    class MsgPublico extends Msg {
        String txt;
        public MsgPublico(String s) {txt=s;}
        public String toString() {return txt;}
    }
    class MsgPrivado extends Msg {
        String txt, to;
        public MsgPrivado(String s) {
            int sep=s.indexOf(":");
            to=s.substring(0,sep);
            txt=s.substring(sep+1);
        }
        public String toString() {return "/p:"+to+":"+txt;}
    }
    class MsgApodo extends Msg {
        String txt;
        public MsgApodo(String s) {txt=s;}
        public String toString() {return "/n:"+txt;}
    }
    class MsgRechazoApodo extends Msg {
        public String toString() {return "/nt";}
    }
    class MsgDesconexion extends Msg {
        public String toString() {return "/d";}
    }
