package controlador;

import vista.Vista;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);
        
        controlador.cs.iniciaConexion();
        controlador.v.setVisible(true);
        
        while(true){
            controlador.v.repaint();
            controlador.moverMundo();
            controlador.cs.envio();
            controlador.cs.recepcion();
            Thread.sleep(200);
	}
    }
}