package logo;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 * @author Emersson
 */
public class Logo extends javax.swing.JFrame {

    private Timer tiempo;
    private ActionListener accion;

    public Logo() {
        tiempo = new Timer(500, iniciarTimer());// Iniciamos el timer, para que nos apareza el tiempo y el efecto.
        ventanaTransparente(); // Ponemos a la ventana ent transparente, para que solo se vean la imagen.
        initComponents();
        panelFondo.setOpaque(false); // Desactivamos la opacidad del panel. 
        this.progreso.setVisible(true); 
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/logo.png")).getImage()); // Agregamos la imagen png en la ventana.
        this.setLocationRelativeTo(null); // La ponemos en el centro de la pantalla.
        tiempo.start(); // Iniciamos el tiempo.
    }

    public void mostrarVentana() {
        this.dispose();
        new Reproductor_MP3.Pagina_Principal().setVisible(true); // Mostramos la ventana del reproductor de música.
    }

    public void ventanaTransparente() {
        setUndecorated(true); // Activamos para que no aparezca el minimizar, maximizar y salir.
        setBackground(new Color(0, 0, 0, 0)); // La ponemos en tranparencia total a la ventana.
    }

    public ActionListener iniciarTimer() {
        accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (progreso.getValue() < 100) {
                    progreso.setValue(progreso.getValue() + 15); // Agregamos el tiempo del progreso.
                    int valor = progreso.getValue();
                    if ((valor % 2) == 0) { // Agregmos el efecto de que se prende y se apaga la imagen.
                        etiquetaLogo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logo.png")));
                    } else {
                        etiquetaLogo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logo1.png")));
                    }

                } else {
                    tiempo.stop(); // Ya finalizado tenemos el tiempo y llamamos a la ventana principal.
                    mostrarVentana();
                }
            }
        };
        return accion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progreso = new javax.swing.JProgressBar();
        panelFondo = new javax.swing.JPanel();
        etiquetaLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        progreso.setBackground(new java.awt.Color(0, 0, 0));
        progreso.setForeground(new java.awt.Color(153, 255, 153));
        getContentPane().add(progreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 170, 10));

        etiquetaLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png"))); // NOI18N
        panelFondo.add(etiquetaLogo);

        getContentPane().add(panelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiquetaLogo;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JProgressBar progreso;
    // End of variables declaration//GEN-END:variables
}
