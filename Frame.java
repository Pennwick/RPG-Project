import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame
{
	private static final int FRAME_WIDTH = 640;
	private static final int FRAME_HEIGHT = 480;
	
	private int day = 1;
	private int turnControl = 1;
	private int townGold;
	private JLabel playerInfo;
	private JLabel playerInstruct;
	private JLabel dayCount;
	private JLabel player1BattleInfo;
	private JLabel player2BattleInfo;
	private JLabel player1Health;
	private JLabel player2Health;
	private JLabel player1Turn;
	private JLabel player2Turn;
	private JPanel playerInfoPanel;
	private JPanel playerInstructPanel;
	private JPanel buttonPanel;
	private JPanel battleButtonPanel;
	private JPanel player1BattleInfoPanel;
	private JPanel player2BattleInfoPanel;
	private JButton townButton;
	private JButton trainButton;
	private JButton huntButton;
	private JButton restButton;
	private JButton armorButton;
	private JButton weaponButton;
	private JButton potionButton;
	private JButton backButton;
	private JButton powerButton;
	private JButton enduranceButton;
	private JButton attackButton;
	private JButton defendButton;
	private ActionListener townListener;
	private ActionListener trainListener;
	private ActionListener huntListener;
	private ActionListener restListener;
	private ActionListener armorListener;
	private ActionListener weaponListener;
	private ActionListener potionListener;
	private ActionListener backListener;
	private ActionListener powerListener;
	private ActionListener enduranceListener;
	private ActionListener attackListener;
	private ActionListener defendListener;
	
	Player player1 = new Player( 100, 20, 10, 5, 100 );
	Player player2 = new Player( 100, 20, 10, 5, 100 );
	Training newTrainer = new Training();
	Battle newBattle = new Battle();
	
	Player currentPlayer = player1;
	
	Font f = new Font( "Serif", Font.PLAIN, 20 );
	
	public Frame()
	{
		//create initial button, player info and main instruction panels
		createButtonPanel();
		createPlayerInfoPanel();
		createPlayerInstructPanel();
		setSize( FRAME_WIDTH, FRAME_HEIGHT );
	}
	
	public void createButtonPanel()
	{
		//main screen buttons
		buttonPanel = new JPanel();
		add( buttonPanel, BorderLayout.SOUTH );
		buttonPanel.setLayout( new GridLayout( 2, 2 ) );
		
		townButton = new JButton( "Town" );
		trainButton = new JButton( "Train" );
		huntButton = new JButton( "Hunt" );
		restButton = new JButton( "Rest" );
		
		townListener = new TownButtonListener();
		trainListener = new TrainButtonListener();
		huntListener = new HuntButtonListener();
		restListener = new RestButtonListener();
		
		buttonPanel.add( townButton );
		townButton.addActionListener( townListener );
		buttonPanel.add( trainButton );
		trainButton.addActionListener( trainListener );
		buttonPanel.add( huntButton );
		huntButton.addActionListener( huntListener );
		buttonPanel.add( restButton );
		restButton.addActionListener( restListener );
		
		//town room buttons
		armorButton = new JButton( "Armor 200g" );
		weaponButton = new JButton( "Weapon 200g" );
		potionButton = new JButton( "Potion 300g" );
		backButton = new JButton( "Back" );
		
		armorListener = new ArmorButtonListener();
		weaponListener = new WeaponButtonListener();
		potionListener = new PotionButtonListener();
		backListener = new BackButtonListener();
		
		armorButton.addActionListener( armorListener );
		weaponButton.addActionListener( weaponListener );
		potionButton.addActionListener( potionListener );
		backButton.addActionListener( backListener );
		
		//train room buttons
		powerButton = new JButton( "Power" );
		enduranceButton = new JButton( "Endurance" );
		
		powerListener = new PowerButtonListener();
		enduranceListener = new EnduranceButtonListener();
		
		powerButton.addActionListener( powerListener );
		enduranceButton.addActionListener( enduranceListener );
	}
	
	public void createPlayerInfoPanel()
	{
		playerInfoPanel = new JPanel();
		add( playerInfoPanel, BorderLayout.NORTH );
		playerInfoPanel.setLayout( new BorderLayout() );
		
		playerInfo = new JLabel( "" );
		playerInfo.setFont( f );
		playerInfoPanel.add( playerInfo, BorderLayout.NORTH );
		
		dayCount = new JLabel( "Day: " + day );
		dayCount.setFont( f );
		playerInfoPanel.add( dayCount, BorderLayout.SOUTH );
		
		updateStats();
	}
	
	public void createPlayerInstructPanel()
	{
		playerInstructPanel = new JPanel();
		add( playerInstructPanel, BorderLayout.CENTER );
		playerInstruct = new JLabel( "Please select an action" );
		playerInstruct.setFont( f );
		add( playerInstruct, BorderLayout.CENTER );
	}
	
	public void updateStats()
	{
		String playerName = "";
		
		if ( currentPlayer == player1 )
		{
			playerName = "Player 1";
		}
		else
		{
			playerName = "Player 2";
		}
		
		playerInfo.setText( playerName + " Health: " + currentPlayer.getHealth() + " / " + currentPlayer.getMaxHealth() 
				+ " Power: " + currentPlayer.getPower() + " Endurance: " + currentPlayer.getEndurance() 
				+ " Speed: " + currentPlayer.getSpeed() + " Gold: " + currentPlayer.getGold() );
	}
	
	public void updateDay()
	{
		dayCount.setText( "Day: " + day );
		
		if ( ( currentPlayer == player1 ) && ( day > 10 ) )
		{
			currentPlayer = player2;
			day = 1;
			updateStats();
			updateDay();
		}
		
		if ( ( currentPlayer == player2 ) && ( day > 10 ) )
		{
			startBattle();
		}
	}
	
	public void startBattle()
	{
		//clear screen
		remove( buttonPanel );
		remove( playerInfoPanel );
		
		player1BattleInfoPanel = new JPanel();
		add( player1BattleInfoPanel, BorderLayout.WEST );
		player1BattleInfoPanel.setLayout( new GridLayout( 3, 1 ) );
		
		playerInstruct.setText( "Attack or Defend!" );
		
		//create player 1 info on left side
		player1BattleInfo = new JLabel( "Player 1" );
		player1BattleInfo.setFont( f );
		player1Health = new JLabel( player1.getHealth() + " / " + player1.getMaxHealth() );
		player1Health.setFont( f );
		player1Turn = new JLabel( "" );
		player1Turn.setFont( f );
		player1BattleInfoPanel.add( player1BattleInfo );
		player1BattleInfoPanel.add( player1Health );
		player1BattleInfoPanel.add( player1Turn );
		
		player2BattleInfoPanel = new JPanel();
		add( player2BattleInfoPanel, BorderLayout.EAST );
		player2BattleInfoPanel.setLayout( new GridLayout( 3, 1 ) );
		
		//create player 2 info on right side
		player2BattleInfo = new JLabel( "Player 2" );
		player2BattleInfo.setFont( f );
		player2Health = new JLabel( player2.getHealth() + " / " + player2.getMaxHealth() );
		player2Health.setFont( f );
		player2Turn = new JLabel( "" );
		player2Turn.setFont( f );
		player2BattleInfoPanel.add( player2BattleInfo );
		player2BattleInfoPanel.add( player2Health );
		player2BattleInfoPanel.add( player2Turn );
		
		//battle buttons
		battleButtonPanel = new JPanel();
		add( battleButtonPanel, BorderLayout.SOUTH );
		battleButtonPanel.setLayout( new GridLayout( 1, 2 ) );
		
		attackButton = new JButton( "Attack" );
		defendButton = new JButton( "Defend " );
		
		attackListener = new AttackButtonListener();
		defendListener = new DefendButtonListener();
		
		battleButtonPanel.add( attackButton );
		attackButton.addActionListener( attackListener );
		battleButtonPanel.add( defendButton );
		defendButton.addActionListener( defendListener );
		
		validate();
		repaint();
		
		//set up battle by determining turn order
		newBattle.startTurn( player1, player2 );
		
		if ( player1 == newBattle.getFirst() )
		{
			player1Turn.setText( "GO!" );
		}
		else
		{
			player2Turn.setText( "GO!" );
		}
	}
	
	public void updatePlayerBattleInfo()
	{
		player1Health.setText( player1.getHealth() + " / " + player1.getMaxHealth() );
		player2Health.setText( player2.getHealth() + " / " + player2.getMaxHealth() );
	}
	
	public void restart( JPanel panel )
	{
		if ( panel == buttonPanel )
		{
			remove( buttonPanel );
		}
		else if ( panel == battleButtonPanel )
		{
			remove( battleButtonPanel );
			remove( player1BattleInfoPanel );
			remove( player2BattleInfoPanel );
			
			createPlayerInfoPanel();
		}
		
		player1.setAll( 100, 20, 10, 5, 100 );
		player2.setAll( 100, 20, 10, 5, 100 );
		currentPlayer = player1;
		day = 1;
		
		updateDay();
		updateStats();
		createButtonPanel();
		
		validate();
		repaint();
	}
	
	
	
	//buttons
	//*****************************************************************************************************************************
	//main screen button listeners
	
	class TownButtonListener implements ActionListener
	{
	      public void actionPerformed(ActionEvent event)
	      {
	    	//remove main buttons
			buttonPanel.remove( townButton );
			buttonPanel.remove( trainButton );
			buttonPanel.remove( huntButton );
			buttonPanel.remove( restButton );
			//add store buttons
			buttonPanel.add( armorButton );
			buttonPanel.add( weaponButton );
			buttonPanel.add( potionButton );
			buttonPanel.add( backButton );
			validate();
			repaint();
			
			townGold = currentPlayer.getGold();
			
			playerInstruct.setText( "What would you like to buy?" );
	      }
	}
	
	class TrainButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			//remove previous buttons
			buttonPanel.remove( townButton );
			buttonPanel.remove( trainButton );
			buttonPanel.remove( huntButton );
			buttonPanel.remove( restButton );
			//add training buttons
			buttonPanel.add( powerButton );
			buttonPanel.add( enduranceButton );
			buttonPanel.add( backButton );
			validate();
			repaint();
			
			playerInstruct.setText( "What would you like to train?" );
		}
	}
	
	class HuntButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			newTrainer.goHunt( day, currentPlayer );
			updateStats();
			
			day += 1;
			updateDay();
			
			if ( newBattle.checkVictory( player1, player2 ) )
			{
				if ( player1.getHealth() <= 0 )
				{
					playerInstruct.setText( "Player 1 died hunting" );
				}
				else
				{
					playerInstruct.setText( "Player 2 died hunting" );
				}
				
				restart( buttonPanel );
			}
		}
	}
	
	class RestButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			if ( currentPlayer.getHealth() >= currentPlayer.getMaxHealth() )
			{
				playerInstruct.setText( "You are already fully rested" );
			}
			else
			{
				day += 1;
				updateDay();
				playerInstruct.setText( "You spent the day resting" );
			}
			
			currentPlayer.setHealth( currentPlayer.getMaxHealth() );
			updateStats();
		}
	}
	
	//town button listeners
	
	class ArmorButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			if ( currentPlayer.getGold() >= 200 )
			{
				currentPlayer.setGold( currentPlayer.getGold() - 200 );
				currentPlayer.setEndurance( currentPlayer.getEndurance() + 20 );
			}
			else
			{
				playerInstruct.setText( "You lack the gold to buy this!" );
			}
			
			updateStats();
		}
	}
	
	class WeaponButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			if ( currentPlayer.getGold() >= 200 )
			{
				currentPlayer.setGold( currentPlayer.getGold() - 200 );
				currentPlayer.setPower( currentPlayer.getPower() + 20 );
			}
			else
			{
				playerInstruct.setText( "You lack the gold to buy this!" );
			}
			
			updateStats();
		}
	}
	
	class PotionButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			if ( currentPlayer.getGold() >= 300 )
			{
				currentPlayer.setGold( currentPlayer.getGold() - 300 );
				currentPlayer.setHealth( currentPlayer.getHealth() + 30 );
				currentPlayer.setMaxHealth( currentPlayer.getMaxHealth() + 30 );
			}
			else
			{
				playerInstruct.setText( "You lack the gold to buy this!" );
			}
			
			updateStats();
		}
	}
	
	class BackButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			
			//remove store buttons
			buttonPanel.remove( armorButton );
			buttonPanel.remove( weaponButton );
			buttonPanel.remove( potionButton );
			buttonPanel.remove( backButton );
			//remove train buttons
			buttonPanel.remove( powerButton );
			buttonPanel.remove( enduranceButton );
			//add main buttons
			buttonPanel.add( townButton );
			buttonPanel.add( trainButton );
			buttonPanel.add( huntButton );
			buttonPanel.add( restButton );
			validate();
			repaint();
			
			if ( currentPlayer.getGold() < townGold )
			{
				day += 1;
			}
			
			updateDay();
			
			playerInstruct.setText( "Please select an action" );
		}
	}
	
	//training button listeners
	
	class PowerButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			newTrainer.trainPower( currentPlayer );
			playerInstruct.setText( "You spent the day training power" );
			updateStats();
			
			day += 1;
			updateDay();
		}
	}
	
	class EnduranceButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			newTrainer.trainEndurance( currentPlayer );
			playerInstruct.setText( "You spent the day training endurance" );
			updateStats();
			
			day += 1;
			updateDay();
		}
	}
	
	//battle button listeners
	
	class AttackButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			if ( turnControl == 1 )
			{
				newBattle.attack( newBattle.getFirst(), newBattle.getSecond() );
				updatePlayerBattleInfo();
				turnControl += 1;
				
				if ( player1 == newBattle.getFirst() )
				{
					player1Turn.setText( "" );
					player2Turn.setText( "GO!" );
					playerInstruct.setText( "Player 1 attacks!" );
				}
				else
				{
					player2Turn.setText( "" );
					player1Turn.setText( "GO!" );
					playerInstruct.setText( "Player 2 Attacks!" );
				}
			}
			else if ( turnControl == 2 )
			{
				newBattle.attack( newBattle.getSecond(), newBattle.getFirst() );
				updatePlayerBattleInfo();
				turnControl -= 1;
				
				if ( player1 == newBattle.getFirst() )
				{
					playerInstruct.setText( "Player 2 Attacks!" );
				}
				else
				{
					playerInstruct.setText( "Player 1 Attacks!" );
				}
				
				newBattle.turnOrder( player1, player2 );
				
				if ( player1 == newBattle.getFirst() )
				{
					player1Turn.setText( "GO!" );
					player2Turn.setText( "" );
				}
				else
				{
					player2Turn.setText( "GO!" );
					player1Turn.setText( "" );
				}
			}
			
			if ( newBattle.checkVictory( player1, player2 ) )
			{
				if ( player1.getHealth() <= 0 )
				{
					playerInstruct.setText( "Player 2 wins!" );
				}
				else
				{
					playerInstruct.setText( "Player 1 wins!" );
				}
				
				restart( battleButtonPanel );
			}
		}
	}
	
	class DefendButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			if ( turnControl == 1 )
			{
				newBattle.defend( newBattle.getFirst() );
				updatePlayerBattleInfo();
				turnControl += 1;
				
				if ( player1 == newBattle.getFirst() )
				{
					player1Turn.setText( "" );
					player2Turn.setText( "GO!" );
					playerInstruct.setText( "Player 1 Defends!" );
				}
				else
				{
					player2Turn.setText( "" );
					player1Turn.setText( "GO!" );
					playerInstruct.setText( "Player 2 Defends!" );
				}
			}
			else if ( turnControl == 2 )
			{
				newBattle.defend( newBattle.getSecond() );
				updatePlayerBattleInfo();
				turnControl -= 1;
				
				if ( player1 == newBattle.getFirst() )
				{
					playerInstruct.setText( "Player 2 Defends!" );
				}
				else
				{
					playerInstruct.setText( "Player 1 Defends!" );
				}
				
				newBattle.turnOrder( player1, player2 );
				
				if ( player1 == newBattle.getFirst() )
				{
					player1Turn.setText( "GO!" );
					player2Turn.setText( "" );
				}
				else
				{
					player2Turn.setText( "GO!" );
					player1Turn.setText( "" );
				}
			}
		}
	}
}
