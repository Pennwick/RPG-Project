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
	      player.setEndurance( player.getEndurance() + ( randomWithRange( player.getEndurance() / 8, player.getEndurance() / 4 ) ) );
	      player.setMaxHealth( player.getMaxHealth() + ( randomWithRange( player.getMaxHealth() / 10, player.getMaxHealth() / 5 ) ) );
	      player.setHealth( player.getMaxHealth() );
	}
}
