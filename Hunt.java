public class Hunt 
{
	public Hunt()
	{
		
	}
	
	public void goHunt( int turn, Player player )
	{
		//chance of success
		int chance = randomWithRange( 0, ( 50 + turn * 5 ) );
		
		if ( player.getPower() < chance )
		{
			int diff = chance - player.getPower();
		}
		else if ( player.getPower() >= chance )
		{
			
		}
		
		//dmg taken
		
		//gold found
		
		//stats improved
	}
	
	public int randomWithRange(int min, int max)
	{
   		int range = (max - min) + 1;     
   		return (int)(Math.random() * range) + min;
	}
}
