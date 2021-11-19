package tetris.model.figures;

import tetris.gui.Block;
import tetris.model.Figure;

public class TFigure extends Figure {

    private static final int COLOR = 6;

    public TFigure(int x, int y) {
        blocks[0] = new Block(x, y, COLOR);
        blocks[1] = new Block(x - 1, y, COLOR);
        blocks[2] = new Block(x + 1, y, COLOR);
        blocks[3] = new Block(x, y - 1, COLOR);
    }
}
