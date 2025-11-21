# `Board.java`

## Overview

The `Board.java` file defines the main game board. It is responsible for creating and managing the 2D grid of `Tile` objects, placing and moving entities, and rendering the board state to the console.

## Class: `Board`

Represents the game board as a 2D array of `Tile` objects.

### Constructor

-   **`Board(int width, int height)`**
    -   Initializes a new board with the specified `width` and `height`.
    -   It calls the private `initializeBoard()` method to populate the grid with `Tile` objects.

### Public Methods

-   **`placeEntity(Entity entity, int x, int y)`**
    -   Places a given `Entity` object onto the board at the specified `(x, y)` coordinates.
    -   It performs a bounds check to ensure the coordinates are valid.
    -   It updates the target `Tile` to contain the entity and also updates the entity's internal position to remember where it is.

-   **`printBoard()`**
    -   Renders a complete, formatted representation of the board to the console.
    -   This includes a header row for column indices, a number for each row, and borders for the grid, creating a clear and readable game state.

-   **`moveEntity(Entity entity, int newX, int newY)`**
    -   Moves an entity from its current position to a new `(newX, newY)` coordinate.
    -   It performs checks to ensure the move is valid (i.e., within the board boundaries and not onto an already occupied tile).
    -   If the move is valid, it removes the entity from its old tile, places it on the new tile, and updates the entity's internal coordinates.

-   **`removeEntity(Entity entity)`**
    -   Removes a specified entity from the board.
    -   It gets the entity's coordinates and clears the occupant of that `Tile`.

-   **`getTile(int x, int y)`**
    -   A getter method that safely returns the `Tile` object at a given `(x, y)` coordinate.
    -   It includes a bounds check and will return `null` if the requested coordinates are outside the board.

-   **`getAllEntities()`**
    -   Returns a `List<Entity>` containing every entity currently occupying a tile on the board.
    -   This is useful for iterating over all active minions without needing to check every single tile manually.

### Private Methods

-   **`initializeBoard()`**
    -   A private helper method called by the constructor.
    -   It iterates through every position in the `grid` array and populates it with a new `Tile` instance, ensuring the board is fully initialized on creation.
