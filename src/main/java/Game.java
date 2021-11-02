import tetris.gui.ActionEvent;
import tetris.gui.Block;
import tetris.gui.GUI;

public class Game {

    private static Block block;
    private static ActionEvent event;

    private static int randomInt() {
        int min = 1;
        int max = 7;
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public Game(GUI gui) {
        start(gui);
    }


    public void start(GUI gui) {
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
        createBlock(9, 19, randomInt(), gui);
        event = gui.waitEvent();

        while (true) {
            handleEvent(gui);
            updateGUI(gui);
        }

    }

    public void createBlock(int i, int i1, int i2, GUI gui) {
        System.out.println("call method \"createBlock\"");
        block = new Block(i, i1, i2);
        gui.drawBlock(block);
    }

    public void handleEvent(GUI gui) {
        System.out.println("call method \"handleEvent\"");

        // move this block to the top.


        event = gui.waitEvent();
        switch (event) {
            case MOVE_LEFT -> block.x--;
            case MOVE_RIGHT -> block.x++;
            case MOVE_DOWN -> block.y--;
            // Helper to find other key combos
            default -> System.out.println(event);
        }

    }

    public static void updateGUI(GUI gui) {
        System.out.println("call method \"updateGUI\"");
        gui.clear();
        gui.drawBlock(block);
    }
}



