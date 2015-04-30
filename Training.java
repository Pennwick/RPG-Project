public class Training
{
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
	      player.setEndurance( player.getEndurance() + ( randomWithRange( player.getEndurance() / 4, player.getEndurance() / 2 ) ) );
	      player.setHealth( player.getHealth() + ( randomWithRange( player.getHealth() / 10, player.getHealth() / 5 ) ) );
	}
}
