import javax.swing.*;

public class Round {
    static String choice;

    public static void main(String[] args) {
        int round = 1;
        int previousPoint = 0;

        do {
            JOptionPane.showMessageDialog(null, "🎮 Welcome to the Number Guessing Game\n🔄 Round: " + round);

            // Call the improved method from Guessing_Game
            int point = Guessing_Game.playGame();
            previousPoint += point;

            if (point > 0) {
                round++;
                choice = JOptionPane.showInputDialog("✅ You Received " + previousPoint + " points\n🎲 If you want to play Round " + round + ", type 'Yes'");
                if (choice == null || !choice.equalsIgnoreCase("Yes")) {
                    JOptionPane.showMessageDialog(null, "🎮 Game Over!\n🏆 Total Points: " + previousPoint);
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "❌ You Received " + previousPoint + " points\nGame Over!");
                break;
            }
        } while (true);
    }
}
