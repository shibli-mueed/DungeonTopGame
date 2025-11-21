# Game Mechanics Calculations

This document outlines the core calculations that govern the game mechanics of Dungeon Top.

## Combat

### Damage Calculation

When a minion attacks a target, the damage is calculated in a straightforward manner:

-   `Damage = Attacker's Attack Value`

The defender's health is then reduced by this amount:

-   `Defender's New HP = Defender's Current HP - Damage`

There is currently no concept of defense or armor. Combat is a direct reduction of health based on the attacker's power. There are no counter-attacks; only the attacker deals damage.

## Mana

### Mana Growth

Each controller (`Player` and `Dungeon Master`) has a maximum mana pool that grows over time to allow for more powerful plays as the game progresses.

-   At the beginning of each of their turns, a controller's maximum mana increases by **1**.
-   This growth stops once the maximum mana reaches a cap of **10**.

### Mana Restoration

-   At the start of every turn, a controller's current mana is fully restored to their current maximum mana value.

## Card Costs

-   When a card is played, its `manaCost` is subtracted from the controller's current mana pool.
-   A card cannot be played if its `manaCost` is greater than the controller's current mana.

## Action Economy

Each minion has a set number of actions it can perform per turn, promoting tactical decisions.

-   **Movement:** A minion can move **once** per turn.
-   **Attack:** A minion can attack **once** per turn.

These two actions are independent. A minion can both move and attack in the same turn (in any order). At the start of a controller's turn, all of their minions have their actions reset, allowing them to act again.

## Win/Loss Condition

The game is decided by the fate of the two "Champion" minions that start on the board: the **Hero** (belonging to the Player) and the **Boss** (belonging to the Dungeon Master).

-   The **Player wins** if the Dungeon Master's **Boss** minion's HP is reduced to 0 or less.
-   The **Dungeon Master wins** if the Player's **Hero** minion's HP is reduced to 0 or less.
