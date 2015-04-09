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
		
		//player 2 Stats
		 int Player2Health = 100;
		 int Player2Power = 20;
		 int Player2Endurance = 10;
		 int Player2Speed = 10;
		
		
		System.out.print("Time for Battle!");
		
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
		boolean Protected1 = false;
		
		System.out.print("Choose");
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
					Player2Health = Player2Health - (Player1Power - Player2Endurance);
				}
			//defend option
			if (P1Move == 2)
				{	
					Player1Endurance = Player1Endurance + 5;
					Protected1 = true;
				}
		
		turn = 2;
	}
		
	
	////////////////////////////////////////////
	
	
		//player 2's turn actions
	if(turn == 2)
	{
		int P2Move;
		boolean Protected2 = false;
		
		System.out.print("Choose");
		P2Move = input.nextInt();
		
		//resets Endurance if player defended last turn
		if(Protected2 == true)
		{
			Player1Endurance = Player1Endurance - 5;
			Protected2 = false;
		}
			//attack option
			if (P2Move == 1)
				{
				Player1Health = Player1Health - (Player2Power - Player1Endurance);
				}
			//defend option
			if (P2Move == 2)
				{	
				Player2Endurance = Player2Endurance + 5;
				Protected2 = true;
				}
				
		
		turn = 1;
	}
	
	//checks if either player has won yet
	if(Player1Health<1)
	{
		victory = 2;
	}
	
	if(Player2Health<1)
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

