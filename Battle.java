public class Battle
{
	Player first;
	Player second;
	
	public Battle()
	{
		
	}
	
	public void attack( Player playerA, Player playerB )
	{
		// playerA is attacking playerB
		int damage;
		int crit = randomWithRange( 1, 100 );
		int critDmg;
		int miss;
		
		if ( playerB.getProtect() == true )
		{
			if ( crit < 11 )
			{
				//gets a crit hit
				critDmg = ( crit * playerA.getSpeed() );
				miss = 1;
			}
			else if ( crit > 90 )
			{
				//misses horribly
				critDmg = 0;
				miss = 0;
			}
			else
			{
				//gets a normal hit
				critDmg = 0;
				miss = 1;
			}
			
			damage = ( int ) ( ( playerA.getPower() - ( playerB.getEndurance() * 1.5 ) + crit ) * miss );
			playerB.setProtect( false );
		}
		else
		{
	    		damage = ( playerA.getPower() - playerB.getEndurance() );
		}
		
	    	if ( damage > 0 )
	    	{
	    		playerB.setHealth( playerB.getHealth() - damage );
	    	}
	}
	
	public void defend( Player player )
	{
	    	player.setProtect( true );
	}
	
	public boolean checkVictory( Player playerA, Player playerB )
	{
	    if ( playerA.getHealth() <=0 )
	    {
	    	System.out.println( "Player 1 wins! " );
	    	return true;
	    }
	    else if ( playerB.getHealth() <= 0 )
	    {
	    	System.out.println( "Player 2 wins! " );
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
	
	public void turnOrder( Player playerA, Player playerB )
	{
		if ( playerA.getSpeed() > playerB.getSpeed() )
		{
			first = playerA;
			second = playerB;
		}
		
		if ( playerB.getSpeed() > playerA.getSpeed() )
		{
			first = playerB;
			second = playerA;
		}
		
		if ( playerA.getSpeed() == playerB.getSpeed() )
		{
			switch ( randomWithRange( 1, 2 ) )
			{
				case 1: first = playerA; second = playerB; break;
				case 2: first = playerB; second = playerA; break;
			}
		}
	}
	
	public Player getFirst()
	{
		return first;
	}
	
	public Player getSecond()
	{
		return second;
	}
	
	public void actionSelect( int choice, Player playerA, Player playerB )
	{
		switch( choice )
		{
			case 0: break;
			case 1: attack( playerA, playerB ); break;
			case 2: defend( playerA ); break;
		}
	}
	
	public void startTurn( Player playerA, Player playerB )
	{
		//start the turn and determine the order
		playerA.setProtect( false );
		playerB.setProtect( false );
		
		System.out.println( "Player 1 Health: " + playerA.getHealth() );
		System.out.println( "Player 2 Health: " + playerB.getHealth() );
		
		turnOrder( playerA, playerB );
	}
	
	public int randomWithRange(int min, int max)
	{
   		int range = (max - min) + 1;     
   		return (int)(Math.random() * range) + min;
	}
}
