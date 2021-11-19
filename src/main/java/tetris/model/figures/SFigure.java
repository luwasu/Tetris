package tetris.model.figures;

import tetris.gui.Block;
import tetris.model.Figure;

public class SFigure extends Figure {

    private static final int COLOR = 5;

    public SFigure(int x, int y) {
        blocks[0] = new Block(x, y, COLOR);
        blocks[1] = new Block(x + 1, y, COLOR);
        blocks[2] = new Block(x, y - 1, COLOR);
        blocks[3] = new Block(x - 1, y - 1, COLOR);
    }
}
