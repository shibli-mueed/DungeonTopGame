# `Player.java`

## Overview

The `Player.java` file defines the class that represents a controller in the game. A `Player` object is not a physical entity on the board, but rather the "brains" of an operation, responsible for managing a deck of cards, a hand, and a mana pool. Both the human player and the AI Dungeon Master are instances of this `Player` class.

## Class: `Player`

### Properties

-   **`name`**: The name of the controller (e.g., "Player", "Dungeon Master").
-   **`mana`**: The current amount of mana the player has available to spend.
-   **`maxMana`**: The maximum mana the player can have. This value increases over the course of the game.
-   **`turnManaGrowth`**: The amount by which `maxMana` increases each turn.
-   **`hand`**: A `List<Card>` representing the cards the player can currently play.
-   **`discardPile`**: A `List<Card>` where played or discarded cards are sent.
-   **`deck`**: A `Deck` object containing the cards the player can draw from.
-   **`drawAmount`**: The number of cards the player draws at the start of their turn.

### Constructor

-   **`Player(String name, int startingMana, int drawAmount)`**
    -   Initializes a new controller with a name, a starting mana value, and a set number of cards to draw each turn.
    -   It also initializes the `hand`, `discardPile`, and `deck` collections.

### Public Methods

#### Deck and Card Management

-   **`setDeck(Deck deck)`**
    -   Assigns a new deck to the player. It clears any previous deck, adds all cards from the new deck, and shuffles it.

-   **`drawCard()`**
    -   Draws a single card from the `deck` and adds it to the `hand`.
    -   **Recycling:** If the deck is empty, this method automatically takes all cards from the `discardPile`, adds them back to the deck, shuffles the deck, and then completes the draw.
    -   It prevents drawing if the hand is full (10 cards).

-   **`playCard(int handIndex, Board board)`**
    -   Plays a card from the hand.
    -   It validates the card index and then calls the card's own `play()` method.
    -   If the card is played successfully, it is moved from the `hand` to the `discardPile`.

#### Turn and Resource Management

-   **`startTurn(int turnNumber)`**
    -   Performs start-of-turn actions.
    -   **Mana Growth:** It increases the player's `maxMana` by the `turnManaGrowth` value (up to a maximum of 10).
    -   **Mana Restoration:** It refills the player's current `mana` to the new `maxMana`.
    -   **Card Draw:** It calls `drawCard()` for the number of times specified by `drawAmount`.

-   **`spendMana(int amount)`**
    -   Subtracts a specified `amount` from the player's current `mana`.

#### Getters

-   Provides public getters for all relevant properties: `getName()`, `getMana()`, `getMaxMana()`, `getHand()`, `getDeckSize()`, and `getDiscardSize()`.
