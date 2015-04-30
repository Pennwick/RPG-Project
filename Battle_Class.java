import java.util.Scanner;



public class Battle_Class 
{
	
	public static void main (String[] args)
	   {
		
		//player 1 Stats
		 int Player1Health = 100;
		 int Player1Power = 20;
		 int Player1Endurance = 10;
		 int Player1Speed = 10;
			boolean Protected1 = false;
		 int bonus1 = 0;
		 
		//player 2 Stats
		 int Player2Health = 100;
		 int Player2Power = 20;
		 int Player2Endurance = 10;
		 int Player2Speed = 10;
			boolean Protected2 = false;
		 int bonus2 = 0;
		
		System.out.print("Time for Battle!\n\n");
		
		Scanner input = new Scanner(System.in);
		
		//keeps track of whose turn it is
		int turn = 1;
		boolean start = true;
		
		if(Player2Speed > Player1Speed && start == true)
			{
				turn = 2;
				start = false;
			}
	
//////////////////////////////////////////////////////////////////GAMEPLAY STARTS HERE
		
		int victory = 0;
while (victory == 0)
{
		//player 1's turn actions
	if(turn == 1)
	{
		int P1Move;

		
		System.out.print("\n\nPlayer 1, Choose");
		P1Move = input.nextInt();

		
		//resets Endurance if player defended last turn
		if(Protected1 == true)
		{
			Player1Endurance = Player1Endurance - 5;
			Protected1 = false;
		}
			//attack option
			if (P1Move == 1)
				{
				//allows for a critical hit or a missed attack P1
				 int Crit1 = (int) (Math.floor(Math.random() * (100 - 1)) + 1);				 
				 
				int damage1 = (Player1Power - Player2Endurance);
					//Crit Hit Code
					if (Crit1 < 11)
					{
					damage1 = damage1 + Crit1;
					System.out.println("Critical Hit!\n\n");
					}
					//Miss Code
					if (Crit1 > 90)
					{
					damage1 = damage1 * 0;
					System.out.println("Missed!\n\n");
					}
				
					Player2Health = Player2Health - damage1;
				}
			//defend option
			if (P1Move == 2)
				{	
					Player1Endurance = Player1Endurance + 5;
					Protected1 = true;
				}
		
			System.out.print("Player 2 health: " + Player2Health);
			
		turn = 2;
	}
		
	
	////////////////////////////////////////////
	////////////////////////////////////////////
	////////////////////////////////////////////
	
	
		//player 2's turn actions
	if(turn == 2)
	{
		int P2Move;

		
		System.out.print("\n\nPlayer 2, Choose");
		P2Move = input.nextInt();
		
		//resets Endurance if player defended last turn
		if(Protected2 == true)
		{
			Player2Endurance = Player2Endurance - 5;
			Protected2 = false;
		}
			//attack option
			if (P2Move == 1)
				{
				//allows for a critical hit or a missed attack P2
				 int Crit2 = (int) (Math.floor(Math.random() * (100 - 1)) + 1);	
				
				int damage2 = (Player2Power - Player1Endurance);
				//Crit Hit code
				if (Crit2 < 11)
				{
				damage2 = damage2 + Crit2;
				System.out.println("Critical Hit!\n\n");
				}
				//Miss Code
				if (Crit2 > 90)
				{
				damage2 = damage2 * 0;
				System.out.println("Missed!\n\n");
				}
					
				Player1Health = Player1Health - damage2;
				
				}
			//defend option
			if (P2Move == 2)
				{	
				Player2Endurance = Player2Endurance + 5;
				Protected2 = true;
				}
				
			System.out.print("Player 1 health: " + Player1Health);
		
		turn = 1;
	}
	
	//checks if either player has won yet
	if(Player1Health < 1)
	{
		victory = 2;
	}
	
	if(Player2Health < 1)
	{
		victory = 1;
	}
	
}
////////////////////////////////////////////////////////GAMEPLAY ENDS HERE

//Displays victory message
if(victory == 1)
{
	System.out.print("PLAYER 1 IS VICTORIOUS!!!");
}

if(victory == 2)
{
	System.out.print("PLAYER 2 IS VICTORIOUS!!!");
}

	   }
}
