# `Deck.java`

## Overview

The `Deck.java` file provides the class that manages a collection of `Card` objects. It represents a player's draw pile and includes core functionalities like adding cards, shuffling, and drawing.

## Class: `Deck`

A wrapper around a `List<Card>` that provides specialized methods for deck manipulation.

### Constructor

-   **`Deck()`**
    -   Initializes a new, empty deck.

### Public Methods

-   **`addCard(Card card)`**
    -   Adds a single `Card` to the deck.

-   **`addAll(List<Card> newCards)`**
    -   Adds all cards from a given `List<Card>` to the deck. This is primarily used to return all cards from the discard pile back into the deck for reshuffling.

-   **`shuffle()`**
    -   Randomizes the order of all cards currently in the deck using `Collections.shuffle()`.

-   **`draw()`**
    -   Removes and returns the top card from the deck (the card at index 0).
    -   If the deck is empty, it returns `null`.

-   **`size()`**
    -   Returns the number of cards currently remaining in the deck.

-   **`getCards()`**
    -   Returns a new `ArrayList<Card>` containing all the cards in the deck. This is used to safely get a copy of the deck's contents without exposing the internal list.

-   **`clear()`**
    -   Removes all cards from the deck.
