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
		
		if ( playerB.getProtect() == true )
		{
			damage = ( playerA.getPower() - ( playerB.getEndurance() + playerB.getDefense() ) );
		}
		else
		{
	    		damage = ( playerA.getPower() - playerB.getEndurance() );
		}
		
	    	if ( damage > 0 )
	    	{
	    		playerB.setHealth( playerB.getHealth() -= damage );
	    
	    		if ( playerB.getHealth() <= 0 )
	    		{
	        		victory( playerA );
	    		}
	    	}
	}
	
	public void defend( Player player )
	{
	    	player.setProtect( true );
	}
	
	public void victory( Player player )
	{
	    
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
		
		if ( playerA.getSpeed() == playerB.getSPeed() )
		{
			switch ( randomWithRange( 1, 2 )
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
	
	public void startTurn( int turnNumber, Player playerA, Player playerB )
	{
		//start the turn and determine the order
		int turn = turnNumber;
		
		playerA.setProtect( false ):
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
