package Ventana_Emergente;

import com.sun.awt.AWTUtilities;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.util.Timer;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Emergente extends javax.swing.JDialog {

    Timer timer = null;
    TimerTask task;
    private int x = 0;
    private int height;
    private int width;
    private int contadorClick = 0;
    boolean ejecutar;
    private int co = 0;

    public Emergente(java.awt.Frame parent, boolean modal, String titulo) {
        super(parent, modal);

        initComponents();
        etiquetaCancion.setText(titulo);
        ubicar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new fondo();
        etiquetaLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        etiquetaCancion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Emersson Romero");
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);

        etiquetaLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carpetaLogo3.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Cooper Black", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Reproduciendo...");

        etiquetaCancion.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        etiquetaCancion.setForeground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiquetaCancion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ubicar() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  // Obtenemos el ancho y el largo de la pantalla.
        width = screenSize.width;  // El ancho de la pantalla.
        height = screenSize.height - (72 * 2); // Lo largo de la pantalla.
        this.setLocation(width, height); // Establecemos la posición de la ventana./
        x = width;
    }

    public void iniciarVentana() {
        co = 0;
        //HILO DE PROGRMACIÓN
        new Thread(new Runnable() {
            @Override
            public void run() { 
                while (co <= 348) { 
                    try {
                        Thread.sleep(10); // Que se duerma 10 milesegundos.
                        contadorClick += 8;
                        moverVentanaDerecha(contadorClick);  // Movemos la ventana a la izquierda.
                        co += 8;
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }).start();
    }

    public void moverVentanaDerecha(int cont) {
        if (cont < 348) { 
            this.setLocation(x - cont, height);
        } else { // Va a entra siempre y cuando el iniciarVentana hallá acabado su ejecución.
            try { // Entonces ejecutamos este código.
                x -= cont; // Obtenemos la posición de la ventana.
                Thread.sleep(2500); // Esperamos que se detenga 2.5 segundos
                for (int i = 0; i < cont; i += 4) {
                    this.setLocation(x + i, height); // MOvemos la ventana a la izquierda para esconderla.
                    Thread.sleep(3);
                }
            } catch (InterruptedException ex) {

            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiquetaCancion;
    private javax.swing.JLabel etiquetaLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelFondo;
    // End of variables declaration//GEN-END:variables

    class fondo extends JPanel {

        private Image ima;

        @Override
        public void paint(Graphics g) {
            ima = new ImageIcon(getClass().getResource("/Imagenes/negro.jpg")).getImage();
            g.drawImage(ima, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }

    }

}
