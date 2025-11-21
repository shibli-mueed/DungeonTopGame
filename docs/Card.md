# `Card.java`

## Overview

The `Card.java` file provides the abstract base class for all cards in the game. It defines the common properties that all cards share, such as a name and a mana cost, and establishes a contract for what a card must be able to do.

## Abstract Class: `Card`

This is an `abstract` class, meaning it cannot be instantiated directly. It must be extended by concrete classes (like `SummonCard`) that implement its abstract methods.

### Properties

-   **`name`**: The name of the card (e.g., "Rat Pack").
-   **`manaCost`**: The amount of mana required to play the card.

### Constructor

-   **`Card(String name, int manaCost)`**
    -   Initializes a new card with its `name` and `manaCost`.

### Abstract Methods

-   **`play(Player player, Board board)`**
    -   An abstract method that must be implemented by any subclass.
    -   This method defines the card's primary effect when it is played.
    -   It is expected to return `true` if the card was played successfully and `false` if it failed for any reason (e.g., not enough mana, no valid target).

### Public Methods

-   **`getName()`**
    -   Returns the card's name.

-   **`getManaCost()`**
    -   Returns the card's mana cost.

-   **`toString()`**
    -   Overrides the default `toString()` method to provide a simple, readable representation of the card, including its name and mana cost. Example: `Iron Golem (3 Mana)`.
