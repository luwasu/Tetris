package tetris.model;

import tetris.gui.ActionHandler;
import tetris.gui.GUI;
import tetris.model.figures.*;

import java.util.logging.Logger;

public class Game {


    private static final Logger LOGGER = Logger.getLogger("Game.class");
    private final GUI gui;
    private final Field field;
    private Figure figure;


    /**
     * Constructs a game with the specified graphical user interface.
     *
     * @param width  the width of the field
     * @param height the height of the field
     * @param gui    the graphical user interface
     */
    public Game(int width, int height, GUI gui) {
        this.gui = gui;
        this.field = new Field(width, height);
    }


    public void start() {
        createFigure();
        gui.setActionHandler(new FigureController());
    }


    public void stop() {
        gui.setActionHandler(null);
        figure = null;
    }


    public void createFigure() {

//        int xOfBlock = (field.getWidth() - 1) / 2;
//        int yOfBlock = field.getHeight() - 1;

        int xOfBlock = 1;
        int yOfBlock = 2;


        // default range is from 0 - 6
        int type = (int) (7 * Math.random());

        figure = switch (0) {
            case 0 -> new IFigure(xOfBlock, yOfBlock);
            case 1 -> new JFigure(xOfBlock, yOfBlock);
            case 2 -> new LFigure(xOfBlock, yOfBlock);
            case 3 -> new TFigure(xOfBlock, yOfBlock);
            case 4 -> new OFigure(xOfBlock, yOfBlock);
            case 5 -> new SFigure(xOfBlock, yOfBlock);
            case 6 -> new ZFigure(xOfBlock, yOfBlock);
            default -> throw new IllegalStateException("Invalid type");
        };



        // Check if the next figure fits into the field
        try {
            field.detectCollision(figure.getBlocks());
        } catch (CollisionException ex) {
            stop();
        }
        updateGUI();

    }

    // Check if the figure has landed within the field and add the individual blocks to a HashSet
    private void figureLanded() {
        field.addBlocks(figure.getBlocks());
        start();
    }

    /**
     * Updates the graphical user interface according to the current state of the game.
     */
    public void updateGUI() {
        gui.drawBlocks(figure.getBlocks());
        gui.drawBlocks(field.getBlocks());
    }

    /**
     * The class FigureController is used to control the figure of the Tetris game.
     **/
    private class FigureController implements ActionHandler {


        @Override
        public void moveDown() {

            try {

                figure.move(0, -1);
                field.detectCollision(figure.getBlocks());
                updateGUI();


            } catch (CollisionException e) {
                e.printStackTrace();
                figure.move(0, 1);
                figureLanded();
            }


         }

        @Override
        public void moveLeft() {

            figure.getBlocks();

            try {
                figure.move(-1, 0);
                field.detectCollision(figure.getBlocks());
                updateGUI();
            } catch (CollisionException e) {
                e.printStackTrace();
                figure.move(1, 0);
            }

        }

        @Override
        public void moveRight() {

            try {
                figure.move(+1, 0);
                field.detectCollision(figure.getBlocks());
                updateGUI();
            } catch (CollisionException e) {
                e.printStackTrace();
                figure.move(-1, 0);

            }
        }

        @Override
        public void rotateLeft() {

            try {
                figure.rotate(-1);
                field.detectCollision(figure.getBlocks());
                updateGUI();
            } catch (CollisionException e) {
                e.printStackTrace();
                figure.rotate(1);

            }
        }

        @Override
        public void rotateRight() {
            try {
                figure.rotate(1);
                field.detectCollision(figure.getBlocks());
                updateGUI();
            } catch (CollisionException e) {
                e.printStackTrace();
                figure.rotate(-1);
            }
        }

        @Override
        public void drop() {
            try {
                figure.move(0, -1);
                field.detectCollision(figure.getBlocks());
                updateGUI();
                // keep dropping until exception
                drop();
            } catch (CollisionException e) {
                figure.move(0, 1);
                figureLanded();
            }
        }
    }
}



