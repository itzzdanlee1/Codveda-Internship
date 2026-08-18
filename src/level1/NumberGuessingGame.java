package level1;
import java.util.Scanner;
import java.util.Random;


public class NumberGuessingGame {
    public static void main(String[] args) {

        //to generate a random number between 1 and 50
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        int secretNumber = random.nextInt(50) + 1;

        int guess;
        int maxAttempts = 6;
        boolean correctGuess = false;

        System.out.println("Welcome to the Number Guessing Game!!");
        System.out.println("I'm thinking of a number between 1 and 50.");
        System.out.println("Guess what? you have " + maxAttempts + " attempts.");

        //for loop to loop through  numbers
        for (int attempts = 1; attempts <= maxAttempts; attempts++) {
            System.out.print("Attempts " + attempts + " Enter your guess: ");

            //input error handling
            if(!input.hasNextInt()){
                System.out.println("Invalid input! Please enter a number!");
                input.next();
                attempts--;
                continue;
            }
            guess = input.nextInt();

            if (guess < secretNumber) {
                System.out.println("Too Low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too High! Try again.");
            } else {
                System.out.println("Congratulations! you Guessed it right in " + attempts + " attempts.");
                correctGuess = true;

                break;

            }

        }
        if (!correctGuess) {
            System.out.println("Game over! The number was " + secretNumber + ".");
        }
        input.close();
    }
}
