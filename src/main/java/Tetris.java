import tetris.gui.ActionEvent;
import tetris.gui.Block;
import tetris.gui.GUI;

public class Tetris {

    public static void main(String[] args) {
        GUI gui = new GUI(10,20);
        Block block = new Block(5,5,5);

        while(true){
            gui.drawBlock(block);
            ActionEvent event = gui.waitEvent();
            block.x++;
            gui.clear();
            gui.drawBlock(block);
        }

    }
}
