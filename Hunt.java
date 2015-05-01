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
			int diff = ( player.getPower() - chance ) / 2;
		}
		
		//dmg taken
		player.setHealth( player.getHealth() - diff );
		
		//gold found
		player.setGold( player.getGold() + diff );
		
		//stats improved
		switch( randomWithRange( 1, 2 )
		{
			case 1: newTrainer.trainPower( player ); break;
			case 2: newTrainer.trainEndurance( player ); break;
		}
	}
	
	public int randomWithRange(int min, int max)
	{
   		int range = (max - min) + 1;     
   		return (int)(Math.random() * range) + min;
	}
}
