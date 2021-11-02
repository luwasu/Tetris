import tetris.gui.GUI;

public class Tetris {

//    setup and use a default size
//    one should never add literal numbers in your code
//    one can hand over the GUI in the start method
//    refactor the Game class because the chain of gui handover is to complext

    public static void main(String[] args) {

        GUI gui = new GUI(10,20);
        Game game = new Game(gui);

    }
}
