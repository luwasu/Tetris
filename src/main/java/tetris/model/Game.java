package tetris.model;

import tetris.gui.ActionHandler;
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
        createFigure();
        FigureController figureController = new FigureController();

        gui.setActionHandler(figureController);
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

    public void updateGUI() {
        gui.clear();
        gui.drawBlocks(figure.getBlock());
    }

    private class FigureController implements ActionHandler {

        final int width = Game.this.width;
        final int height = Game.this.height;
        Field field = new Field(width, height);



        @Override
        public void moveDown() {

            try {
                figure.move(0, -1);
                field.detectCollision(figure.blocks);
            } catch (CollisionException e) {
                e.printStackTrace();
                figure.move(0, 1);
            }
            updateGUI();
        }

        @Override
        public void moveLeft() {

           figure.getBlock();

            try {
                figure.move(-1, 0);
                field.detectCollision(figure.blocks);
            } catch (CollisionException e) {
                e.printStackTrace();
                figure.move(1, 0);
            }
            updateGUI();
        }

        @Override
        public void moveRight() {

            try {
                figure.move(+1, 0);
                field.detectCollision(figure.blocks);
            } catch (CollisionException e) {
                e.printStackTrace();
                figure.move(-1, 0);
            }
            updateGUI();
        }

        @Override
        public void rotateLeft() {

            try {
                figure.rotate(-1);
                field.detectCollision(figure.blocks);
            } catch (CollisionException e) {
                e.printStackTrace();
                figure.rotate(1);
            }
            updateGUI();
        }

        @Override
        public void rotateRight() {
            try {
                figure.rotate(1);
                field.detectCollision(figure.blocks);
            } catch (CollisionException e) {
                e.printStackTrace();
                figure.rotate(-1);
            }
            updateGUI();
        }

        @Override
        public void drop() {
            updateGUI();
        }
    }

}



