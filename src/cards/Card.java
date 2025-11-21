package cards;

import board.Board;
import entities.Player;

public abstract class Card {
    protected String name;
    protected int manaCost;

    public Card(String name, int manaCost) {
        this.name = name;
        this.manaCost = manaCost;
    }

    public String getName() { return name; }
    public int getManaCost() { return manaCost; }

    // Abstract method: Every card must define what happens when played
    // Returns true if the card was successfully played, false if it failed (e.g. invalid target)
    public abstract boolean play(Player player, Board board);

    @Override
    public String toString() {
        return name + " (" + manaCost + " Mana)";
    }
}