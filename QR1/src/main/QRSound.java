package main;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class QRSound {
	static final int QUOTE1 = 1; // Go to engineering message
	static final int QUOTE2 = 2;
	static final int QUOTE3_4 = 3;
	static final int QUOTE5 = 4;
	static final int QUOTE6 = 5;
	static final int QUOTE7 = 6;
	static final int QUOTE8 = 7;
	static final int QUOTE9 = 8;
	static final int QUOTE10_11 = 9;
	static final int QUOTE12 = 10;
	static final int QUOTE13 = 11;
	public static void delayfor(int n)
	{
		try {
		    Thread.sleep(n * 1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
    /*
	 * Method is passed a sound flag it will play that sound there is only one
	 * currently supported. To use this sound - call new playit(SOUND);
	 */
	public static void playit(int soundRequired) {
		String fn = null;
		File sound; 
        URL location = QRSound.class.getProtectionDomain().getCodeSource().getLocation();
        
		switch (soundRequired) {
		case QUOTE1:
			fn = location.getFile() + "../src/resources/Quote1.wav";
			break;
		case QUOTE2:
			fn = location.getFile() + "../src/resources/Quote2.wav";
			break;
		case QUOTE3_4:
			fn = location.getFile() + "../src/resources/Quote3&4.wav";
			break;
		case QUOTE5:
			fn = location.getFile() + "../src/resources/Quote5.wav";
			break;
		case QUOTE6:
			fn = location.getFile() + "../src/resources/Quote6.wav";
			break;
		case QUOTE7:
			fn = location.getFile() + "../src/resources/Quote7.wav";
			break;
		case QUOTE8:
			fn = location.getFile() + "../src/resources/Quote8.wav";
			break;
		case QUOTE9:
			fn = location.getFile() + "../src/resources/Quote9.wav";
			break;
		case QUOTE10_11:
			fn = location.getFile() + "../src/resources/Quote10&11.wav";
			break;
		case QUOTE12:
			fn = location.getFile() + "../src/resources/Quote12.wav";
			break;
		case QUOTE13:
			fn = location.getFile() + "../src/resources/Quote13.wav";
			break;

		default:
			break;

		}

		// Go for it!
		try {
			// Open an audio input stream.
			sound = new File(fn);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
			// plays
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
