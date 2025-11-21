package cards;

import board.Board;
import board.Tile;
import entities.Entity;
import entities.Player;
import entities.Minion;

import java.util.List;

public class SummonCard extends Card {
    private final String minionName;
    private final int minionHp;
    private final int minionAtk;

    public SummonCard(String name, int cost, String minionName, int minionHp, int minionAtk) {
        super(name, cost);
        this.minionName = minionName;
        this.minionHp = minionHp;
        this.minionAtk = minionAtk;
    }

    @Override
    public boolean play(Player player, Board board) {
        // 1. Check Mana
        if (player.getMana() < this.manaCost) {
            System.out.println("Not enough Mana!");
            return false;
        }

        // 2. Find a spot to spawn
        // New logic: find any tile adjacent to one of the player's minions
        Tile spawnTile = findValidSpawnTile(player, board);

        if (spawnTile == null) {
            System.out.println("No space to summon! (Must be adjacent to a friendly minion)");
            return false;
        }

        // 3. Pay Mana
        player.spendMana(this.manaCost);

        // 4. Create and Place Minion, assigning the player as the owner
        Minion m = new Minion(minionName, minionHp, minionAtk, player);
        board.placeEntity(m, spawnTile.getX(), spawnTile.getY());

        System.out.println(player.getName() + " summoned " + minionName + "!");
        return true;
    }

    private Tile findValidSpawnTile(Player player, Board board) {
        List<Entity> allEntities = board.getAllEntities();
        int[][] directions = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} }; // N, S, W, E

        for (Entity entity : allEntities) {
            if (entity instanceof Minion) {
                Minion minion = (Minion) entity;
                // Check if the minion on the board belongs to the player playing the card
                if (minion.getOwner() == player) {
                    // Check adjacent tiles for a valid spawn point
                    for (int[] dir : directions) {
                        Tile potentialTile = board.getTile(minion.getX() + dir[0], minion.getY() + dir[1]);
                        if (potentialTile != null && !potentialTile.isOccupied()) {
                            return potentialTile; // Found a valid spot
                        }
                    }
                }
            }
        }
        return null; // No valid spot found
    }

    @Override
    public String toString() {
        return String.format("%s (%d Mana) - Summons %s (%d HP, %d ATK)",
                this.name, this.manaCost, this.minionName, this.minionHp, this.minionAtk);
    }
}