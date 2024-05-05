import javax.sound.sampled.*;
import java.io.*;

public class VoiceRecorderApp {
    private static final String OUTPUT_FILE = "recorded_audio.wav";

    public static void main(String[] args) {
        System.out.println("Voice Recorder App");

        try {
            AudioFormat format = new AudioFormat(16000, 16, 1, true, true);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(info);

            targetLine.open(format);
            targetLine.start();

            System.out.println("Recording...");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int numBytesRead;
            byte[] data = new byte[targetLine.getBufferSize() / 5];

            while (true) {
                numBytesRead = targetLine.read(data, 0, data.length);
                out.write(data, 0, numBytesRead);
                if (numBytesRead < data.length) {
                    break;
                }
            }

            targetLine.stop();
            targetLine.close();

            System.out.println("Recording stopped.");

            // Save recorded audio to file
            byte[] audioData = out.toByteArray();
            saveToFile(audioData);
            System.out.println("Recording saved to file: " + OUTPUT_FILE);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveToFile(byte[] audioData) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(audioData);
            AudioInputStream audioInputStream = new AudioInputStream(bais, new AudioFormat(16000, 16, 1, true, true), audioData.length / 2);
            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, new File(OUTPUT_FILE));
            audioInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
