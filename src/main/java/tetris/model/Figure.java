package tetris.model;

import tetris.gui.Block;

public abstract class Figure {

    protected final Block[] blocks = new Block[4];


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
        int cx = blocks[0].x;
        int cy = blocks[0].y;
        for (Block block : blocks) {
            int dx = block.x - cx;
            int dy = block.y - cy;
            block.x = cx + d * dy;
            block.y = cy - d * dx;
        }
    }
}



