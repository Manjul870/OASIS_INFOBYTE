import javax.swing.*;
import java.util.Random;

public class Guessing_Game {
    public static int playGame() {
        int points = 0;
        try {
            int noOfAttempts = 5;
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1;

            while (noOfAttempts > 0) {
                String userInput = JOptionPane.showInputDialog("Enter a number between 1 and 100:");

                // Check if the user pressed Cancel or closed the dialog
                if (userInput == null) {
                    JOptionPane.showMessageDialog(null, "Game exited.");
                    return 0;
                }

                int number;
                try {
                    number = Integer.parseInt(userInput);
                    if (number < 1 || number > 100) {
                        JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 100.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.");
                    continue;
                }

                if (number == randomNumber) {
                    points = calculatePoints(noOfAttempts);
                    JOptionPane.showMessageDialog(null, "🎉 Congratulations! You guessed the number.\nYou received " + points + " points.");
                    return points;
                } else if (number > randomNumber) {
                    JOptionPane.showMessageDialog(null, "Your number is too high!\nAttempts left: " + (noOfAttempts - 1));
                } else {
                    JOptionPane.showMessageDialog(null, "Your number is too low!\nAttempts left: " + (noOfAttempts - 1));
                }

                noOfAttempts--;
            }

            JOptionPane.showMessageDialog(null, "❌ You have used all attempts! The correct number was " + randomNumber);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage());
        }
        return points;
    }

    public static int calculatePoints(int noOfAttempts) {
        switch (noOfAttempts) {
            case 5: return 20;
            case 4: return 15;
            case 3: return 10;
            case 2: return 5;
            case 1: return 1;
            default: return 0;
        }
    }
}
