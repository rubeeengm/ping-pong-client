package modelo;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Raqueta {
    private int y, direccionY, alto, largo;
    
    public Raqueta(int alto) {
	y = 0;
	direccionY = 1;
	largo = 70;
	this.alto = alto;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDireccionY() {
        return direccionY;
    }

    public void setDireccionY(int direccionY) {
        this.direccionY = direccionY;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }
    
    public void moverAbajo() {
	if (y - 20 >  -160)
            y = y-80;
    }
    
    public void moverArriba() {
	if (y + largo + 20 < alto - 242 )
            y = y+80;
    }

    public void pintar(Graphics2D g) {
        g.fillRoundRect(15, 207 - y, 20, largo, 25, 25);	
}
        
    public Rectangle limite(){
	return new Rectangle(15, 207 - y, 20, largo);	
    }	
}