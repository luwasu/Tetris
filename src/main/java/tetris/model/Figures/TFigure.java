package tetris.model.Figures;

import tetris.gui.Block;

public class TFigure extends Figure {

    private static final int color = 6;

    public TFigure(int x, int y) {
        super(x, y);
        blocks = new Block[]{
                new Block(x++, y, color),
                new Block(x, y, color),
                new Block((++x), y, color),
                new Block(--x, ++y, color),};
    }
}
