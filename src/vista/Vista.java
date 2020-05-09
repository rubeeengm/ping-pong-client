package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import modelo.Pelota;
import modelo.ConexionCliente;
import modelo.Raqueta;
import modelo.Raqueta2;

public class Vista extends JFrame implements KeyListener{
    private JPanel panel;   
    private JLabel fondo;
    public JLabel marcador;
    public JLabel marcador2;
    public Pelota p;
    public Raqueta r1;
    public Raqueta2 r2;
    public ConexionCliente cs;
    
    public Vista() {
        setTitle("Ping Pong - Cliente");
        setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(450, 100, 640, 450);
        marco();
        addKeyListener(this);
    }
    
    public void marco(){	
        panel = new JPanel();
	panel.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(panel);
	panel.setLayout(null);
	
        ////////para poner fondo
	((JPanel) getContentPane()).setOpaque(false);
        
        ImageIcon imagen = new ImageIcon(this.getClass().getResource("/imagen/wallpaper.jpg"));
        /////////////////////////
        
        marcador = new JLabel("0");
        marcador.setForeground(Color.WHITE);
        marcador.setFont(new Font("Monospaced", Font.BOLD, 17));
        marcador.setBounds(93, 0, 73, 18);
        panel.add(marcador);
        
        marcador2 = new JLabel("0");
        marcador2.setForeground(Color.WHITE);
        marcador2.setFont(new Font("Monospaced", Font.BOLD, 17));
        marcador2.setBounds(485, 2, 56, 16);
        panel.add(marcador2);
        
        fondo = new JLabel();
        
        fondo.setIcon(imagen);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, 640, 450);
        getContentPane().add(fondo, BorderLayout.CENTER);
        this.setSize(640, 484);
        this.setLocationRelativeTo(null);
    }
    
    @Override
    public void  paint(Graphics g ){
	super.paint(g);
	Graphics2D g2d = (Graphics2D) g;
		
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, (RenderingHints.VALUE_ANTIALIAS_ON));
	g2d.setColor(Color.CYAN);
        p.pintar(g2d);
	g2d.setColor(Color.RED);
	r1.pintar(g2d);
	g2d.setColor(Color.green);
	r2.pintar(g2d);	
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
	/*if(e.getKeyCode() == KeyEvent.VK_A){
            raquetita1.moverRaquetaarriba1();
        }
        
	if(e.getKeyCode() == KeyEvent.VK_Z){
            raquetita1.moverRaquetaabajo1();
	}*/
	
        //////////////////////////////////////////
	if(e.getKeyCode() == KeyEvent.VK_UP){
            r2.moverArriba();
            cs.envio();
	}
	
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            r2.moverAbajo();
            cs.envio();
	}
    }
    
    @Override
    public void keyReleased(KeyEvent e) {		
    }

    @Override
    public void keyTyped(KeyEvent e) {	
    }
}