package tetris.model;

import tetris.gui.ActionEvent;
import tetris.gui.GUI;
import tetris.model.Figures.*;

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

        createFigure();
        while (true) {
            ActionEvent event = gui.waitEvent();
            handleEvent(event);
        }

    }

    public void createFigure() {

        int xOfBlock = (width - 1) / 2;
        int yOfBlock = height - 1;

        // default range is from 0 - 6
        int type = (int) (7 * Math.random());

        figure = switch (type) {
            case 0 -> new IFigure(xOfBlock, yOfBlock);
            case 1 -> new JFigure(xOfBlock, yOfBlock);
            case 2 -> new LFigure(xOfBlock, yOfBlock);
            case 3 -> new TFigure(xOfBlock, yOfBlock);
            case 4 -> new OFigure(xOfBlock, yOfBlock);
            case 5 -> new SFigure(xOfBlock, yOfBlock);
            case 6 -> new ZFigure(xOfBlock, yOfBlock);
            default -> throw new IllegalStateException("Invalid type");
        };
        updateGUI();
    }

    public void handleEvent(ActionEvent event) {

        switch (event) {
            case MOVE_LEFT -> figure.move(-1, 0);
            case MOVE_RIGHT -> figure.move(+1, 0);
            case MOVE_DOWN -> figure.move(0, -1);
            case ROTATE_LEFT -> figure.rotate(-1);
            case ROTATE_RIGHT -> figure.rotate(1);
        }
        updateGUI();
    }

    public void updateGUI() {
        gui.clear();
        gui.drawBlocks(figure.getBlock());
    }
}



