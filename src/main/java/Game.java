import tetris.gui.Block;
import tetris.gui.GUI;

public class Game {

    private static final GUI gui = new GUI(10, 20);


    public Game() {
    }

    public void start() {
        System.out.println("This method will start the game!");
    }

    public static void createBlock(int i, int i1, int i2) {
        System.out.println("call method \"createBlock\"");
        Block block = new Block(i, i1, i2);
        gui.drawBlock(block);
    }

    public static void handleEvent() {
        System.out.println("call method \"handleEvent\"");
    }

    public void updateGUI() {
        System.out.println("This method will update the GUI!");
    }

}
