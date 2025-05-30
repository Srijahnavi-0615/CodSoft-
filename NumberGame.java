import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        final int Max_attempts = 10;
        final int Min = 1;
        final int Max = 100;
        boolean playAgain = true;

        System.out.println("~~~~~~~~ Welcome to the Number Guessing Game! ~~~~~~~~~");

        while (playAgain) {
            int targetNumber = random.nextInt(Max - Min + 1) + Min;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between " + Min + " and " + Max + ".");
            System.out.println("You have " + Max_attempts + " attempts.");

            while (attempts < Max_attempts) {
                System.out.print("Enter your guess: ");
                int guess = input.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all your attempts. The correct number was: " + targetNumber);
            }

            System.out.print("\nWould you like to play again? (yes/no): ");
            input.nextLine(); // consume newline
            String response = input.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\n~~~~~~~~~ Thanks for playing. bye bye! ~~~~~~~~~~");
        input.close();
        }
}
