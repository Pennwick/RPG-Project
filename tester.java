import java.util.Scanner;

public class tester
{
      public static void main( String[] args )
      {
            Scanner input = new Scanner( System.in );
            
            int choice1 = 0;
            int choice2 = 0;
            
            Battle newBattle = new Battle();
            Training newTrainer = new Training();
            Player player1 = new Player( 0, 0, 0, 0, 0 );
            Player player2 = new Player( 0, 0, 0, 0, 0 );
            
            boolean gameLoop = true;
            
            //Player 1 chooses class
            
            System.out.println( "Player 1, enter 1 for warrior or 2 for mage" );
            choice1 = input.nextInt();
            
            if ( choice1 == 1 )
            {
            	player1.setAll( 120, 15, 15, 10, 100 );
            }
            else
            {
            	player1.setAll( 90, 30, 10, 10, 100 );
            }
            
            //Player 2 chooses class
            
            System.out.println( "Player 2, enter 1 for warrior or 2 for mage" );
            choice1 = input.nextInt();
            
            if ( choice1 == 1 )
            {
            	player2.setAll( 120, 15, 15, 10, 100 );
            }
            else
            {
            	player2.setAll( 90, 30, 10, 10, 100 );
            }
            
            //Player 1's 10 days to train
            
            System.out.println( "Player 1 you have 10 days to train." );
            
            for ( int turn = 1; turn <= 10; turn++ )
            {
                  System.out.println( "Day " + turn );
                  System.out.println( "Player 1 enter 1 to train power, or 2 to train endurance: " );
                  choice1 = input.nextInt();
                  
                  switch( choice1 )
                  {
                        case 1: newTrainer.trainPower( player1 ); System.out.println( "Power raised to " + player1.getPower() ); break;
                        case 2: newTrainer.trainEndurance( player1 ); System.out.println( "Endurance raised to " + player1.getEndurance() ); break;
                  }
            }
            
            System.out.println( "Player 1: Health: " + player1.getMaxHealth() + " Power: " + player1.getPower() + " Endurance: " + player1.getEndurance() + " Speed: " + player1.getSpeed() );
            
            //Player 2's 10 days to train
            
            System.out.println( "Player 2 you have 10 days to train." );
            
            for ( int turn = 1; turn <= 10; turn++ )
            {
                  System.out.println( "Day " + turn );
                  System.out.println( "Player 2 enter 1 to train power, or 2 to train endurance: " );
                  choice1 = input.nextInt();
                  
                  switch( choice1 )
                  {
                        case 1: newTrainer.trainPower( player2 ); System.out.println( "Power raised to " + player2.getPower() ); break;
                        case 2: newTrainer.trainEndurance( player2 ); System.out.println( "Endurance raised to " + player2.getEndurance() ); break;
                  }
            }
            
            System.out.println( "Player 2: Health: " + player2.getMaxHealth() + " Power: " + player2.getPower() + " Endurance: " + player2.getEndurance() + " Speed: " + player2.getSpeed() );
            
            //Battle starts
            
            while ( gameLoop )
            {
                  newBattle.startTurn( player1, player2 );
                  
                  System.out.println( "Player 1 enter 1 to attack, 2 to defend, or 0 to quit: " );
                  choice1 = input.nextInt();
                  
                  System.out.println( "Player 2 enter 1 to attack, 2 to defend, or 0 to quit: " );
                  choice2 = input.nextInt();
                  
                  if ( choice1 == 0 && choice2 == 0 )
                  {
                        gameLoop = false; break;
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
                  
                  if ( newBattle.checkVictory( player1, player2 ) )
                  {
                	  gameLoop = false;
                  }
            }
            
            input.close();
      }
}
