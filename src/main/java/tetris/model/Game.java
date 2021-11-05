package tetris.model;

import tetris.gui.ActionEvent;
import tetris.gui.GUI;
import tetris.model.Figures.*;

import java.util.Random;
import java.util.logging.Logger;

public class Game {


    private final GUI gui;
    private Figure figure;
    private final int width;
    private final int height;
    private static final Logger LOGGER = Logger.getLogger("Game.class");


    /**
     * Constructs a game with the specified graphical user interface.
     *
     * @param width  the width of the field
     * @param height the height of the field
     * @param gui    the graphical user interface
     */
    public Game(int width, int height, GUI gui) {
        this.width = width;
        this.height = height;
        this.gui = gui;
    }


    public void start() {
        System.out.println("This method will start the game!");

        /*
         * Block setup
         * left to right position
         * i: 0 - 9
         * bottom to top position
         * i1:0 - 19
         * colors of blocks
         * i2: red = 1, yellow = 2, pink = 3, blue = 4, turquoise = 5, green = 6, grey = 7,
         * */
        createFigure();
        while (true) {
            ActionEvent event = gui.waitEvent();
            handleEvent(event);
        }

    }

    public void createFigure() {

        int xOfBlock = (width - 1) / 2;
        int yOfBlock = height - 1;

        // default range is from(0 to 14) +1 at the end makes the range from(1 to 15)
        Random rand = new Random();
        switch (rand.nextInt(7) + 1) {
            case 1 -> figure = new IFigure(xOfBlock, yOfBlock);
            case 2 -> figure = new JFigure(xOfBlock, yOfBlock);
            case 3 -> figure = new LFigure(xOfBlock, yOfBlock);
            case 4 -> figure = new TFigure(xOfBlock, yOfBlock);
            case 5 -> figure = new OFigure(xOfBlock, yOfBlock);
            case 6 -> figure = new SFigure(xOfBlock, yOfBlock);
            case 7 -> figure = new ZFigure(xOfBlock, yOfBlock);
        }

        updateGUI();
    }

    public void handleEvent(ActionEvent event) {

        switch (event) {
            case MOVE_LEFT -> figure.move(-1, 0);
            case MOVE_RIGHT -> figure.move(+1, 0);
            case MOVE_DOWN -> figure.move(0, -1);
            case ROTATE_LEFT -> figure.rotate(0);
            // Helper to find other key combos
            default -> System.out.println(event);
        }
        updateGUI();
    }

    public void updateGUI() {

        gui.clear();
        gui.drawBlocks(figure.getBlock());
    }
}



