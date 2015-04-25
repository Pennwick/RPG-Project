public class Battle
{
	public Battle()
	{
		
	}
	
	public void attack( Object playerA, Object playerB, int defense )
	{
		// playerA is attacking playerB
		int damage;
		
		if ( playerB.getProtect() == true )
		{
			damage = ( playerA.getPower() - ( playerB.getEndurance() + defense ) );
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
	
	public void battleStart( Object playerA, Object playerB )
	{
		startTurn( 1, playerA, playerB );
	}
	
	public void startTurn( int turnNumber, Object playerA, Object playerB )
	{
		//start the turn and determine the order
		int turn = turnNumber;
		
		playerA.setProtect( false )
		
		if ( playerA.getSpeed() > playerB.getSpeed() )
		{
			int pA = 1;
			int pB = 2;
		}
		
		if ( playerB.getSpeed() > playerA.getSpeed() )
		{
			int pB = 1;
			int pA = 2;
		}
		
		if ( playerA.getSpeed() == playerB.getSPeed() )
		{
			//randomly pick turn order
		}
	}
}
