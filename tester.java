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
            
            newBattle.battleStart( player1, player2 );
            
            while ( gameLoop )
            {
                  System.out.println( newBattle.getFirst() + " enter 1 to attack, 2 to defend, or 0 to quit: " );
                  //newBattle.actionSelect( input.nextInt(), newBattle.getFirst(), newBattle.getSecond() );
                  
                  System.out.println( newBattle.getSecond() + " enter 1 to attack, 2 to defend, or 0 to quit: " );
                  //newBattle.actionSelect( input.nextInt(), newBattle.getSecond(), newBattle.getFirst() );
            }
      }
}
