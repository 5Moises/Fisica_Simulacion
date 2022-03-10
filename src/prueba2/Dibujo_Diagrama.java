/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package prueba2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author moises
 */
public class Dibujo_Diagrama extends JFrame {

    private double Velocidad;
    private double angulo;   
    private double altura; 
    private double gravedad;    
    private double Masa;
    private double Viento;

    public double getMasa() {
        return Masa;
    }

    public void setMasa(double Masa) {
        this.Masa = Masa;
    }

    public double getViento() {
        return Viento;
    }

    public void setViento(double Viento) {
        this.Viento = Viento;
    }
    public void setVelocidad(double Velocidad) {
        this.Velocidad = Velocidad;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setGravedad(double gravedad) {
        this.gravedad = gravedad;
    } 

    class Point {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
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

    }

    public Dibujo_Diagrama() {

        this.setContentPane(new ImagenFondo());
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        
        this.setResizable(false);
        setTitle("MOVIMIENTO DE PROYECTILES Y CONSERVACIÓN DE LA ENERGÍA - SIMULADOR");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1040, 600));
        getContentPane().setLayout(null);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(900, 645, 0, 0);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/canasta.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(590, 90, 590, 630);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/jugador.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-48, 310, 220, 580);

        jButton1.setText("Lanzar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 10, 90, 30);

        

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/piso.jpeg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(810, 600, 280, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/piso.jpeg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 600, 280, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/piso.jpeg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(280, 600, 280, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/piso.jpeg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(540, 600, 280, 30);
        
        setSize(new java.awt.Dimension(1111, 657));
        setLocationRelativeTo(null);

    }
    //botn de resultados

   
    //boton de Lanzar
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            SimulaTiroThread simulaTiroThread = new SimulaTiroThread(); // objeto
            simulaTiroThread.start();
            simulaTiroThread.join();
             initComponents();
        } catch (InterruptedException ex) {
            Logger.getLogger(Dibujo_Diagrama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  

   

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration                   

    public class ImagenFondo extends JPanel {

        public void paint(Graphics g) {
            ImageIcon imagen = new ImageIcon(getClass().getResource("../Imagen/Fondo.jpg"));
            g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);

        }
    }

    private List<Point> points = new ArrayList<Point>();   

    class SimulaTiroThread extends Thread {

        public void run() {
                             
            double sinTheta = Math.sin(Math.toRadians(angulo));//seno
            double cosTheta = Math.cos(Math.toRadians(angulo));//coseno
            double gravity = gravedad;
            double x;
            double v0 = Velocidad*10;  
            double t = ((2 * v0 * sinTheta) / gravity);            
            double deltaT = t / 100000;           
            double cnt = 0;            
            while (cnt < t) { //bucle
                //;
                if(getViento()==0)
                {
                    x = v0 * cosTheta * cnt;
                }
                else
                {
                    x = v0*cosTheta* cnt + 0.5*(getViento()/getMasa())*cnt * cnt;
                }
                
                double y = v0 * sinTheta * cnt - 0.5*gravity * cnt * cnt;               
                points.add(new Point(15 + (int) x, 415 - (int) y));
                cnt += deltaT;
            }

        }

    }

    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Dimension d = this.getSize();

        super.paintComponents(g);

        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.toRadians(-angulo), 115, 515);
        AffineTransform old = g2.getTransform();
        g2.transform(transform);

        g2.setColor(Color.GREEN);
        g2.drawLine(115, 515, 200, 515);

        g2.setTransform(old);
        g2.setColor(Color.black);

        g2.setColor(Color.WHITE);

        g2.drawLine(115, 100, 115, (int) d.getHeight() + 100);
        g2.drawLine(100, 515, (int) d.getWidth() + 100, 515);

        g2.setColor(Color.red);

        for (Point p : points) {
            g2.drawOval(p.getX() + 100, p.getY() + 100, 1, 1);
        }

    }

}
