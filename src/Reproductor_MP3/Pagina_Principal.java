package Reproductor_MP3;

/**
 * @author Emersson
 */
import TelematicoTools.FormMouse.formRoot;
import Tipografias.Fuentes;
import jaco.mp3.player.MP3Player;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.sound.sampled.*;
import Ventana_Emergente.Emergente;
//import javazoom.jlgui.basicplayer.BasicPlayer;
//import javazoom.jlgui.basicplayer.BasicPlayerException;

public class Pagina_Principal extends javax.swing.JFrame {

    private Fuentes tipoFuente = new Fuentes();
    private File musicas[];
    private ArrayList<File> arhivosSeleccionados;
    private DefaultListModel modeloLista;
    private ArrayList<Integer> listaAleatorios = new ArrayList<Integer>();
    private int contadorClick = 0;
    private Emergente emergente;
    Barra_Duracion barra;
    MP3Player player;
    private String nombreCancion = "";
    String directorioActual = "C:\\Users\\lenovo\\Downloads\\Music";
    boolean repetir = false;
    boolean reducirVentana = false;
    private boolean aleatorio = false;
    private boolean pausar = false;
    private boolean reproducir = false;
    private boolean verificar;
    private int cancionActual = 0;
    private Timer tiempo;
    private Timer tiempoVentanaEmergente;
    private ActionListener accion;
    private ActionListener accionVerificar;

    public Pagina_Principal() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Le damos una nueva interfaz gráfica.
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

        }
        initComponents();  // Iniciamlizamos todos los elementos.
        this.setLocationRelativeTo(null);
        etiquetaTitulo.setText("Mi Reproductor");
        etiquetaMusica.setText("");
        player = new MP3Player();
        arhivosSeleccionados = new ArrayList<File>();
        modeloLista = new DefaultListModel();
        listaMusica.setModel(modeloLista);
        verificar = false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        etiquetaTitulo = new javax.swing.JLabel();
        etiquetaSalir = new javax.swing.JLabel();
        etiquetaMusicaReducido = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        etiquetaMusica = new javax.swing.JLabel();
        etiquetaTiempo = new javax.swing.JLabel();
        etiquetaSegundos = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        etiquetaPlay = new javax.swing.JLabel();
        etiquetaStop = new javax.swing.JLabel();
        etiquetaAtras = new javax.swing.JLabel();
        etiquetaAdelante = new javax.swing.JLabel();
        etiquetaAbrir = new javax.swing.JLabel();
        etiquetaAleatorio = new javax.swing.JLabel();
        progreso = new javax.swing.JProgressBar();
        volumen = new javax.swing.JSlider();
        porcentajeVolumen = new javax.swing.JLabel();
        ecualizadorReproductor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMusica = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etiquetaTitulo.setFont(tipoFuente.fuente(tipoFuente.Hunterra, 2, 20));
        etiquetaTitulo.setText("Mi Reproductor");
        etiquetaTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        etiquetaTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etiquetaTituloMouseClicked(evt);
            }
        });

        etiquetaSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir2.png"))); // NOI18N
        etiquetaSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        etiquetaSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etiquetaSalirMouseClicked(evt);
            }
        });

        etiquetaMusicaReducido.setFont(tipoFuente.fuente(tipoFuente.Theano, 2, 15));
        etiquetaMusicaReducido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etiquetaMusicaReducidoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiquetaMusicaReducido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiquetaSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(etiquetaTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiquetaMusicaReducido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        etiquetaMusica.setFont(tipoFuente.fuente(tipoFuente.Theano, 2, 20));
        etiquetaMusica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaMusica.setText("PLAYING");
        etiquetaMusica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etiquetaMusicaMouseClicked(evt);
            }
        });

        etiquetaTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTiempo.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(etiquetaSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(etiquetaMusica, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(etiquetaMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etiquetaTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiquetaSegundos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        etiquetaPlay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/playAzul.png"))); // NOI18N
        etiquetaPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        etiquetaPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etiquetaPlayMouseClicked(evt);
            }
        });

        etiquetaStop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/detenerAzul.png"))); // NOI18N
        etiquetaStop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        etiquetaStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etiquetaStopMouseClicked(evt);
            }
        });

        etiquetaAtras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        etiquetaAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        etiquetaAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etiquetaAtrasMouseClicked(evt);
            }
        });

        etiquetaAdelante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaAdelante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/adelante.png"))); // NOI18N
        etiquetaAdelante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        etiquetaAdelante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etiquetaAdelanteMouseClicked(evt);
            }
        });

        etiquetaAbrir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reiniciar.png"))); // NOI18N
        etiquetaAbrir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        etiquetaAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etiquetaAbrirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaAdelante, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaStop, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaPlay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiquetaAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(etiquetaAdelante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(etiquetaStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(etiquetaAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        etiquetaAleatorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaAleatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aleatorioazul.png"))); // NOI18N
        etiquetaAleatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        etiquetaAleatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etiquetaAleatorioMouseClicked(evt);
            }
        });

        volumen.setMajorTickSpacing(10);
        volumen.setPaintLabels(true);
        volumen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volumenStateChanged(evt);
            }
        });

        porcentajeVolumen.setText("0 %");

        listaMusica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMusicaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaMusica);

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(etiquetaAleatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 502, Short.MAX_VALUE)
                        .addComponent(porcentajeVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(volumen, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(progreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ecualizadorReproductor, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(volumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(porcentajeVolumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etiquetaAleatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ecualizadorReproductor, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(16, Short.MAX_VALUE))
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

    private void etiquetaPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiquetaPlayMouseClicked
        if (arhivosSeleccionados.size() != 0 && reproducir == true) { // Verificamos si al menos hay una  canción.
            etiquetaPlay();
        }

    }//GEN-LAST:event_etiquetaPlayMouseClicked

    public void etiquetaPlay() {
        if (pausar == false) {  // Cambiamos de icono al de pause, ya que se dio play.
            pausar = true;
            player.pause(); // Pausamos la música.
            tiempo.stop(); // Pausamos el progreso.
            etiquetaPlay.setIcon(new ImageIcon(getClass().getResource("/Imagenes/playAzul.png")));
        } else {
            pausar = false; // Como se dio play, ahora se dio a pause y cambiamos el icono.
            player.play();  // Renaudamos la música en el momento que se pausó.
            tiempo.start(); // Renaudamos el progreso de la música.
            etiquetaPlay.setIcon(new ImageIcon(getClass().getResource("/Imagenes/pausarAzul.png")));
        }
    }
    private void etiquetaStopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiquetaStopMouseClicked
        pausar = false;
        etiquetaPlay();
        player.stop(); // Apagamos la música.
    }//GEN-LAST:event_etiquetaStopMouseClicked

    private void etiquetaAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiquetaAtrasMouseClicked
        if (evt.getClickCount() == 2) {  // Si dio dos clicks significa que va a retroceder la música.
            if (cancionActual == 0) {
                cancionActual = arhivosSeleccionados.size(); // Si la canción es la primera le decimos que sea la última ya que va a retroceder.
            }
            tiempo.stop();  // Apagamos la música.
            progreso.setValue(0); // El progreso vulve a estar en cero.
            cancionActual -= 1; // Le restamos una posición a la canción.
            reproducirMusica(arhivosSeleccionados.get(cancionActual)); // Mandamos la canción a ser reproducida.

        } else {
            reproducirMusica(arhivosSeleccionados.get(cancionActual)); // Si dio un click, se va a repetir la misma canción.
            progreso.setValue(0); // El progreso vulve a estar en cero.
        }

    }//GEN-LAST:event_etiquetaAtrasMouseClicked

    private void etiquetaAleatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiquetaAleatorioMouseClicked
        if (aleatorio == false) {
            aleatorio = true;  // El modo aleatorio está activado.
            etiquetaAleatorio.setIcon(new ImageIcon(getClass().getResource("/Imagenes/aleatorioazulOscuro.png")));

        } else {
            aleatorio = false;  // El modo aleatorio está desactivado.
            etiquetaAleatorio.setIcon(new ImageIcon(getClass().getResource("/Imagenes/aleatorioazul.png")));
            listaAleatorios.clear(); // Borramos los datos del aleatorio.
        }
    }//GEN-LAST:event_etiquetaAleatorioMouseClicked

    public int aleatorio(ArrayList<Integer> lista) {
        Random randon = new Random();
        cancionActual = randon.nextInt(arhivosSeleccionados.size()); // Generamos números aleatorios hasta el maximo de musicas.
        if (lista.size() == arhivosSeleccionados.size()) { // Si ya generó todos los números aleatorios, entonces, 
            listaAleatorios.clear(); // le decimos que empiece de nuevo.
            System.out.println("............Terminarón todas las canciones....................");
            return aleatorio(lista); // Retornamos el nuevo número aleatorio.
        } else {

            if (!lista.contains(cancionActual)) { // Aquí verificamos que el número aleatorio no se repita.
                return cancionActual; // Si no es repetido retornamos el número.
            } else {
                return aleatorio(lista); // Si se repite, utilizamos la recursividad, y mandamos a llamar a este mismo método.
            }
        }
    }


    private void etiquetaSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiquetaSalirMouseClicked
        System.exit(0);  // Salimos del programa.
    }//GEN-LAST:event_etiquetaSalirMouseClicked

    private void etiquetaAbrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiquetaAbrirMouseClicked
        JFileChooser abrirMusica = new JFileChooser(directorioActual); // Le mandamos la posición del directorio.
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.mp3", "mp3"); // Agregamos la extensión del mp3
        abrirMusica.setMultiSelectionEnabled(true);  // Activamos la selección múltiple
        abrirMusica.setFileFilter(filtro);  // Agregamos el filtro dentro de la ventana, para que busque solo la extensión de músicas.
        int resultado = abrirMusica.showOpenDialog(null);
        musicas = abrirMusica.getSelectedFiles(); // Agresmos las músicas al arreglo de archivos.
        int cont = 0;
        if (resultado == JFileChooser.APPROVE_OPTION) { // Si se seleccionó una música se entra.
            for (File musica : musicas) { // Recorremos el arreglo de musicas.
                if (valirdarMusica(musica)) { // Validamos que la música no sea repetida.
                    arhivosSeleccionados.add(musica);  // Agregamos a un nuevo arreglo de musica, esto para trabajar con el mismo.
                    modeloLista.addElement(musica.getName()); // Agregamos la música en la lista.
                    cont++;
                }
            }
            if (cont != 0) { // Si contador es cero, no se agregado ninguna música.
                System.out.println("Se han agregado " + cont + "  canciones.");
            }
        }
    }//GEN-LAST:event_etiquetaAbrirMouseClicked

    public boolean valirdarMusica(File musica) {  // Aquí validamos si la música que se va a agregar a la lista no se repita, 
        boolean valido = true;
        for (int i = 0; i < arhivosSeleccionados.size(); i++) { // Buscamos entre todas las música para verificar si está.
            if (musica.getAbsolutePath().equals(arhivosSeleccionados.get(i).getAbsolutePath())) {
                valido = false;
                return valido; // Si se repite se retorno false,
            }
        }
        return valido; // Si no se repite se retorna verdadero.
    }

    private void etiquetaTituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiquetaTituloMouseClicked
        if (evt.getClickCount() == 2) {
            cambiarTamaño();
        }
    }//GEN-LAST:event_etiquetaTituloMouseClicked

    public void cambiarTamaño() {

        if (reducirVentana == false) {
            reducirVentana = true;
            this.setSize(new Dimension(this.getSize().width, 120));  // Reducimos la ventana.
            etiquetaMusicaReducido.setText(nombreCancion);
            etiquetaMusica.setText("");
        } else {
            reducirVentana = false;
            this.setSize(new Dimension(this.getSize().width, 620));  // Regresamos a la ventana a su tamaño normal.
            etiquetaTitulo.setFont(tipoFuente.fuente(tipoFuente.Hunterra, 2, 20)); // Cambiamos el tipo de fuente del título.
            etiquetaMusica.setText(nombreCancion);
            etiquetaMusicaReducido.setText("");
        }
    }
    private void listaMusicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMusicaMouseClicked

        if (evt.getClickCount() == 2) { // Si damos dos clicks se entra.
            cancionActual = listaMusica.getSelectedIndex(); // Buscamos en que posición de la lista se hizo los dos clicks.
            reproducirMusica(arhivosSeleccionados.get(cancionActual)); // Buscamos la música en el arreglo de musica y le mandamos a reproducir.
            reproducir = true;
            pausar = false;
            etiquetaPlay.setIcon(new ImageIcon(getClass().getResource("/Imagenes/pausarAzul.png")));

        }

    }//GEN-LAST:event_listaMusicaMouseClicked

    private void etiquetaAdelanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiquetaAdelanteMouseClicked
        if (aleatorio == false) { // Si el modo aleatio está desactivado entramos.
            cancionActual++;
            if (cancionActual == arhivosSeleccionados.size()) { // Si la musica es la última le decimos que va a reproducir la primer.
                cancionActual = 0;
                reproducirMusica(arhivosSeleccionados.get(cancionActual)); // Le mandamos ls primera canción.
            } else {
                reproducirMusica(arhivosSeleccionados.get(cancionActual)); // Le mandamos la canción siguiente.
            }
            pausar = true;
            etiquetaPlay();
        } else {
            listaAleatorios.add(aleatorio(listaAleatorios)); // Obtemos números aleatorios de 0 hasta el tamaño mazimo de las canciones, sin repetirse.
            reproducirMusica(arhivosSeleccionados.get(cancionActual)); // Le mandomos una cación x.
        }
    }//GEN-LAST:event_etiquetaAdelanteMouseClicked

    private void volumenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volumenStateChanged
        porcentajeVolumen.setText(String.valueOf(volumen.getValue()));
    }//GEN-LAST:event_volumenStateChanged

    private void etiquetaMusicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiquetaMusicaMouseClicked
        if (evt.getClickCount() == 2) {
            cambiarTamaño();
        }
    }//GEN-LAST:event_etiquetaMusicaMouseClicked

    private void etiquetaMusicaReducidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiquetaMusicaReducidoMouseClicked
        if (evt.getClickCount() == 2) {
            cambiarTamaño();
        }
    }//GEN-LAST:event_etiquetaMusicaReducidoMouseClicked

    public void reproducirMusica(File musica) {
        listaMusica.setSelectionInterval(cancionActual, cancionActual); // Que se prenda el foco en la fila de la música que se va a reproducir.
        player.addToPlayList(musica); // Agregamos la música en la lista para reproducirla.
        player.skipForward(); // Esto para que solo se reproduzca la música que le hemos mandado.

        nombreCancion = musica.getName(); // Obtenemos el nombre de la canción.
        try {
            URL url = musica.getAbsoluteFile().toURL(); // Guardamos la URL de la canción, esto para en la clase Barra_Duración me indique 
            barra = new Barra_Duracion(url);  // cuántos segundos y minutos tiene la cación y la guardamos dentro de barra.
            etiquetaMusica.setText(nombreCancion);  // Agregamos el título de la canción en la ventana.
            if (verificar == false) { // Aquí es solo para la primera música que se va a reproducir.
                verificar = true; // Quiere decir que ya hay una música en la reproducción.
                contadorClick = 5; // Es para que no entre en la condición siguiente. 
            } else {
                tiempo.stop(); // Aquí apagamos la canción actual, por que va a reproducir una nueva canción.
            }

            if (contadorClick < 4) { // Si pasamos a una nueva canción, y la ventana emergente no adesaparecido, entonces,
                emergente.dispose(); // le decimos que se cierre, para que aparezca la nueva ventana emergente.
                tiempoVentanaEmergente.stop(); // Reiniciamo el tiempo que nos ayuda a realizar esa verificación.
            }
            emergente = new Emergente(this, false, musica.getName());  // Instanciamos la ventana emergente.
            emergente.setVisible(true); // La hacemos visible.
            emergente.iniciarVentana(); // Iniciamos  el movimiento de la ventana emergente.
            mandarMusica(barra); // Le mandamos la dirreción de canción para sacer su duración.
        } catch (MalformedURLException ex) {

        }

    }

    public void mandarMusica(Barra_Duracion barra) {
        progreso.setMaximum(barra.getDuracionEnSegundos()); // Le decimos al progresmo cuál va ser su maximo.
        progreso.setValue(0);  // Inicializamos en cero al progreso.
        contadorClick = 0; // Esto para hacer la verificación de la ventana emergente.
        etiquetaTiempo.setText(barra.getDuracion()); // Agregamos el tiempo de duración de la canción en la ventana.
        player.play(); // Reproducimos la música.
        tiempo = new Timer(1000, iniciarTimer(barra.getDuracionEnSegundos()));//Inicializamos el timer cada segundo, para que el progreso se valla llenando.
        tiempo.start(); // Le decimos que comienze el tiempo.
        tiempoVentanaEmergente = new Timer(1000, verificarTimer()); // Aquí inicializamos la ventana emergente, para verificar si ya se cerro o no.
        tiempoVentanaEmergente.start(); // Empezamos el conteo.
    }

    public ActionListener iniciarTimer(int segundos) { // Aquí vamos a recorrer el tiempo de la canción.
        accion = new ActionListener() {
            int axu = 0, axu1 = 0;

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (progreso.getValue() < segundos) {
                    progreso.setValue(progreso.getValue() + 1); // Vamos llenando el progreso uno a uno.
                    axu++;
                    if (axu < 60) { // Se entra si no han superado los 59 los segundos.
                        etiquetaSegundos.setText(axu1 + ":" + axu); // Agregamos a la etiqueta los segundos.
                    } else { // Se entra se ya tenemos, por lo mínimo 1 minuto.
                        axu1++; 
                        axu = 0; // Reiniciamos los segundos.
                        etiquetaSegundos.setText(axu1 + ":" + axu); // Agregamos a la etiqueta los minutos y segundos.
                    }

                } else {
                    tiempo.stop(); // Si se llegue al tiempo máximo se reinicia el tiempo.
                }
            }
        };
        return accion; // Retornamos la acción.
    }

    public ActionListener verificarTimer() { // Aquí verificamos que la ventana emergente no se colapse, si damos un click
        accionVerificar = new ActionListener() { // en el momento que, la misma esté presente, es decir, que aún 
            @Override                            // aparezca en la pantalla, entonces que se reanude la ventata emergente.
            public void actionPerformed(ActionEvent ae) {
                contadorClick++;
                System.out.println(contadorClick);
                if (contadorClick == 3) {
                    tiempoVentanaEmergente.stop(); // Si detenemos el tiempo significa que la ventana emergente ya desaparecio.
                }
            }
        };
        return accionVerificar;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pagina_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ecualizadorReproductor;
    private javax.swing.JLabel etiquetaAbrir;
    private javax.swing.JLabel etiquetaAdelante;
    private javax.swing.JLabel etiquetaAleatorio;
    private javax.swing.JLabel etiquetaAtras;
    private javax.swing.JLabel etiquetaMusica;
    private javax.swing.JLabel etiquetaMusicaReducido;
    private javax.swing.JLabel etiquetaPlay;
    private javax.swing.JLabel etiquetaSalir;
    private javax.swing.JLabel etiquetaSegundos;
    private javax.swing.JLabel etiquetaStop;
    private javax.swing.JLabel etiquetaTiempo;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaMusica;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JLabel porcentajeVolumen;
    private javax.swing.JProgressBar progreso;
    private javax.swing.JSlider volumen;
    // End of variables declaration//GEN-END:variables

}
