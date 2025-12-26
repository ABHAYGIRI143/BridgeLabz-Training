import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

	
	//Create Scanner Object
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    // Method to generate a guess within range
    public static int generateGuess(int low, int high) {
        return random.nextInt(high - low + 1) + low;
    }

    // Method to get user feedback
    public static char getFeedback(int guess) {
        System.out.print(
                "Is the guess " + guess +
                " too High (H), too Low (L), or Correct (C)? : ");
        return sc.next().toUpperCase().charAt(0);
    }

    // Method to update range based on feedback
    public static void updateRange(char feedback, int guess, int[] range) {
        if (feedback == 'H') {
            range[1] = guess - 1;
        } else if (feedback == 'L') {
            range[0] = guess + 1;
        }
    }

    public static void main(String[] args) {

        int low = 1;
        int high = 100;
        boolean isCorrect = false;

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");

        while (!isCorrect && low <= high) {

            int guess = generateGuess(low, high);
            char feedback = getFeedback(guess);

            if (feedback == 'C') {
                System.out.println("🎉 I guessed your number correctly!");
                isCorrect = true;
            } else {
                int[] range = { low, high };
                updateRange(feedback, guess, range);
                low = range[0];
                high = range[1];
            }
        }
        
        //Close Scanner Object
        sc.close();
    }
}
