import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameFrame extends JFrame{
	
	public GameFrame()
	{
		setSize(960,800);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RPG GAME");
		
		JLayeredPane lp = getLayeredPane();
		
		JLabel background = new JLabel(new ImageIcon("src\\BBackground.png"));
		background.setBounds(0,0,960,555);

		JLabel textBox = new JLabel(new ImageIcon("src\\960_255_box.png"));
		textBox.setBounds(0,535,960,255);
		
		lp.add(background, new Integer(1));
		lp.add(textBox, new Integer (1));
		
	}
