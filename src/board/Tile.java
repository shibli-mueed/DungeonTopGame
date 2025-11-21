package board;

import entities.Entity; // We will create this next, ignore the error for a moment

public class Tile {
    private int x;
    private int y;
    private Entity occupant; // Who is standing here? (null if empty)

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.occupant = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOccupied() {
        return occupant != null;
    }

    public Entity getOccupant() {
        return occupant;
    }

    public void setOccupant(Entity occupant) {
        this.occupant = occupant;
    }

    public void removeOccupant() {
        this.occupant = null;
    }

    // Used for printing the board
    public String toString() {
        if (isOccupied()) {
            // Return a fixed-width string like "[P:25]"
            return String.format(" %s:%-2d ", occupant.getSymbol(), occupant.getHealth());
        } else {
            return "      "; // Empty tile with padding
        }
    }
}