import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {

	private File bGSound;
	private File biteSound;
	private File failSound;
	private AudioInputStream aIS1;
	private AudioInputStream aIS2;
	private AudioInputStream aIS3;
	private Clip clip1;
	private Clip clip2;
	private Clip clip3;

	public Sound() {
		bGSound = new File("coconut-land.wav");
		biteSound = new File("bite.wav");
		failSound = new File("fail.wav");

	}

	public void playBGSound() {
		try {
			aIS1 = AudioSystem.getAudioInputStream(bGSound);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		clip1 = null;
		try {
			clip1 = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			clip1.open(aIS1);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		clip1.loop(Clip.LOOP_CONTINUOUSLY);
		clip1.start();
	}
	


	public void playBiteSound() {
		try {
			aIS2 = AudioSystem.getAudioInputStream(biteSound);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		clip2 = null;
		try {
			clip2 = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			clip2.open(aIS2);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		clip2.start();
	}

	public void playFailSound() {
		try {
			aIS3 = AudioSystem.getAudioInputStream(failSound);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		clip3 = null;
		try {
			clip3 = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			clip3.open(aIS3);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		clip3.start();
	}
	
	public void stopSound(){
		clip1.close();
		if (clip2 != null) {
			clip2.close();
		}
		if (clip3 != null) {
			clip3.close();
		}
	}
	
	

}
