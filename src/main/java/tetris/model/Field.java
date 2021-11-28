package tetris.model;

import tetris.gui.Block;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private final List<Block> blocks = new ArrayList<>();
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

    public List<Block> getBlocks() {
        return blocks;
    }

    public void addBlocks(Block[] blocks) {
        for (Block b : blocks) {
            this.blocks.add(b);
        }
    }


    public void removeAllBlocks() {
        blocks.clear();
    }

    private boolean isRowFull(int y) {
        int counter = 0;

        for (Block block : this.blocks) {
            if (block.y == y) {
                counter++;
            }
        }
        return counter == getWidth();
    }


    public void detectCollision(Block[] blocks) throws CollisionException {


        for (Block block : blocks) {
            if (block.x < 0 || block.x >= width || block.y < 0 || block.y > height) {
                throw new CollisionException("A collision with the game field has occurred.");
            } else {
                for (Block placed : this.blocks) {
                    if (placed.x == block.x && placed.y == block.y) {
                        throw new CollisionException("Collision with other Block");
                    }
                }
            }
        }
    }


}






