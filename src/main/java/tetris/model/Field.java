package tetris.model;

import tetris.gui.Block;

public class Field {

    private final int height;
    private final int width;


    public Field(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    public void detectCollision(Block[] blocks) throws CollisionException {

        for (Block block : blocks) {
            if (block.x < 0 || block.x >= width || block.y < 0 || block.y >= height) {
                throw new CollisionException("A collision with the game field has occurred.");
            }
        }

    }
}
