public class InTown {

	private static final Player Player = null;



	
	
	int PChoice;
	//Turn Counters
	int P1Counter = 10;
	int P2Counter = 10;
	boolean P1Turn = true;
	boolean P2Turn = false;
	int Training = 1;
	
	public InTown()
	{
	}
	
	public void event(int PChoice,Player Player) 
	{
		switch (PChoice)
		{
		//Training
		case 1: train(Player);
		break;
		
		//Shop
		case 2: shop(Player);
		break;
		
		//Monster Woods	
		case 3: woods(Player);
		break;
		
		//Rest
		case 4: rest(Player);
		break;
		
		default: System.out.print("You broke space and Time!!!!!");
		}
	}
	///////////////////////////////////
	
	
	
		private void train(Player Player) {
			System.out.print("1 for Pow 2 for Def");
		
			if(Training == 1)
			{
			Training newTrainer = new Training();
			newTrainer.trainPower(Player);
			}
			
			if(Training == 2)
			{
			Training newTrainer = new Training();
			newTrainer.trainEndurance(Player);
			}
		
		
			///Turn Stuff
			if (P1Turn = true)
			{
				P1Counter--;
				if(P1Counter == 0)
				{
				P1Turn = false;
				P2Turn = true;
				}
			}
			
			if (P2Turn = true)
			{
				P2Counter--;
				if(P2Counter == 0)
				{
				P2Turn = false;
				}
			}
	}

		private void shop(Player Player) {
			//int Armor = 1;
			//int Sword = 2;
		    //int HealthPotion = 3;
		    //int SpeedPotion = 4;
			int ShopChoice = 1;
			while (ShopChoice != 0)
			{
				switch(ShopChoice)
				{
				case 1:
					if(Player.getGold() > 200)
					{
						Player.setEndurance( Player.getEndurance() + 20);
					}
					
					else
					{
						System.out.print("You lack the gold to buy this!");
					}
				break;
				
				case 2:
					if(Player.getGold() > 200)
					{
						Player.setPower( Player.getPower() + 20);
					}
					
					else
					{
						System.out.print("You lack the gold to buy this!");
					}
				break;
				
				case 3:
					if(Player.getGold() > 300)
					{
						Player.setMaxHealth( Player.getMaxHealth() + 30);
					}
					
					else
					{
						System.out.print("You lack the gold to buy this!");
					}
				break;
				
				case 4:
					if(Player.getGold() > 400)
					{
						Player.setSpeed( Player.getSpeed() + 40);
					}
					
					else
					{
						System.out.print("You lack the gold to buy this!");
					}
				break;
				}
			}
			
			
			
			///Turn Stuff
			if (P1Turn = true)
			{
				P1Counter--;
				if(P1Counter == 0)
				{
				P1Turn = false;
				P2Turn = true;
				}
			}
			
			if (P2Turn = true)
			{
				P2Counter--;
				if(P2Counter == 0)
				{
				P2Turn = false;
				}
			}
	}

		private void woods(Player Player) {
		// TODO Auto-generated method stub
		
			///Turn Stuff
			if (P1Turn = true)
			{
				P1Counter--;
				if(P1Counter == 0)
				{
				P1Turn = false;
				P2Turn = true;
				}
			}
			
			if (P2Turn = true)
			{
				P2Counter--;
				if(P2Counter == 0)
				{
				P2Turn = false;
				}
			}
	}

		
		
		public void rest(Player Player)
	{
		Player.setHealth(Player.getMaxHealth());
		
		///Turn Stuff
		if (P1Turn = true)
		{
			P1Counter--;
			if(P1Counter == 0)
			{
			P1Turn = false;
			P2Turn = true;
			}
		}
		
		if (P2Turn = true)
		{
			P2Counter--;
			if(P2Counter == 0)
			{
			P2Turn = false;
			}
		}
	}

		
	

	
}
