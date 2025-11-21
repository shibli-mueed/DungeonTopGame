import board.Board;
import board.Tile;
import cards.Card;
import cards.Deck;
import cards.SummonCard;
import entities.Entity;
import entities.Minion;
import entities.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int BOARD_WIDTH = 7;
    private static final int BOARD_HEIGHT = 7;

    private static String lastEvent = "The battle begins! Defeat the enemy's champion.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board(BOARD_WIDTH, BOARD_HEIGHT);

        Player player = new Player("Player", 3, 3);
        Player dungeonMaster = new Player("Dungeon Master", 3, 2);

        setupDecks(player, dungeonMaster);

        Minion playerChampion = new Minion("Hero", 25, 4, player);
        Minion dmChampion = new Minion("Boss", 25, 4, dungeonMaster);
        board.placeEntity(playerChampion, 3, 6);
        board.placeEntity(dmChampion, 3, 0);

        boolean gameRunning = true;
        Player currentPlayer = player;
        Player opponent = dungeonMaster;
        int turn = 1;

        player.startTurn(0);
        dungeonMaster.startTurn(0);

        while (gameRunning) {
            boolean turnEnded = handleTurn(scanner, board, currentPlayer, opponent);

            if (!playerChampion.isAlive()) {
                logEvent("The Hero has fallen!");
                printGameState(board, player, dungeonMaster, null);
                System.out.println("\n#####################################");
                System.out.println("###      DUNGEON MASTER WINS      ###");
                System.out.println("#####################################");
                gameRunning = false;
                continue;
            }
            if (!dmChampion.isAlive()) {
                logEvent("The Boss has been slain!");
                printGameState(board, player, dungeonMaster, null);
                System.out.println("\n#####################################");
                System.out.println("###          PLAYER WINS          ###");
                System.out.println("#####################################");
                gameRunning = false;
                continue;
            }

            if (turnEnded) {
                logEvent(opponent.getName() + " ends their turn.");
                Player temp = currentPlayer;
                currentPlayer = opponent;
                opponent = temp;
                turn++;
                currentPlayer.startTurn(turn);
                logEvent("--- Turn " + turn + ": " + currentPlayer.getName() + "'s Turn ---");
            }
        }
        scanner.close();
    }

    private static void logEvent(String message) {
        lastEvent = message;
    }

    private static boolean handleTurn(Scanner scanner, Board board, Player currentPlayer, Player opponent) {
        for (Entity entity : board.getAllEntities()) {
            if (entity instanceof Minion m && m.getOwner() == currentPlayer) {
                m.resetActionFlags();
            }
        }

        Minion selectedMinion = null;

        while (true) {
            printGameState(board, currentPlayer, opponent, selectedMinion);

            System.out.print("Action > ");
            String input = scanner.nextLine().toLowerCase();
            String command = input.split(" ")[0];

            if (command.equals("end")) return true;
            if (command.equals("help")) {
                printHelp();
                // Let the user read the help text, then press Enter to continue
                System.out.print("\nPress Enter to return to the game.");
                scanner.nextLine();
                continue;
            }

            String[] parts = input.split(" ");

            // Simplified move commands (w, a, s, d)
            if (parts.length == 1 && List.of("w", "a", "s", "d").contains(command)) {
                if (selectedMinion == null) {
                    logEvent("No minion selected. Use 's <x> <y>'.");
                } else {
                    handleMinionAction("move", command, selectedMinion, board);
                }
                continue;
            }

            // Simplified attack commands (aw, aa, as, ad)
            if (command.length() == 2 && command.startsWith("a") && List.of("w", "a", "s", "d").contains(command.substring(1))) {
                if (selectedMinion == null) {
                    logEvent("No minion selected. Use 's <x> <y>'.");
                } else {
                    handleMinionAction("attack", command.substring(1), selectedMinion, board);
                }
                continue;
            }

            try {
                switch (parts[0]) {
                    case "s" -> { // select
                        int x = Integer.parseInt(parts[1]);
                        int y = Integer.parseInt(parts[2]);
                        Tile tile = board.getTile(x, y);
                        if (tile != null && tile.isOccupied() && tile.getOccupant() instanceof Minion m) {
                            if (m.getOwner() == currentPlayer) {
                                selectedMinion = m;
                                logEvent("Selected " + m.getName() + " at (" + x + "," + y + ").");
                            } else {
                                logEvent("You can only select your own minions.");
                            }
                        } else {
                            logEvent("No selectable minion at that location.");
                        }
                    }
                    case "p" -> { // play
                        int cardIndex = Integer.parseInt(parts[1]);
                        // We get the card first to log its name
                        if (cardIndex >= 0 && cardIndex < currentPlayer.getHand().size()) {
                            Card cardToPlay = currentPlayer.getHand().get(cardIndex);
                            logEvent(currentPlayer.getName() + " plays " + cardToPlay.getName() + ".");
                            currentPlayer.playCard(cardIndex, board);
                        } else {
                            logEvent("Invalid card index.");
                        }
                    }
                    default -> logEvent("Unknown command. Type 'help' for a list of commands.");
                }
            } catch (Exception e) {
                logEvent("Invalid command format. Type 'help' for a list of commands.");
            }
        }
    }

    private static void handleMinionAction(String command, String direction, Minion minion, Board board) {
        int targetX = minion.getX();
        int targetY = minion.getY();

        switch (direction) {
            case "w" -> targetY--;
            case "s" -> targetY++;
            case "a" -> targetX--;
            case "d" -> targetX++;
            default -> { return; }
        }

        Tile targetTile = board.getTile(targetX, targetY);
        if (targetTile == null) {
            logEvent(minion.getName() + " can't move off the board!");
            return;
        }

        if (command.equals("move")) {
            if (minion.hasMovedThisTurn()) {
                logEvent(minion.getName() + " has already moved this turn.");
                return;
            }
            if (targetTile.isOccupied()) {
                logEvent("Tile (" + targetX + "," + targetY + ") is blocked!");
            } else {
                String oldPos = "(" + minion.getX() + "," + minion.getY() + ")";
                board.moveEntity(minion, targetX, targetY);
                minion.setHasMovedThisTurn(true);
                logEvent(minion.getName() + " moved from " + oldPos + " to (" + targetX + "," + targetY + ").");
            }
        } else if (command.equals("attack")) {
            if (minion.hasAttackedThisTurn()) {
                logEvent(minion.getName() + " has already attacked this turn.");
                return;
            }
            if (targetTile.isOccupied() && targetTile.getOccupant() instanceof Minion target) {
                if (target.getOwner() != minion.getOwner()) {
                    minion.setHasAttackedThisTurn(true);
                    int initialHp = target.getHealth();
                    minion.attack(target);
                    int damageDealt = initialHp - target.getHealth();
                    logEvent(minion.getName() + " attacks " + target.getName() + " for " + damageDealt + " damage!");

                    if (!target.isAlive()) {
                        logEvent(target.getName() + " has been defeated!");
                        board.removeEntity(target);
                    }
                } else {
                    logEvent("You cannot attack your own minion!");
                }
            } else {
                logEvent("No target to attack at that location.");
            }
        }
    }

    private static void printGameState(Board board, Player player, Player dm, Minion selected) {
        // Clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("============== DUNGEON TOP ==============");
        System.out.printf("DM: Mana %d/%d | Deck: %d | Discard: %d\n", dm.getMana(), dm.getMaxMana(), dm.getDeckSize(), dm.getDiscardSize());
        System.out.println("-----------------------------------------");
        board.printBoard();
        System.out.println("-----------------------------------------");
        System.out.printf("Player: Mana %d/%d | Deck: %d | Discard: %d\n", player.getMana(), player.getMaxMana(), player.getDeckSize(), player.getDiscardSize());

        // Event Log
        System.out.println("\n--- Last Event ---");
        System.out.println("  " + lastEvent);

        // Player Hand & Selection
        System.out.println("\n--- Your Hand ---");
        List<Card> hand = player.getHand();
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(i + ": " + hand.get(i).toString());
        }
        if (selected != null) {
            System.out.printf("\n-- Selected: %s (HP: %d, ATK: %d) at (%d,%d) | Moved: %b | Attacked: %b --\n",
                    selected.getName(), selected.getHealth(), selected.getAttack(), selected.getX(), selected.getY(),
                    selected.hasMovedThisTurn(), selected.hasAttackedThisTurn());
        }
        System.out.println("=========================================");
    }

    private static void setupDecks(Player player, Player dungeonMaster) {
        Deck playerDeck = new Deck();
        playerDeck.addCard(new SummonCard("Squire", 1, "Squire", 5, 2));
        playerDeck.addCard(new SummonCard("Squire", 1, "Squire", 5, 2));
        playerDeck.addCard(new SummonCard("Archer", 2, "Archer", 4, 3));
        playerDeck.addCard(new SummonCard("Knight", 3, "Knight", 10, 4));
        player.setDeck(playerDeck);

        Deck dmDeck = new Deck();
        dmDeck.addCard(new SummonCard("Goblin", 1, "Goblin", 4, 2));
        dmDeck.addCard(new SummonCard("Goblin", 1, "Goblin", 4, 2));
        dmDeck.addCard(new SummonCard("Orc", 2, "Orc", 8, 3));
        dmDeck.addCard(new SummonCard("Troll", 4, "Troll", 12, 5));
        dungeonMaster.setDeck(dmDeck);
    }

    private static void printHelp() {
        System.out.println("\n--- Help ---");
        System.out.println("s <x> <y>      - Select a minion.");
        System.out.println("w, a, s, d     - Move selected minion.");
        System.out.println("aw, aa, as, ad - Attack with selected minion.");
        System.out.println("p <index>      - Play a card from your hand.");
        System.out.println("end            - End your current turn.");
        System.out.println("--------------");
    }
}