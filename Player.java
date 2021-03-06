public class Player
{
  private int maxHealth;
  private int health;
  private int power;
  private int endurance;
  private int speed;
  private int gold;
  private boolean protect;
  
  public Player( int heal, int pow, int end, int sp, int g )
  {
      maxHealth = heal;
      health = heal;
      power = pow;
      endurance = end;
      speed = sp;
      gold = g;
      protect = false;
  }
  
  public void setAll( int heal, int pow, int end, int sp, int g )
  {
	  maxHealth = heal;
      health = heal;
      power = pow;
      endurance = end;
      speed = sp;
      gold = g;
  }
  
  public int getMaxHealth()
	{
		return maxHealth;
	}
	
	public void setMaxHealth( int heal )
	{
		maxHealth = heal;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth( int heal )
	{
		health = heal;
	}
	public int getPower()
	{
		return power;
	}
	
	public void setPower( int pow )
	{
	    power = pow;
	}
	
	public int getEndurance()
	{
		return endurance;
	}
	
	public void setEndurance( int end )
	{
	    endurance = end;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed( int sp )
	{
	    speed = sp;
	}
	
	public int getGold()
	{
		return gold;
	}
	
	public void setGold( int g )
	{
		gold = g;
	}
	
	public boolean getProtect()
	{
		return protect;
	}
	
	public void setProtect( boolean pro )
	{
	    protect = pro;
	}
}
