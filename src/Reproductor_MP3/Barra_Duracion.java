package Reproductor_MP3;

/**
 *
 * @author Emersson
 */
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.media.CannotRealizeException;
import javax.media.Codec;
import javax.media.Format;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.format.AudioFormat;
import javax.swing.JSlider;

public class Barra_Duracion {

    Player player;
    int velocidad = 1000;
    int cuadro;
    Timer tiempo;
    TimerTask tarea;
    boolean reproduciendo;

    public Barra_Duracion(URL url) {
        // Esta es la direccion del codec que decodifica los mp3 
        String jffmpegAudioDecoder = "net.sourceforge.jffmpeg.AudioDecoder";
        // Cargamos el codec y lo guardamos en un objeto de tipo Codec 
        Codec codecAudio = null;

        try {
            codecAudio = (Codec) Class.forName(jffmpegAudioDecoder).newInstance();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        // Agregamos los codec al PlugInManager 
        PlugInManager.addPlugIn(jffmpegAudioDecoder, codecAudio.getSupportedInputFormats(), new Format[]{new AudioFormat("LINEAR")}, PlugInManager.CODEC);
        try {
            player = Manager.createRealizedPlayer(url); // Obtenemos los datos de la canción.

        } catch (NoPlayerException | CannotRealizeException | IOException e) {
            e.printStackTrace();
        }
    }

    public String getDuracion() {
        String cad = "";
        double segundos = player.getDuration().getSeconds();
        System.out.println("Los segundos son: " + segundos);
        int minutos = (int) (segundos / 60); // Obtenemos los minutos de la canción.
        for (int i = 0; i < minutos; i++) {
            segundos = segundos - 60; // Obtenemos los segundos restantes, si hay.
        }
        int segundosAux = (int) (segundos); // A los segundos restantes los pasamos a un entero.

        cad += minutos + ":"; // Agregamos los minutos de la canción, si tiene minutos.
        if (segundosAux < 10) { // Si los segundos restantes son menores que 10 agregamos un cero adelante.
            cad += "0";
        }
        cad += segundosAux; // Ponemos los segundos restantes.
        return cad;
    }

    public int getDuracionEnSegundos() {
        int segundos = (int) player.getDuration().getSeconds(); // Obtenemos la duración en segundos de la canción.
        return segundos; // Retornamos los segundos.
    }

}
