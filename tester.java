import java.util.Scanner;

public class tester
{
      public static void main( String[] args )
      {
            Scanner input = new Scanner( System.in );
        
            Player player1 = new Player( 100, 20, 10, 10 );
            Player player2 = new Player( 100, 20, 10, 10 );
            
            Battle newBattle = new Battle();
            
            boolean gameLoop = true
            
            while ( gameLoop )
            {
                  newBattle.battleStart( player1, player2 );
            }
      }
}
