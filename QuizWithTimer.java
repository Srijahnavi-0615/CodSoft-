import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizWithTimer {
    private static final Scanner input = new Scanner(System.in);
    private static final int TIME_LIMIT_SECONDS = 10;
    private static int score = 0;
    private static boolean answeredInTime = false;

    // Question structure
    static class Question {
        String questionText;
        String[] options;
        char correctOption;

        Question(String questionText, String[] options, char correctOption) {
            this.questionText = questionText;
            this.options = options;
            this.correctOption = correctOption;
        }

        void display() {
            System.out.println("\n" + questionText);
            char optionLabel = 'A';
            for (String option : options) {
                System.out.println(optionLabel + ". " + option);
                optionLabel++;
            }
        }
    }

    public static void main(String[] args) {
        Question[] questions = {
            new Question("What is the capital of india?",
                         new String[]{"gujarat", "telangana", "utharpradesh", "new delhi"}, 'D'),
            new Question("Which planet is known as the Red Planet?",
                         new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 'B'),
            new Question("What is the colour of sky?",
                         new String[]{"orange", "white", "red", "blue"}, 'B')
        };

        System.out.println("~~~~~~~~~ Welcome to the Quiz Game ~~~~~~~~~~~~~");
        System.out.println("You have " + TIME_LIMIT_SECONDS + " seconds to answer each question.");

        for (Question q : questions) {
            q.display();
            answeredInTime = false;

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    if (!answeredInTime) {
                        System.out.println("\nOpps!! Time's up!");
                        System.out.println("No points awarded for this question.");
                        timer.cancel();
                    }
                }
            }, TIME_LIMIT_SECONDS * 1000);

            long startTime = System.currentTimeMillis();
            System.out.print("Enter your answer (A/B/C/D): ");
            String value = input.nextLine().trim().toUpperCase();

            long endTime = System.currentTimeMillis();
            long timeTaken = (endTime - startTime) / 1000;

            if (timeTaken <= TIME_LIMIT_SECONDS && value.length() == 1) {
                answeredInTime = true;
                timer.cancel();

                if (value.charAt(0) == q.correctOption) {
                    System.out.println(":) Correct!");
                    score++;
                } else {
                    System.out.println(":(( Wrong. The correct answer was " + q.correctOption + ".");
                }
            } else if (timeTaken > TIME_LIMIT_SECONDS) {
                // Already handled by timer
            } else {
                System.out.println(":( Invalid input.");
                timer.cancel();
            }
        }

        System.out.println("\n~~~~~~~~~~~~Quiz Over ~~~~~~~~~~~~~~~");
        System.out.println("Your Score: " + score + " out of " + questions.length);
    }
}
