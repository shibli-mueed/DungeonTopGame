package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int size() {
        return cards.size();
    }

    // Returns null if deck is empty
    public Card draw() {
        if (cards.isEmpty()) {
            return null;
        }
        // Remove and return the top card (index 0)
        return cards.remove(0);
    }

    // Helper to add a whole list back (for reshuffling discard pile)
    public void addAll(List<Card> newCards) {
        cards.addAll(newCards);
    }

    // Used for setting up decks
    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public void clear() {
        cards.clear();
    }
}