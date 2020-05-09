package modelo;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pelota  {
    private int x ,y, direccionX, direccionY, alto, ancho;
    public int diametro;
	
    public Pelota(int ancho , int alto) {
        this.ancho = ancho;
	this.alto = alto;
	x = 0;
	y = 0;
	direccionX = 27;
	direccionY = 27;
	diametro = 20;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDireccionX() {
        return direccionX;
    }

    public void setDireccionX(int direccionX) {
        this.direccionX = direccionX;
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

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }
	
    public void mover(){
	//CUANDO llega a la derecha y supera el ancho dela ventana 
	// lerestamos -1 asi vamos hacia la izquierda
	if(x + direccionX > ancho - 40)
            direccionX = -27;
	
        if(x + direccionX < 0)
            direccionX = 27;
	
	if(y + direccionY > alto - 60)//el alto de la ventana menos el diametro *3 de la pelota para que no se salga del panel
            direccionY = -27;
		
	if(y + direccionY < 0)
            direccionY = 27;
		
	x = x + direccionX;//// nota ojo
	y = y + direccionY;
    }
    
    public void pintar(Graphics2D g){
        g.fillOval(5 + x, 30 + y, 20, 20);	
    }
        
    public Rectangle limite(){
        return new Rectangle(5 + x, 30 + y, diametro, diametro );	
    }
        
    public void rebota(){
	if(x + direccionX > 40)
            direccionX = direccionX - 27;
        
        else
            direccionX = direccionX + 27;	
    }
    
    public boolean TocaFondo(){
        System.out.println((x + direccionX));
        return x + direccionX > ancho-40 || x + direccionX<0;
    }
}