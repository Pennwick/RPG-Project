public class Training
{
	public Training()
	{
		
	}
	
    public int randomWithRange(int min, int max)
	{
   		int range = (max - min) + 1;     
   		return (int)(Math.random() * range) + min;
	}
	
	public void trainPower( Player player )
	{
	      player.setPower( player.getPower() + ( randomWithRange( player.getPower() / 4, player.getPower() / 2 ) ) );
	      player.setSpeed( player.getSpeed() + ( randomWithRange( player.getSpeed() / 10, player.getSpeed() / 5 ) ) );
	}
	
	public void trainEndurance( Player player )
	{
		int healup = ( randomWithRange( player.getMaxHealth() / 10, player.getMaxHealth() / 5 ) );
	      player.setEndurance( player.getEndurance() + ( randomWithRange( player.getEndurance() / 8, player.getEndurance() / 4 ) ) );
	      player.setMaxHealth( player.getMaxHealth() + healup );
	      player.setHealth( player.getHealth() + healup );
	}
	
	public void goHunt( int turn, Player player )
	{
		int diff = 0;
		
		//chance of success
		int chance = randomWithRange( 0, ( turn * 20 ) );
				
		if ( ( player.getPower() + player.getEndurance() ) / 2 < chance )
		{
			diff = chance - player.getEndurance();
		}
		else if ( ( player.getPower() + player.getEndurance() ) / 2 >= chance )
		{
			diff = ( player.getEndurance() - chance ) / player.getPower();
		}
				
		//dmg taken
		player.setHealth( player.getHealth() - diff );
				
		//gold found
		player.setGold( player.getGold() + randomWithRange( chance, chance * 3 ) );
				
		//stats improved
		switch( randomWithRange( 1, 2 ) )
		{
			case 1: trainPower( player ); break;
			case 2: trainEndurance( player ); break;
		}
	}
}
