import java.util.Scanner;
public class StudentGradeCalculator {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int subjectCount = input.nextInt();

        int[] marks = new int[subjectCount];
        int totalMarks = 0;

        // Input marks
        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = input.nextInt();

            // Validate input
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid input. Enter marks between 0 and 100: ");
                marks[i] = input.nextInt();
            }

            totalMarks += marks[i];
        }

        // Calculate average
        double average = (double) totalMarks / subjectCount;

        // Assign grade
        char grade = calculateGrade(average);

        // Display results
        System.out.println("\n------ Result ------");
        System.out.println("Total Marks: " + totalMarks + "/" + (subjectCount * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);
    }

    // Method to assign grade based on average
    private static char calculateGrade(double average) {
        if (average >= 90) return 'A';
        else if (average >= 80) return 'B';
        else if (average >= 70) return 'C';
        else if (average >= 60) return 'D';
        else if (average >= 50) return 'E';
        else return 'F';
    }
}
