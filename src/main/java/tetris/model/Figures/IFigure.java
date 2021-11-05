package tetris.model.Figures;

import tetris.gui.Block;

public class IFigure extends Figure {

    private static final int color = 1;


    public IFigure(int x, int y) {
        super(x, y);
        blocks = new Block[]{
                new Block(x - 1, y, color),
                new Block(x, y, color),
                new Block(x + 1, y, color),
                new Block(x + 2, y, color),};
    }

    @Override
    public void rotate(int d) {
        int cx = blocks[1].x;
        int cy = blocks[1].y;

        if (blocks[0].x == cx - 1) {
            // 90 degrees
            blocks[0].x = cx;
            blocks[0].y = cy - 1;

            blocks[2].x = cx;
            blocks[2].y = cy + 1;

            blocks[3].x = cx;
            blocks[3].y = cy + 2;
        } else if (blocks[0].y == cy - 1) {
            // rotate 180 degrees
            blocks[0].x = cx + 1;
            blocks[0].y = cy;

            blocks[2].x = cx - 1;
            blocks[2].y = cy;

            blocks[3].x = cx - 2;
            blocks[3].y = cy;
        } else if (blocks[0].x == cx + 1) {
            // rotate 270 degrees
            blocks[0].x = cx;
            blocks[0].y = cy + 1;

            blocks[2].x = cx;
            blocks[2].y = cy - 1;

            blocks[3].x = cx;
            blocks[3].y = cy - 2;
        } else if (blocks[0].y == cy + 1) {
            // back to original position
            blocks[0].x = cx - 1;
            blocks[0].y = cy;

            blocks[2].x = cx + 1;
            blocks[2].y = cy;

            blocks[3].x = cx + 2;
            blocks[3].y = cy;
        }
    }
}
