# `Minion.java`

## Overview

The `Minion.java` file defines the concrete implementation of an `Entity` that can be placed on the board. Minions are the primary units that players summon and command to move, attack, and achieve victory.

## Class: `Minion`

This class extends the abstract `Entity` class.

### Properties

-   **`owner`**: A `Player` object indicating who controls this minion. This is crucial for determining which minions are friendly or hostile.
-   **`hasMovedThisTurn`**: A boolean flag that tracks if the minion has already performed its move action for the current turn.
-   **`hasAttackedThisTurn`**: A boolean flag that tracks if the minion has already performed its attack action for the current turn.

### Constructor

-   **`Minion(String name, int health, int attack, Player owner)`**
    -   Initializes a new minion by calling the `super` constructor of the `Entity` class with its name, health, and attack values.
    -   It also sets the `owner` of the minion.

### Public Methods

-   **`getOwner()`**
    -   Returns the `Player` object that owns this minion.

-   **`hasMovedThisTurn()` / `setHasMovedThisTurn(boolean value)`**
    -   Getter and setter methods for the `hasMovedThisTurn` flag.

-   **`hasAttackedThisTurn()` / `setHasAttackedThisTurn(boolean value)`**
    -   Getter and setter methods for the `hasAttackedThisTurn` flag.

-   **`resetActionFlags()`**
    -   Resets both `hasMovedThisTurn` and `hasAttackedThisTurn` to `false`. This method is called at the beginning of the owner's turn to allow the minion to act again.

-   **`getSymbol()`**
    -   An implementation of the abstract method from `Entity`.
    -   It returns a symbol based on the minion's owner:
        -   `"P"` if the owner's name is "Player".
        -   `"D"` if the owner is anyone else (i.e., the "Dungeon Master").
