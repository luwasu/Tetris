package tetris;

import tetris.gui.GUI;
import tetris.model.Game;
import tetris.model.Scoring;

public class Tetris {
    /**
     * Creates a Tetris game using a graphical user interface and starts the game.
     *
     * @param args the width and height of the field
     */
    public static void main(String[] args) {
        int width = 10;
        int height = 20;

        Scoring scoring = new Scoring();

        scoring.loadHighScore();


        GUI gui = new GUI(width, height);
        Game game = new Game(width, height, gui);
        game.start();


    }
}
