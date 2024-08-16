import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int RANGE = 100;
    private static int score = 0;
    private static int rounds = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            playRound(scanner);
            rounds++;
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("yes"));
        
        System.out.println("Game Over!");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Total Score: " + score);

        scanner.close();
    }

    private static void playRound(Scanner scanner) {
        Random random = new Random();
        int targetNumber = random.nextInt(RANGE) + 1;
        int attempts = 0;
        boolean correct = false;

        System.out.println("A new number has been generated between 1 and " + RANGE + ". Try to guess it!");

        while (attempts < MAX_ATTEMPTS && !correct) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                correct = true;
                score += MAX_ATTEMPTS - attempts + 1;
            } else if (userGuess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Too low! Try again.");
            }
        }

        if (!correct) {
            System.out.println("Sorry, you've used all attempts. The correct number was " + targetNumber + ".");
        }
    }
}
