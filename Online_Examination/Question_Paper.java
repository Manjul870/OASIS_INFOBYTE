package Online_Examination;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Question_Paper {
    public static int points = 0;
    public static boolean answered = false;
    public static boolean examEnded = false;
    public static Timer examTimer = new Timer();

    public static void Question_Paper(String Question, String answer1, String answer2, String answer3, String answer4, String correctAns) {
        if (examEnded) return; // Stop asking questions if exam is auto-submitted

        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("Qns :"+ Question);
        System.out.println("a) " + answer1);
        System.out.println("b) " + answer2);
        System.out.println("c) " + answer3);
        System.out.println("d) " + answer4);
        System.out.print("Enter Ans (within 10 seconds): ");

        Scanner sc = new Scanner(System.in);
        answered = false;
        Timer questionTimer = new Timer();

        // Start a timer for 10 seconds per question
        questionTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered) {
                    System.out.println("\nTime's up for this question! Moving to the next...");
                    answered = true;
                }
            }
        }, 10000); // 10 seconds

        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) < 10000 && !answered && !examEnded) {
            if (sc.hasNext()) {
                String input = sc.next();
                if (input.equalsIgnoreCase("submit")) {
                    System.out.println("\nYou have submitted the exam early!");
                    examEnded = true;
                    break;
                }

                char ans = input.charAt(0);
                answered = true;
                questionTimer.cancel();

                String choice = "";
                switch (ans) {
                    case 'a':
                        choice = answer1;
                        break;
                    case 'b':
                        choice = answer2;
                        break;
                    case 'c':
                        choice = answer3;
                        break;
                    case 'd':
                        choice = answer4;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        return;
                }

                if (choice.equals(correctAns)) {
                    points += 5;
                }
            }
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }

    public static void Exam() {
        System.out.println("\nThe exam has started! Type 'submit' at any time to finish early.");

        // Auto-submit the exam after 1 minute
        examTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Auto-submitting the exam...");
                examEnded = true;
            }
        }, 60000); // 1 minute

        Question_Paper("What is the default value of a boolean variable in Java?", "true", "false", "null", "0", "false");
        Question_Paper("Which of the following is not a Java keyword?", "static", "finally", "boolean", "constructor", "constructor");
        Question_Paper("What will be the output of the following code?\n int x = 5;" + "\n System.out.println(x++ * ++x);\n", "30", "35", "25", "Compilation error", "30");
        Question_Paper("Which of the following is true about Java?", "Java is platform-dependent", "Java supports multiple inheritance through classes", "Java has automatic memory management", "Java does not support method overloading", "Java has automatic memory management");
        Question_Paper("What does the final keyword mean when applied to a variable in Java?", "The variable can be modified only within the class", "The variable cannot be modified after initialization", "The variable is accessible only within the package", "The variable is automatically initialized", "The variable cannot be modified after initialization");

        // Print final score if exam ends
        System.out.println("\nFinal Score: " + points);
    }

}
