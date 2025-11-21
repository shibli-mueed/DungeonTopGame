# `Entity.java`

## Overview

The `Entity.java` file provides the abstract base class for all game objects that can exist on the board, such as minions. It defines the common properties and functionalities that all such objects share, including health, attack power, position, and combat actions.

## Abstract Class: `Entity`

This is an `abstract` class, meaning it cannot be instantiated directly. It must be extended by concrete classes (like `Minion`).

### Properties

-   **`name`**: The name of the entity (e.g., "Hero", "Goblin").
-   **`health`**: The entity's current health points.
-   **`maxHealth`**: The entity's maximum possible health points.
-   **`attack`**: The amount of damage the entity deals in combat.
-   **`x`, `y`**: The entity's current coordinates on the game board.

### Constructor

-   **`Entity(String name, int maxHealth, int attack)`**
    -   Initializes a new entity with its name, maximum health, and attack value.
    -   The entity's current `health` is set to its `maxHealth` upon creation.

### Abstract Methods

-   **`getSymbol()`**
    -   An abstract method that must be implemented by any subclass.
    -   It is intended to return a single character (`String`) that represents the entity on the console game board (e.g., "P" for Player minions).

### Public Methods

-   **`getX()` / `getY()`**
    -   Return the entity's current X or Y coordinate.

-   **`setPosition(int x, int y)`**
    -   Updates the entity's internal `x` and `y` coordinates. This is typically called by the `Board` when the entity is placed or moved.

-   **`getName()`**
    -   Returns the entity's name.

-   **`getAttack()`**
    -   Returns the entity's attack value.

-   **`attack(Entity target)`**
    -   Initiates an attack against another `Entity`. It calls the `takeDamage` method on the `target`, passing its own `attack` value.

-   **`takeDamage(int amount)`**
    -   Reduces the entity's `health` by the specified `amount`.
    -   Ensures that health cannot drop below zero.

-   **`isAlive()`**
    -   Returns `true` if the entity's `health` is greater than 0, and `false` otherwise. This is used to determine if an entity has been defeated.

-   **`getHealth()`**
    -   Returns the entity's current health.
