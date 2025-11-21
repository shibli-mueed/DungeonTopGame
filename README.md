# DungeonTopGame

## Table of Contents
- [How to Play in console](#how-to-play-in-console)
- [Project Structure](#project-structure)
- [How to Open and Run the Project](#how-to-open-and-run-the-project)
    - [Prerequisites](#prerequisites)
    - [Opening in IntelliJ IDEA (Recommended)](#opening-in-intellij-idea-recommended)
    - [Running from the Command Line](#running-from-the-command-line)
- [Collaboration using Git & GitHub](#collaboration-using-git--github)
    - [Step 1: Get the Project from GitHub (Clone)](#step-1-get-the-project-from-github-clone)
    - [Step 2: Stay Up-to-Date (Pull)](#step-2-stay-up-to-date-pull)
    - [Step 3: Make Your Own Changes (The Workflow)](#step-3-make-your-own-changes-the-workflow)
    - [Step 4: Merge Your Changes (Create a Pull Request)](#step-4-merge-your-changes-create-a-pull-request)
- [Project Progress Checklist](#project-progress-checklist)
    - [Implemented Features](#implemented-features)
    - [To-Do List](#to-do-list)

## How to Play in console

- Use the commands `s <x> <y>` to select one of your minions (e.g., `s 3 6`).
- Once a minion is selected, use `w`, `a`, `s`, `d` to move it.
- Use `aw`, `aa`, `as`, `ad` to attack with the selected minion in a direction.
- Use `p <index>` to play a card from your hand.
- Type `end` to finish your turn.
- Type `help` to see the command list in-game.

---

## Project Structure

The project is organized into the following packages:

- `board`: Contains the `Board` and `Tile` classes, which represent the game board.
- `cards`: Contains classes for the card system, including the abstract `Card` and concrete `SummonCard`.
- `entities`: Contains the `Entity`, `Player`, and `Minion` classes.
- `docs`: Contains Markdown documentation for the project.

The main entry point of the game is the `Main.java` file, which contains the core game engine and UI rendering.

## How to Open and Run the Project

This project is a standard Java project without any external dependencies. You can open it in any Java IDE or run it from the command line.

### Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) version 11 or higher.

### Opening in IntelliJ IDEA (Recommended)

IntelliJ IDEA is a popular Integrated Development Environment (IDE) for Java development.

1.  **Open IntelliJ IDEA.**
2.  Click on **File** -> **Open...**.
3.  Navigate to the directory where you cloned or downloaded this project and select the `DungeonTopGame` folder.
4.  IntelliJ IDEA will automatically detect the project structure.
5.  Locate the `Main.java` file in the `src` directory.
6.  Right-click on the `Main.java` file and select **Run 'Main.main()'**.

The game will start running in the console at the bottom of the IDE.

### Running from the Command Line

You can also run the game from the command line on any operating system that has the JDK installed.

#### On Windows

1.  Open the **Command Prompt** or **PowerShell**.
2.  Navigate to the project's root directory:
    ```bash
    cd path\to\DungeonTopGame
    ```
3.  Compile all Java files from the `src` directory into the `out` directory:
    ```bash
    javac -d out src\*.java src\board\*.java src\cards\*.java src\entities\*.java
    ```
4.  Run the game:
    ```bash
    java -cp out Main
    ```

#### On macOS and Linux

1.  Open the **Terminal**.
2.  Navigate to the project's root directory:
    ```bash
    cd path/to/DungeonTopGame
    ```
3.  Compile all Java files from the `src` directory into the `out` directory:
    ```bash
    javac -d out src/*.java src/board/*.java src/cards/*.java src/entities/*.java
    ```
4.  Run the game:
    ```bash
    java -cp out Main
    ```

---

## Collaboration using Git & GitHub

This guide explains how to work on this project together using Git and GitHub. Think of Git as a "save" button for your code that keeps track of all history, and GitHub as the website where we all share our saved versions.

### Step 1: Get the Project from GitHub (Clone)

This is the first thing you do to get the project on your computer. You only need to do this once.

1.  Open your terminal or command prompt.
2.  Navigate to the folder where you want to store the project (e.g., `cd Documents/Projects`).
3.  Run the following command to copy the project from GitHub to your computer:

    ```bash
    git clone [https://github.com/shibli-mueed/DungeonTopGame.git](https://github.com/shibli-mueed/DungeonTopGame.git)
    ```

This will create a `DungeonTopGame` folder. You can now open this folder in your IDE.

### Step 2: Stay Up-to-Date (Pull)

Before you start working, you should always get the latest changes from the main version on GitHub.

1.  Make sure you are on the `main` branch (our main version):
    ```bash
    git checkout main
    ```
2.  Download the latest changes:
    ```bash
    git pull origin main
    ```

### Step 3: Make Your Own Changes (The Workflow)

To avoid breaking the main version of the code, you should always make your changes in a separate **branch**. A branch is your personal copy of the project where you can work safely.

**A. Create Your Branch**

-   Choose a short, descriptive name for your branch that describes what you are working on (e.g., `add-healing-cards`, `fix-combat-bug`).
-   Create and switch to your new branch with this command:

    ```bash
    # Example: git checkout -b add-healing-cards
    git checkout -b your-new-branch-name
    ```

**B. Write Your Code**

-   Now you can work on the code in your IDE as you normally would. Add new features or fix bugs in your branch.

**C. Save Your Work to Git (Commit)**

-   Once you've made some progress, you need to save a snapshot of your changes. This is a two-step process.
-   **First, add the files** you want to save. The easiest way is to add all changed files:
    ```bash
    git add .
    ```
-   **Second, commit the files** with a message describing what you did. This creates a permanent save point.
    ```bash
    # Example: git commit -m "Add Heal and Damage spell cards"
    git commit -m "A short, clear message about your changes"
    ```

**D. Send Your Branch to GitHub (Push)**

-   Now, share your branch and your commits with the team by "pushing" it to GitHub.
-   **Important:** The first time you push a new branch, you need to use this command:

    ```bash
    # Example: git push -u origin add-healing-cards
    git push -u origin your-new-branch-name
    ```
-   After the first time, you can just use `git push` to send up new commits you make in that branch.

### Step 4: Merge Your Changes (Create a Pull Request)

-   Once you are finished working on your feature and have pushed your branch, go to the project's GitHub page: [https://github.com/shibli-mueed/DungeonTopGame](https://github.com/shibli-mueed/DungeonTopGame)
-   You should see a green button to **"Compare & pull request"** for your new branch. Click it.
-   Give your Pull Request (PR) a title and a short description of what you did.
-   Click **"Create pull request"**.

This tells the project leader that your work is ready to be reviewed and added to the main `main` branch.

---

## Project Progress Checklist

This list outlines the features required by the project description and tracks their implementation status.

### Implemented Features

-   [x] **Player vs. Dungeon Master:** The game supports two alternating controllers, one for the Player and one for the DM.
-   [x] **Turn-Based System:** The game operates on a strict turn-based loop with no AI.
-   [x] **2D Map:** A rectangular, indexed game board is used as the playing field.
-   [x] **Card & Deck System:** Players have decks, draw cards into a hand, and play them. The deck is reshuffled from the discard pile when empty.
-   [x] **Mana System:** Cards have a mana cost, and players have a mana pool that is spent to play cards. The maximum mana grows each turn.
-   [x] **Minion System:** Minions can be summoned to the board, have HP and Attack stats, and belong to a specific controller.
-   [x] **Minion Spawning:** Minions must be summoned adjacent to another friendly minion.
-   [x] **Action Economy:** Minions can move once and attack once per turn.
-   [x] **Basic Combat:** Minions can attack adjacent enemies. Damage is calculated based on the attacker's power.
-   [x] **Core Win Condition:** The game ends when one controller's "Champion" minion is defeated.
-   [x] **Console UI:** The game features a structured console interface that clears and redraws the screen, including an event log and on-board HP display.

### To-Do List

This list is ordered chronologically to guide future development.

#### 1. Refine Core Mechanics

-   [ ] **Implement Defense Stat:** Add a `defense` stat to minions and update the damage formula to `Damage = Attacker's Attack - Defender's Defense`.
-   [ ] **Summoning Sickness:** Implement a rule preventing minions from moving or attacking on the same turn they are summoned.
-   [ ] **Variable Movement:** Give minions a `movementRange` stat and allow them to move multiple tiles in one action.

#### 2. Expand Content & Features

-   [ ] **Character Classes:** Implement at least 3 selectable character classes that determine starting stats and/or decks.
-   [ ] **"Effect" Cards:** Create new card types that produce effects other than summoning (e.g., deal direct damage, heal a unit, draw cards).
-   [ ] **Ranged & Special Attacks:** Implement minions or weapons that can attack from a distance or affect multiple tiles.
-   [ ] **Map Variety:** Add options for small, medium, and large map sizes at the start of the game.

#### 3. Implement Dungeon Structure

-   [ ] **Conceptual Divergence Note:** The project specification requires a win condition based on the Player's own HP and a 7-level dungeon. The current implementation uses a single-battle "Champion" defeat model. A decision must be made: either adapt the current model to a multi-stage battle system or refactor to align with the spec (give the Player a direct HP value and remove the Hero minion). The following steps assume we will move towards the specification.
-   [ ] **Dungeon Levels:** Design a system for a 7-level dungeon.
-   [ ] **Rooms & Events:** Implement a system for the player to move between "rooms" in a level. Create different room types:
    -   Standard monster fights.
    -   "Event" rooms (e.g., Merchant, Fountain of Healing, Treasure Chest).
    -   A "Boss" room guarding the exit to the next level.

#### 4. Add Progression Systems

-   [ ] **In-Run Progression (XP & Loot):**
    -   Add an experience point (XP) system for the Player.
    -   After a successful fight, provide rewards like Gold and a choice of new cards or items.
-   [ ] **Meta-Progression (Persistent Gold):**
    -   Implement a system where Gold is retained after a lost run.
    -   Create a pre-run menu where this Gold can be spent on permanent upgrades (e.g., improving cards, unlocking new classes or talents).

#### 5. Finalize and Polish

-   [ ] **Difficulty Scaling:** Ensure monsters and bosses in higher dungeon levels have appropriately increased stats.
-   [ ] **Balance:** Fine-tune all values (card costs, minion stats, rewards) to ensure the game is challenging but fair.