import tetris.gui.ActionEvent;
import tetris.gui.ActionHandler;
import tetris.gui.Block;
import tetris.gui.GUI;

public class Game {

    //    private static final GUI gui = new GUI(10, 20);
//    private static GUI gui;
    private static Block block;

    public Game(GUI gui) {
        start(gui);
    }


    public static void start(GUI gui) {
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
        // TODO create random colors with random number generator
        createBlock(9, 19, 6, gui);

        while (true) {
            handleEvent(gui);
            updateGUI(gui);
        }

    }

    public static void createBlock(int i, int i1, int i2, GUI gui) {
        System.out.println("call method \"createBlock\"");
        block = new Block(i, i1, i2);
        gui.drawBlock(block);
    }

    public static void handleEvent(GUI gui) {
        System.out.println("call method \"handleEvent\"");

        //********* Handles all the movements of the blocks ************************
        final ActionHandler actionHandler = new ActionHandler() {
            @Override
            public void moveDown() {
                block.y--;
            }

            @Override
            public void moveLeft() {
                block.x--;
            }

            @Override
            public void moveRight() {
                block.x++;
            }

            @Override
            public void rotateLeft() {

            }

            @Override
            public void rotateRight() {

            }

            @Override
            public void drop() {

            }
        };


        ActionEvent event = gui.waitEvent();
        switch (event) {
            case MOVE_LEFT -> actionHandler.moveLeft();
            case MOVE_RIGHT -> actionHandler.moveRight();
            case MOVE_DOWN -> actionHandler.moveDown();
        }
//***************************************************
    }

    public static void updateGUI(GUI gui) {
        System.out.println("call method \"updateGUI\"");
        gui.clear();
        gui.drawBlock(block);
    }
}



