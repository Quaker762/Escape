package com.palmstudios.state;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import com.palmstudios.system.GameState;

public class VictoryState extends GameState
{
	private int score;
	private String scoreFile = "score.txt";
	private BufferedImage logo;

	public void load(String path)
	{
		try
		{
			Scanner scanner = new Scanner(new File(path));

			score = scanner.nextInt();

			scanner.close();
		} catch (IOException e)
		{

		}
		;
	}

	public VictoryState(GameStateManager gsm)
	{
		this.gsm = gsm;
		init();
	}

	@Override
	public void init()
	{
		// TODO Auto-generated method stub
		load(scoreFile);
		try
		{
			logo = ImageIO.read(new File("victory.png"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D g2d)
	{
		// TODO Auto-generated method stub
		g2d.drawImage(logo, 0, 0, logo.getWidth(), logo.getHeight(), null);
		g2d.drawString("Score: " + score, 200, 200);
	}

	@Override
	public void keyPressed(int k)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(int k)
	{
		// TODO Auto-generated method stub

	}

}
