package ch.gibmit.insidersoundboard;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Sound {
    private AudioInputStream audioStream;
    private SourceDataLine sourceLine;
    private String name;
    private File soundFile;
    private URL soundURL;

    //Constructors
    public Sound(String name, String filePath) {
        this.name = name;
        this.soundFile = new File(filePath);
    }

    public Sound(String name, URL url) {
        this.name = name;
        this.soundURL = url;
    }

    public void play() {
        try {
            if (soundFile == null) {
                audioStream = AudioSystem.getAudioInputStream(soundURL);
            } else if (soundURL == null) {
                audioStream = AudioSystem.getAudioInputStream(soundFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        AudioFormat audioFormat = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
            sourceLine.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        int nBytesRead = 0;
        int BUFFER_SIZE = 128000;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }

    //Getters and Setters
    public String getName() {
        return name;
    }
}
