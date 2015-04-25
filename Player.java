public class Player
{
  private int health;
  private int power;
  private int endurance;
  private int speed;
  private int defense;
  private boolean protect;
  
  public Player( int heal, int pow, int end, int sp, int def )
  {
      health = heal;
      power = pow;
      endurance = end;
      speed = sp;
      defense = def;
      protect = false;
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
	
	public int getDefense()
	{
		return defense;
	}
	
	public void setDefense( int def )
	{
		defense = def;
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
