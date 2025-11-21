package board;

import entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int width;
    private int height;
    private Tile[][] grid; // 2D Array

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Tile[width][height];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new Tile(i, j);
            }
        }
    }

    public void placeEntity(Entity entity, int x, int y) {
        // Check bounds (is x,y inside the map?)
        if (x >= 0 && x < width && y >= 0 && y < height) {
            // Update the Tile
            grid[x][y].setOccupant(entity);
            // Update the Entity's internal memory of where it is
            entity.setPosition(x, y);
        }
    }

    public void printBoard() {
        // Print header row (column indices)
        System.out.print("   "); // Padding for row numbers
        for (int x = 0; x < width; x++) {
            System.out.printf("   %d   ", x);
        }
        System.out.println();

        // Print top border
        System.out.print("  +");
        for (int x = 0; x < width; x++) {
            System.out.print("------+");
        }
        System.out.println();

        // Print board rows with row indices
        for (int y = 0; y < height; y++) {
            System.out.printf("%d |", y); // Row index
            for (int x = 0; x < width; x++) {
                System.out.print(grid[x][y].toString() + "|");
            }
            System.out.println();

            // Print separator line
            System.out.print("  +");
            for (int x = 0; x < width; x++) {
                System.out.print("------+");
            }
            System.out.println();
        }
    }

    public boolean moveEntity(Entity entity, int newX, int newY) {
        // Check for Valid Coordinates (Bounds Check)
        if (newX < 0 || newX >= width || newY < 0 || newY >= height) {
            System.out.println("You can't move off the board!");
            return false;
        }

        // Check if tile is already occupied (Collision)
        if (grid[newX][newY].isOccupied()) {
            System.out.println("That tile is blocked!");
            return false;
        }

        // Perform the move
        // Remove from old tile
        grid[entity.getX()][entity.getY()].removeOccupant(); // Method of Class Tile

        // Add to new tile
        grid[newX][newY].setOccupant(entity);

        // Update Entity's internal coordinates
        entity.setPosition(newX, newY);

        return true;
    }


    public void removeEntity(Entity entity) {
        if (entity == null) return;
        int x = entity.getX();
        int y = entity.getY();
        if (x >= 0 && x < width && y >= 0 && y < height) {
            grid[x][y].removeOccupant();
        }
    }

    public Tile getTile(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return grid[x][y];
        }
        return null; // Return null if coordinate is invalid
    }

    // all entries from the board
    public List<Entity> getAllEntities() {
        List<Entity> entities = new ArrayList<>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (grid[x][y].isOccupied()) {
                    entities.add(grid[x][y].getOccupant());
                }
            }
        }
        return entities;
    }

}