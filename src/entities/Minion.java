package entities;

public class Minion extends Entity {
    private final Player owner;
    private boolean hasMovedThisTurn = false;
    private boolean hasAttackedThisTurn = false;

    public Minion(String name, int health, int attack, Player owner) {
        super(name, health, attack);
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean hasMovedThisTurn() {
        return hasMovedThisTurn;
    }

    public void setHasMovedThisTurn(boolean value) {
        this.hasMovedThisTurn = value;
    }

    public boolean hasAttackedThisTurn() {
        return hasAttackedThisTurn;
    }

    public void setHasAttackedThisTurn(boolean value) {
        this.hasAttackedThisTurn = value;
    }

    public void resetActionFlags() {
        this.hasMovedThisTurn = false;
        this.hasAttackedThisTurn = false;
    }

    @Override
    public String getSymbol() {
        // Use different symbols based on the owner's name
        if (owner.getName().equals("Player")) {
            return "P";
        } else {
            return "D";
        }
    }
}