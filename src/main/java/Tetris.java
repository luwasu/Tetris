import tetris.gui.GUI;

public class Tetris {

    public static void main(String[] args) {

        GUI gui = new GUI(10,20);
        Game game = new Game(gui);

    }
}
