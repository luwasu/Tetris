package tetris.model.Figures;

import tetris.gui.Block;

public class SFigure extends Figure {

    private static final int color = 5;

    public SFigure(int x, int y) {
        super(x, y);
        blocks = new Block[]{
                new Block(x + 1, y, color),
                new Block(x, y, color),
                new Block(x, y - 1, color),
                new Block(x - 1, y - 1, color),};
    }
}
