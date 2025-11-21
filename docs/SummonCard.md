# `SummonCard.java`

## Overview

The `SummonCard.java` file defines a specific type of `Card` whose purpose is to summon a new `Minion` onto the game board. It extends the abstract `Card` class and implements the logic for placing a new unit into play.

## Class: `SummonCard`

This class extends the abstract `Card` class.

### Properties

-   **`minionName`**: The name of the minion that this card summons.
-   **`minionHp`**: The health points of the summoned minion.
-   **`minionAtk`**: The attack power of the summoned minion.

### Constructor

-   **`SummonCard(String name, int cost, String minionName, int minionHp, int minionAtk)`**
    -   Initializes the card by calling the `super` constructor with the card's `name` and mana `cost`.
    -   It also sets the properties for the minion to be summoned (`minionName`, `minionHp`, `minionAtk`).

### Public Methods

-   **`play(Player player, Board board)`**
    -   This method contains the logic for what happens when the card is played. It performs the following steps:
        1.  **Mana Check:** Verifies if the `player` has enough mana to pay the card's `manaCost`.
        2.  **Find Spawn Location:** Calls the `findValidSpawnTile()` helper method to locate a valid empty tile adjacent to one of the player's other minions.
        3.  **Pay Mana:** If the checks pass, it deducts the mana cost from the player.
        4.  **Create and Place Minion:** It instantiates a new `Minion` object with the specified stats and the `player` as its owner, then places it on the board at the valid spawn location.
    -   Returns `true` if the card was played successfully, `false` otherwise.

-   **`toString()`**
    -   Overrides the default `toString()` method to provide a clear, descriptive string for the card, including its name, mana cost, and the stats of the minion it summons. Example: `Squire (1 Mana) - Summons Squire (5 HP, 2 ATK)`.

### Private Methods

-   **`findValidSpawnTile(Player player, Board board)`**
    -   A helper method that searches the entire board to find a valid location to summon a new minion.
    -   A tile is considered a valid spawn location if it is empty and is directly adjacent (North, South, East, or West) to another minion owned by the `player`.
    -   It returns the first valid `Tile` it finds, or `null` if no valid location is available.
