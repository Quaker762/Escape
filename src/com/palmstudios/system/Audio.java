/**
 * 	@file
 * 
 * 	Loads and plays a sound file
 * 
 *	@date 24-5-2017
 *
 *	@author Jesse Buhagiar
 */
package com.palmstudios.system;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio
{
	private static Clip ac;
	
	public static void playSound(String fileName, int loop)
	{
		try
		{
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
			ac = AudioSystem.getClip();
			
			ac.open(ais);
			ac.loop(loop);
			ac.start();

		} catch (UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (LineUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void stopSound()
	{
		ac.stop();
	}
}
