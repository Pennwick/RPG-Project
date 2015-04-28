public class Battle
{
	Object first;
	Object second;
	
	public Battle()
	{
		
	}
	
	public void attack( Object playerA, Object playerB )
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
	
	public void defend( Object player )
	{
	    	player.setProtect( true );
	}
	
	public void victory( Object player )
	{
	    
	}
	
	public void turnOrder( Object playerA, Object playerB )
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
			//randomly pick turn order
		}
	}
	
	public Object getFirst()
	{
		return first;
	}
	
	public Object getSecond()
	{
		return second;
	}
	
	public void actionSelect( int choice, Object playerA, Object playerB )
	{
		switch( choice )
		{
			case 0: gameLoop = false; break;
			case 1: attack( playerA, playerB ); break;
			case 2: defend( playerA ); break;
		}
	}
	
	public void startTurn( int turnNumber, Object playerA, Object playerB )
	{
		//start the turn and determine the order
		int turn = turnNumber;
		
		playerA.setProtect( false ):
		playerB.setProtect( false );
		
		System.out.println( "Player 1 Health: " + playerA.getHealth() );
		System.out.println( "Player 2 Health: " + playerB.getHealth() );
		
		turnOrder( playerA, playerB );
	}
}
