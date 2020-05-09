package controlador;

import javax.swing.JFrame;
import modelo.Pelota;
import modelo.ConexionCliente;
import modelo.DatosCliente;
import modelo.Raqueta;
import modelo.Raqueta2;
import vista.Vista;

public class Controlador extends JFrame{
    public Vista v;
    public DatosCliente ds;
    public ConexionCliente cs;
    private Pelota p;
    private Raqueta r1;
    private Raqueta2 r2;
    private int golpes, golpes2;
    
    public Controlador(Vista v){
        this.v = v;
        p = new Pelota(this.v.getWidth(), this.v.getHeight());
	r1 = new Raqueta(this.v.getHeight());
	r2 = new Raqueta2(this.v.getHeight());
	this.v.p = p;
        this.v.r1 = r1;
        this.v.r2 = r2;
        ds = new DatosCliente();
        cs = new ConexionCliente(ds,r1,r2);
        v.cs = cs;
        golpes = 0;
	golpes2 = 0;
    }
    
    public void moverMundo(){
	p.mover();
	
        if(colision()){
            p.rebota();
            
            golpes = golpes + 1;
            v.marcador.setText(String.valueOf(golpes / 2));	
	}
	
        if(colision2()){
            p.rebota();
            
            golpes2 = golpes2 + 1;
            v.marcador2.setText(String.valueOf(golpes2 / 2));		
	}
	
        if(p.TocaFondo()){		
            //gameOver();
	}	
    }
    
    public boolean colision(){
	return p.limite().intersects(r1.limite());
    }
    
    public boolean colision2(){
	return p.limite().intersects(r2.limite());
    }

    public void gameOver() {
        //Sonido.FONDO.stop();
	//Sonido.GAMEOVER.play();
	/*if(golpes>golpes2){
            JOptionPane.showMessageDialog(this,"El jugador 1 ganó", "Game Over", JOptionPane.YES_NO_OPTION);
            System.exit(0);
	}
        
        else{
            if(golpes<golpes2){
                JOptionPane.showMessageDialog(this, "El jugador 2 ganó", "Game Over", JOptionPane.YES_NO_OPTION);
                System.exit(0);
            }
            
            else{
		JOptionPane.showMessageDialog(this, "Empate", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(0);
            }
	}*/
    }
}