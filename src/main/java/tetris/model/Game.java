package tetris.model;

import tetris.gui.ActionEvent;
import tetris.gui.GUI;

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
        createBlock();
        while (true) {
            ActionEvent event = gui.waitEvent();
            handleEvent(event);
        }

    }

    public void createBlock() {
        LOGGER.info("call method \"createBlock\"");

        figure = new Figure((width - 1) / 2, height - 1);
        updateGUI();
    }

    public void handleEvent(ActionEvent event) {
        LOGGER.info("call method \"handleEvent\"");

        switch (event) {
            case MOVE_LEFT -> figure.move(-1, 0);
            case MOVE_RIGHT -> figure.move(+1, 0);
            case MOVE_DOWN -> figure.move(0, -1);
            // Helper to find other key combos
            default -> System.out.println(event);
        }
        updateGUI();
    }

    public void updateGUI() {
        LOGGER.info("call method \"updateGUI\"");
        gui.clear();
        gui.drawBlocks(figure.getBlock());
    }
}



