# `Main.java`

## Overview

The `Main.java` file is the central hub of the game, containing the primary game loop and all logic related to player input, turn management, and UI rendering. It acts as the game engine, coordinating interactions between the various data structures (like `Board`, `Player`, `Minion`, `Card`) to create a playable experience.

## Class: `Main`

This class contains only static methods and serves as the entry point and controller for the entire application.

### Main Method

-   **`main(String[] args)`**
    -   **Entry Point:** This is where the program execution begins.
    -   **Initialization:** It sets up all necessary components for the game to start:
        -   A `Scanner` for user input.
        -   The main `Board`.
        -   The two `Player` controllers (one for the human Player, one for the Dungeon Master).
        -   The initial decks for both controllers via `setupDecks()`.
        -   The "Champion" minions (`Hero` and `Boss`) that serve as the primary objective.
    -   **Game Loop:** It contains the main `while (gameRunning)` loop that keeps the game running. Inside this loop, it:
        1.  Calls `handleTurn()` to process the current player's actions.
        2.  Checks for win conditions by seeing if either Champion minion is no longer alive.
        3.  Switches the `currentPlayer` and `opponent` if the turn has ended.
        4.  Increments the turn counter and prepares the next player for their turn.

### Core Static Methods

-   **`handleTurn(Scanner, Board, Player, Player)`**
    -   Manages all actions for a single player's turn within a `while` loop.
    -   **Resets Actions:** At the beginning, it resets the `hasMovedThisTurn` and `hasAttackedThisTurn` flags for all of the current player's minions.
    -   **Input Parsing:** It reads user input and parses it to determine the desired action. It's designed to handle simplified commands (`w` for move, `aw` for attack, `s` for select, `p` for play).
    -   **Action Delegation:** Based on the parsed command, it calls other helper methods (like `handleMinionAction`) or directly modifies the game state (like selecting a minion or playing a card).
    -   The turn continues until the user types the `end` command.

-   **`handleMinionAction(String, String, Minion, Board)`**
    -   Executes a `move` or `attack` command for a selected minion.
    -   **Action Check:** It first checks if the minion has already performed that specific action this turn (e.g., `hasMovedThisTurn`).
    -   **Execution:** If the action is valid, it updates the game state by moving the entity on the board or by making it attack a target.
    -   **State Update:** It sets the appropriate action flag (`setHasMovedThisTurn` or `setHasAttackedThisTurn`) to `true` after the action is performed.

-   **`printGameState(Board, Player, Player, Minion)`**
    -   This is the master rendering method responsible for the entire console UI.
    -   It clears the console screen to create a smooth, non-scrolling display.
    -   It draws all UI components in a structured order: DM stats, the game board, Player stats, the last event log, the player's hand, and information about the currently selected minion.

-   **`logEvent(String)`**
    -   Updates a static string variable (`lastEvent`) with the most recent game event. This message is then displayed by `printGameState`.

-   **`setupDecks(Player, Player)`**
    -   A helper method that creates and assigns a starting `Deck` of `SummonCard`s to both the Player and the Dungeon Master.

-   **`printHelp()`**
    -   Prints a list of available commands directly to the console. It includes a pause to ensure the user has time to read it before the screen is redrawn.
