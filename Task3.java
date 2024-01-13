import java.util.Scanner;

public class game2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 10; // Number of attempts allowed
        int score = 100; // Initial score

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100. Try to guess it!");

        // Generating a random number between 1 and 100
        int randomNumber = (int) (Math.random() * 100) + 1;

        while (attempts > 0) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You've guessed the number!");
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try guessing higher.");
            } else {
                System.out.println("Too high! Try guessing lower.");
            }

            attempts--;
            if (attempts > 0) {
                System.out.println("Attempts left: " + attempts);
            }
        }

        // Calculating and displaying the score based on attempts
        score -= (10 - attempts) * 10;
        System.out.println("The number was: " + randomNumber);
        System.out.println("Your score is: " + score);

        scanner.close();
    }
}
