package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class ConexionCliente {
    public Socket socket;
    public DatosCliente dc;
    public Raqueta r1;
    public Raqueta2 r2;
    public InputStream fBE;
    public Reader fCE;
    public BufferedReader entrada;
    public OutputStream fBS;
    public Writer fCS;
    public BufferedWriter salida;
    
    public ConexionCliente(DatosCliente dc, Raqueta r1, Raqueta2 r2){
        this.dc = dc;
        this.r1  = r1;
        this.r2 = r2;
    }

    public void iniciaConexion(){
        try{
            this.socket = new Socket(dc.ip, dc.puerto);
            System.out.println("ya conectó");
        } catch(IOException ioe) { }
    }
    
    public void recepcion(){
       String msg;
        
        try{
            fBE = this.socket.getInputStream();
            fCE = new InputStreamReader(fBE);
            entrada = new BufferedReader(fCE);  
            msg = entrada.readLine();
            int ms = Integer.parseInt(msg);
            r1.setY(ms);
        } catch(IOException ioe) { }
    }
    
    public void envio(){
        dc.mensaje = String.valueOf(r2.getY());
        
        //System.out.println(dc.mensaje);
        
        try{
            PrintWriter escribir = new PrintWriter(socket.getOutputStream(), true);
             
            escribir.println(dc.mensaje);            
        } catch(IOException ioe) {   }
    }
}