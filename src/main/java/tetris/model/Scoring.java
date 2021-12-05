package tetris.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Scoring {

    public static final String HIGH_SCORE_FILE = "HighScore.txt";
    private int highScore;
    private int removedRows;
    //    private static final int ROWS_PER_LEVEL;
    private int score;
//    private static final int[] SCORE_REWARDS;


    public Scoring() {


    }

    public int getHighScore() {

        return 0;
    }

    public int getLevel() {
        return 0;
    }

    public int getScore() {
        return score;
    }

    // TODO change to private when done testing
    public void loadHighScore() {

        try {
            File myHighScoreFile = new File(HIGH_SCORE_FILE);

            // Check if file already exists. If not then create a txt file.
            if (myHighScoreFile.createNewFile()) {
                System.out.println("Successfully created " + myHighScoreFile.getName());

                // write an initial score to the created txt file
                FileWriter myHighScoreFileWriter = new FileWriter(HIGH_SCORE_FILE);
                myHighScoreFileWriter.write("0");
                System.out.println("Successfully wrote to the " + myHighScoreFile.getName() + ".");
                myHighScoreFileWriter.close();

                // Read the score from the file
                Scanner myReader = new Scanner(myHighScoreFile);
                while (myReader.hasNextLine()) {
                    String fileScore = myReader.nextLine();
                    System.out.println("The high score is: " + fileScore);
                }
                myReader.close();

            } else {
                System.out.println(myHighScoreFile.getName() + " file already exists.");

                // Read the score from the file
                Scanner myReader = new Scanner(myHighScoreFile);
                while (myReader.hasNextLine()) {
                    String fileScore = myReader.nextLine();
                    System.out.println("The high score is: " + fileScore);
                }
                myReader.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    public void reset() {

    }

    private void savedHighScore() {

    }

    public void updateHighScore() {

    }

    public void updateScore(int nrows) {

    }
}

