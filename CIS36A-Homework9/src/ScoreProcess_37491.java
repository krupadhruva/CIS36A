import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Homework #9
 * Date: August 7, 2020
 * Purpose: Process the scores and print student and overall results
 * Author: Krupa Dhruva
 */
public class ScoreProcess_37491 {

    private final String fileName;
    double finalScoreAverage;
    int finalScoreMax;
    int finalScoreMin;

    public ScoreProcess_37491(String filename) {
        fileName = filename;
        finalScoreAverage = 0.0;

        // Note: Setting the initial value to something that will get replaced
        // Tried by initializing to both variables to 0 and found minimum score
        // would incorrectly show 0 for test data with no 0 score

        // Any value will be higher than the lowest value
        finalScoreMax = Integer.MIN_VALUE;
        // Any value will be lower than the highest value
        finalScoreMin = Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a student score file name: ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        scanner.close();

        File file = new File(filename);
        if (!file.exists()) {
            System.out.printf("Error: Student score file '%s' not found%n", filename);
            return;
        }

        System.out.println();
        ScoreProcess_37491 sp = new ScoreProcess_37491(filename);
        sp.processFile();
        System.out.println();
        sp.printFinalScoreStat();
    }

    // Calculate the average of scores in the array scores.
    // Return average with decimal fraction.
    // It is called by the processFile() method only.
    public double getAverageScore(int[] scores) {
        double totalScore = 0.0;
        for (int index = 0; index < scores.length; ++index) {
            totalScore += scores[index];
        }

        return totalScore / scores.length;
    }

    // Calculate the highest score in the array scores
    // It is called by the processFile() method only.
    public int getHighestScore(int[] scores) {
        int highestScore = scores[0];
        for (int index = 1; index < scores.length; ++index) {
            if (scores[index] > highestScore) {
                highestScore = scores[index];
            }
        }

        return highestScore;
    }

    // Calculate the lowest score in the array scores.
    // It is called by the processFile() method only.
    public int getLowestScore(int[] scores) {
        int lowestScore = scores[0];
        for (int index = 1; index < scores.length; ++index) {
            if (scores[index] < lowestScore) {
                lowestScore = scores[index];
            }
        }

        return lowestScore;
    }

    // Print the average final score, lowest final score, highest final score
    // It is called by main() method only.
    public void printFinalScoreStat() {
        System.out.format("%10s final score is: %20.2f%n" +
                        "%10s final score is: %20d%n" +
                        "%10s final score is: %20d%n",
                "Average", finalScoreAverage, "Highest", finalScoreMax, "Lowest", finalScoreMin);
    }

    public void processFile() throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        System.out.format("%10s %10s %10s %10s%n", "ID", "Average HW", "Lowest HW", "Highest HW");

        int students = 0;
        int totalFinalScore = 0;
        int[] scores = new int[8];

        while (scanner.hasNext()) {
            ++students;
            String studentId = scanner.next();
            for (int index = 0; index < 8; ++index) {
                scores[index] = scanner.nextInt();
            }

            // Ignore column 10
            scanner.next();

            // We only need the average
            int finalScore = scanner.nextInt();
            totalFinalScore += finalScore;

            // Ignore column 12
            scanner.next();
            // Ignore column 13
            scanner.next();

            if (finalScore < finalScoreMin) {
                finalScoreMin = finalScore;
            }

            if (finalScore > finalScoreMax) {
                finalScoreMax = finalScore;
            }

            System.out.format("%10s %10.2f %10d %10d%n", studentId, getAverageScore(scores), getLowestScore(scores), getHighestScore(scores));
        }

        finalScoreAverage = (double) totalFinalScore / students;

        scanner.close();
    }
}
