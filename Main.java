//Shreya Sharma & Sreshta Namala
//Period 6 AP CSA
//My Guessing Game Project:
//This code outputs an interactive guessing game in 
//which the computer choose a random number between 
//1-100 and the user guesses that number based on clues 
//that the computer gives. The user can choose to play 
//the game many times and after they are done, 
//the game gives a final stastics table.
import java.util.*;
public class Main
{
   //immutable constant for max value
   public static final int MAX = 100;
   /* The main method consists of the while loop in which 
   the user can choose to keep playing or not once they guess the number. 
   If they want to keep playing, the playGame method is called in it. 
   If not, the statistic of the game are liosted in a table. 
   One of the statements use the printf command. */
   public static void main(String args[]) {  
      //sets global variables
      boolean undone = true;
      int actualNumber = 0;
      int games = 0;
      int totalGuesses = 0;
      int bestGame = Integer.MAX_VALUE;
      Scanner input = new Scanner(System.in);
      
      //while loop to keep playing or not (multiple games)
      while (undone) {
         System.out.printf("I'm thinking of a number from 1-%d...\n", MAX);
         System.out.print("Your guess? ");
         //generate random number
         actualNumber = (int)(Math.random() * MAX) + 1;
         
         //call playGame method for user to guess the number
         int guesses = playGame(input, actualNumber);
         
         //calculate total number of guesses
         totalGuesses += guesses;
         
         //find minimum value of turns to put in the best game section
         if (bestGame > guesses) {
            bestGame = guesses;
         }

         //Total Games
         games += 1;
            
         //input to keep playing or not
         System.out.print("Play again? (y/n) ");
         String command = input.next();
         System.out.println();
         //what to do based on input
         //has to continue if user types y or Y
         if (command.charAt(0) != 'y' && command.charAt(0) != 'Y') {
            undone = false;
         }
      }
      //call method to state statistics for the game
      statistics(games, totalGuesses, bestGame);
   }

   /* This method calls the statistics of the game after the user 
   chooses to be done with playing. The statistics include the 
   number of games, the number of guesses, the average number of guesses 
   per game and the least number of guesses in the whole time, while playing. */
   public static void statistics(int totalGames, int totalGuesses, int bestGameGuesses) {
      //prints full results after user is done playing
      System.out.println("\nOverall Results:");
      System.out.println("Total games   = " + totalGames);
      System.out.println("Total guesses = " + totalGuesses);
      double avg = (double) totalGuesses/totalGames;
      //using printf statement
      System.out.printf("Guesses/game  = %1.1f\n", avg);
      System.out.println("Best game     = " + bestGameGuesses);
   }

   /* The playGame method consists of the while loop in which 
   the user guesses the randomly selected number as the computer 
   gives the user clues as to whether the number is higher or lower. 
   This returns the number of turns as an integer to use in the main. */
   public static int playGame(Scanner console, int actualNumber) {  
      int userGuess = console.nextInt();
      int turns = 1;
      //loops user guess if the user's guess is not 
      //equal to the number that was randomly set         
      while (userGuess != actualNumber) {
         turns += 1;
         if (userGuess > actualNumber)
         {
            System.out.println("It's lower.");
            System.out.print("Your guess? ");
         }
         else if (userGuess < actualNumber)
         {
            System.out.println("It's higher.");
            System.out.print("Your guess? ");
         }
         userGuess = console.nextInt();
   }
   
   //System.out.println("You got it right in " + turns + " guesses");
   //return statement to use in main
   return turns;
}
}
