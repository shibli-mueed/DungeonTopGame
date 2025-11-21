# `Tile.java`

## Overview

The `Tile.java` file defines the fundamental unit of the game board. Each `Tile` object represents a single square on the grid, holding its own coordinates and information about any entity that may be occupying it.

## Class: `Tile`

Represents a single tile on the game board.

### Constructor

-   **`Tile(int x, int y)`**
    -   Initializes a new tile with its `x` and `y` coordinates.
    -   The `occupant` is set to `null` by default, indicating the tile is empty.

### Public Methods

-   **`getX()` / `getY()`**
    -   Return the tile's X or Y coordinate on the board.

-   **`isOccupied()`**
    -   Returns `true` if an entity is currently on this tile (`occupant` is not `null`), and `false` otherwise.

-   **`getOccupant()`**
    -   Returns the `Entity` object currently occupying the tile. If the tile is empty, it returns `null`.

-   **`setOccupant(Entity occupant)`**
    -   Assigns an `Entity` to this tile. This is used when an entity moves to or is summoned onto the tile.

-   **`removeOccupant()`**
    -   Sets the `occupant` to `null`, effectively clearing the tile. This is used when an entity moves away from or is defeated on the tile.

-   **`toString()`**
    -   Provides a formatted, fixed-width string representation of the tile for console rendering.
    -   If the tile is occupied, it returns a string in the format ` S:HP `, where `S` is the entity's symbol and `HP` is its current health (e.g., ` P:25 `).
    -   If the tile is empty, it returns an empty, padded string to ensure the board's grid alignment remains consistent.
