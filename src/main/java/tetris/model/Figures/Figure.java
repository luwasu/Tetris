package tetris.model.Figures;

import tetris.gui.Block;

public abstract class Figure {


    protected Block[] blocks;



    public Figure(int x, int y) {
        /*
         * Block setup
         * left to right position
         * i: 0 - 9
         * bottom to top position
         * i1:0 - 19
         * colors of blocks
         * i2:
         * red       = 1,
         * yellow    = 2,
         * pink      = 3,
         * blue      = 4,
         * turquoise = 5,
         * green     = 6,
         * grey      = 7,
         * */
        blocks = new Block[4];
    }



    public Block[] getBlock() {
        return blocks;
    }

    public void move(int dx, int dy) {

        for (Block block : blocks) {
            block.x += (dx);
            block.y += (dy);
        }
    }

    public void rotate(int d) {
        int cx = blocks[1].x;
        int cy = blocks[1].y;

//        if (blocks[0].x == cx - 1) {
//            // 90 degrees
//            blocks[0].x = cx;
//            blocks[0].y = cy - 1;
//
//            blocks[2].x = cx;
//            blocks[2].y = cy + 1;
//
//            blocks[3].x = cx;
//            blocks[3].y = cy + 2;
//        } else if (blocks[0].y == cy - 1) {
//            // rotate 180 degrees
//            blocks[0].x = cx + 1;
//            blocks[0].y = cy;
//
//            blocks[2].x = cx - 1;
//            blocks[2].y = cy;
//
//            blocks[3].x = cx - 2;
//            blocks[3].y = cy;
//        } else if (blocks[0].x == cx + 1) {
//            // rotate 270 degrees
//            blocks[0].x = cx;
//            blocks[0].y = cy + 1;
//
//            blocks[2].x = cx;
//            blocks[2].y = cy - 1;
//
//            blocks[3].x = cx;
//            blocks[3].y = cy - 2;
//        } else if (blocks[0].y == cy + 1) {
//            // back to original position
//            blocks[0].x = cx - 1;
//            blocks[0].y = cy;
//
//            blocks[2].x = cx + 1;
//            blocks[2].y = cy;
//
//            blocks[3].x = cx + 2;
//            blocks[3].y = cy;
//        }

    }
}



