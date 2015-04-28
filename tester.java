import java.util.Scanner;

public class tester
{
      public static void main( String[] args )
      {
            Scanner input = new Scanner( System.in );
        
            Player player1 = new Player( 100, 20, 10, 10, 5 );
            Player player2 = new Player( 100, 20, 10, 10, 5 );
            
            int choice1 = 0;
            int choice2 = 0;
            
            Battle newBattle = new Battle();
            
            boolean gameLoop = true
            int turn = 1;
            
            while ( gameLoop )
            {
                  newBattle.startTurn( turn, player1, player2 )
                  
                  System.out.println( "Player 1 enter 1 to attack, 2 to defend, or 0 to quit: " );
                  choice1 = input.nextInt();
                  
                  System.out.println( "Player 2 enter 1 to attack, 2 to defend, or 0 to quit: " );
                  choice2 = input.nextInt();
                  
                  if ( choice1 == 0 && choice2 == 0 )
                  {
                        break;
                  }
                  else if ( choice2 == 2 )
                  {
                        newBattle.actionSelect( choice2, newBattle.getSecond(), newBattle.getFirst() );
                        newBattle.actionSelect( choice1, newBattle.getFirst(), newBattle.getSecond() );
                  }
                  else if ( choice2 == 1 )
                  {
                        newBattle.actionSelect( choice1, newBattle.getFirst(), newBattle.getSecond() );
                        newBattle.actionSelect( choice2, newBattle.getSecond(), newBattle.getFirst() );
                  }
                  
                  turn += 1;
            }
      }
}
