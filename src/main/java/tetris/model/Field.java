package tetris.model;

import tetris.gui.Block;

import java.util.*;

public class Field {

    private final Set<Block> SetOfBlocks;
    private final int height;
    private final int width;


    public Field(int width, int height) {
        this.height = height;
        this.width = width;
        this.SetOfBlocks = new HashSet<>();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void addBlocks(Block[] blocks) {
        this.SetOfBlocks.addAll(Arrays.asList(blocks));
    }


    public Set<Block> getSetOfBlocks() {
        return this.SetOfBlocks;
    }

    public void removeAllBlocks() {
        this.SetOfBlocks.clear();
    }

    public void detectCollision(Block[] blocks) throws CollisionException {
        Iterator<Block> itr = getSetOfBlocks().iterator();

        for (Block block : blocks) {
            if (block.x < 0 || block.x >= width || block.y < 0 || block.y >= height) {
                throw new CollisionException("A collision with the game field has occurred.");
            } else if (block.y == TODO) {
                throw new CollisionException("A collision with the game field height.");
            }

            for (Block placed : getSetOfBlocks()) {
                if (placed.x == block.x && placed.y == block.y) {
                    throw new CollisionException("Collision with other Block");
                }
            }
        }
    }
}






