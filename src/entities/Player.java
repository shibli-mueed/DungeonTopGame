package entities;

import board.Board;
import cards.Card;
import cards.Deck; // Import added
import java.util.ArrayList;
import java.util.List;

//package entities;

import board.Board;
import cards.Card;
import cards.Deck;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private int mana;
    private int maxMana;
    private int turnManaGrowth; // How much max mana increases each turn

    // Card Zones
    private final List<Card> hand;
    private final List<Card> discardPile;
    private final Deck deck;
    private final int drawAmount; // How many cards to draw per turn

    public Player(String name, int startingMana, int drawAmount) {
        this.name = name;
        this.maxMana = startingMana;
        this.mana = startingMana;
        this.turnManaGrowth = 1;
        this.drawAmount = drawAmount;

        this.hand = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        this.deck = new Deck();
    }

    // --- Deck Management ---
    public void setDeck(Deck deck) {
        this.deck.clear(); // Clear any existing deck
        this.deck.addAll(deck.getCards());
        this.deck.shuffle();
    }

    public void drawCard() {
        if (hand.size() >= 10) { // Max hand size
            System.out.println("Hand is full!");
            return;
        }
        Card drawnCard = deck.draw();

        // If deck is empty, recycle discard pile
        if (drawnCard == null) {
            if (discardPile.isEmpty()) {
                System.out.println(name + " has no cards left to draw!");
                return;
            }
            System.out.println("Reshuffling Discard Pile into Deck for " + name + "...");
            deck.addAll(discardPile);
            discardPile.clear();
            deck.shuffle();
            drawnCard = deck.draw(); // Try again
        }

        if (drawnCard != null) {
            hand.add(drawnCard);
        }
    }

    // --- Turn Logic ---
    public void startTurn(int turnNumber) {
        // Mana increases each turn up to a max of 10
        if (this.maxMana < 10) {
            this.maxMana += this.turnManaGrowth;
        }
        this.mana = this.maxMana;

        // Draw cards for the turn
        for (int i = 0; i < drawAmount; i++) {
            drawCard();
        }
    }

    // --- Play Logic ---
    public void playCard(int handIndex, Board board) {
        if (handIndex < 0 || handIndex >= hand.size()) {
            System.out.println("Invalid card index.");
            return;
        }

        Card card = hand.get(handIndex);

        // Pass 'this' player as the owner
        boolean success = card.play(this, board);

        if (success) {
            hand.remove(handIndex);
            discardPile.add(card);
            System.out.println(this.name + " played " + card.getName());
        }
    }

    public String getName() { return name; }
    public int getMana() { return mana; }
    public int getMaxMana() { return maxMana; }
    public List<Card> getHand() { return hand; }
    public int getDeckSize() { return deck.size(); }
    public int getDiscardSize() { return discardPile.size(); }

    public void spendMana(int amount) { this.mana -= amount; }
}