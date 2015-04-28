import java.util.Scanner;

public class tester
{
      public static void main( String[] args )
      {
            Scanner input = new Scanner( System.in );
        
            Player player1 = new Player( 100, 20, 10, 10 );
            Player player2 = new Player( 100, 20, 10, 10 );
            
            int choice1 = 0;
            int choice2 = 0;
            
            Battle newBattle = new Battle();
            
            boolean gameLoop = true
            
            newBattle.battleStart( player1, player2 );
            
            while ( gameLoop )
            {
                  System.out.println( "Player 1 enter 1 to attack, 2 to defend, or 0 to quit: " );
                  choice1 = input.nextInt();
                  //newBattle.actionSelect( input.nextInt(), newBattle.getFirst(), newBattle.getSecond() );
                  
                  System.out.println( "Player 2 enter 1 to attack, 2 to defend, or 0 to quit: " );
                  choice2 = input.nextInt();
                  //newBattle.actionSelect( input.nextInt(), newBattle.getSecond(), newBattle.getFirst() );
            }
      }
}
