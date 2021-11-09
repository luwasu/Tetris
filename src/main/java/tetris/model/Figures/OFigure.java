package tetris.model.Figures;

import tetris.gui.Block;
import tetris.model.Figure;

public class OFigure extends Figure {

    private static final int COLOR = 4;

    public OFigure(int x, int y) {
        blocks[0] = new Block(x, y, COLOR);
        blocks[1] = new Block(x + 1, y, COLOR);
        blocks[2] = new Block(x, y - 1, COLOR);
        blocks[3] = new Block(x + 1, y - 1, COLOR);
    }

    @Override
    public void rotate(int d) {
    }
}
