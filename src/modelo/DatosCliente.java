package modelo;

public class DatosCliente {
    public String mensaje;
    public int puerto = 2882;
    public String ip = "localhost";

    public DatosCliente(){
        mensaje = null;
        puerto = 2882;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}