package tetris.model;

import tetris.gui.Block;

public class Field {

    private final int height;
    private final int width;


    public Field(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public void detectCollision(Block[] blocks) throws CollisionException {

        for (Block block : blocks) {
            if (block.y ==  -1 || block.x < 0 || block.x > getWidth()-1 ){
                throw new CollisionException("A collision with the game field has occurred.");
            }
        }

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
