/**
 * 	@file
 * 
 *	@date
 *
 *	@author Jesse Buhagiar
 */
package com.palmstudios.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.sound.sampled.Clip;

import com.palmstudios.system.Audio;
import com.palmstudios.system.GamePanel;
import com.palmstudios.system.GameState;

/**
 * @author quaker
 *
 */
public class CreditsState extends GameState
{
	private String credits;
	private int y;
	private int height;
	private int timer;
	
	public CreditsState(GameStateManager gsm)
	{
		this.gsm = gsm;
		init();
	}
	
	private void drawString(Graphics2D g2d, String str, int x, int y)
	{
		for(String line: str.split("\n"))
		{
			g2d.drawString(line, (GamePanel.WIDTH - line.length()) / 6, y += g2d.getFontMetrics().getHeight());
		}
	}
	
	public void init()
	{
		timer = 3;
		try 
		{
			File file = new File("data/credits.txt");
			//init array with file length
			byte[] data = new byte[(int) file.length()];

			FileInputStream fis = new FileInputStream(file);
			fis.read(data); //read file into bytes[]
			fis.close();
			
			credits = new String(data);
			System.out.println(credits);
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		
		y = 480;
		Audio.playSound("data/snd/credits.wav", Clip.LOOP_CONTINUOUSLY);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update()
	{
		if(timer <= 0)
		{
			timer = 3;
			y -= 1;
		}
		
		timer--;
		
	}

	@Override
	public void draw(Graphics2D g2d)
	{
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, 640, 480);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("constantine", Font.PLAIN, 18));
		drawString(g2d, credits, 100, y);
	}

	@Override
	public void keyPressed(int k)
	{
		if(k != 0)
		{
			Audio.stopSound();
			gsm.unloadState(gsm.getNumberStates() - 1);
			gsm.changeState(GameStateManager.MENU_STATE);
		}
		
	}

	@Override
	public void keyReleased(int k)
	{
		// TODO Auto-generated method stub
		
	}
	
}
