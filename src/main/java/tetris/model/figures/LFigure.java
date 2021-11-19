package tetris.model.figures;

import tetris.gui.Block;
import tetris.model.Figure;

public class LFigure extends Figure {

    private static final int COLOR = 3;

    public LFigure(int x, int y) {
        blocks[0] = new Block(x, y, COLOR);
        blocks[1] = new Block(x - 1, y, COLOR);
        blocks[2] = new Block(x + 1, y, COLOR);
        blocks[3] = new Block(x - 1, y - 1, COLOR);
    }
}
