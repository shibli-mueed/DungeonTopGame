The following task is given to us as a group project.

### Task Description

You are to implement the mechanics of the game [Dungeon Top](https://www.google.com/search?q=https://dungeontop.com/) according to the requirements listed below. In doing so, you should be creative and improve parts of the game mechanics or adapt them to my requirements.

- **Player** plays against **Dungeon Master** on the same PC. **Player** wins the game if they defeat seven bosses from seven levels. **Dungeon Master** wins as soon as the **Player's** Health Points are less than or equal to zero. Come up with mechanics that keep the game balanced.

- **Player** has a Level, a value for how many cards can be drawn per turn in combat, a value for Mana, an Attack value, and the number of Health Points. **Player** can possess one weapon and up to two artifacts. Weapons and artifacts change the **Player's** stats. Additionally, **Player** can possess Talents that influence the values of the **Player** or Minions, or achieve other effects. Design the **Dungeon Master** according to your ideas, but pay attention to a functioning balance.

- The game is turn-based. **No** AI is to be implemented.

- It is played on a rectangular 2D map, which is available in small, medium, and large sizes.

- **Player** and **Dungeon Master** play cards to achieve effects or generate Minions on the map.

- Minions possess a value for Health Points and an Attack value. Minions can only be generated adjacent to the **Player**/**Dungeon Master** or own Minions. The fields North, South, West, and East count as adjacent.

- Every card has a value for the amount of Mana deducted from the **Player** or **Dungeon Master** when playing the card.

- **Player**, **Dungeon Master**, and Minions can be moved in a turn. Movement directions are North, South, West, and East. The number of fields a game figure can be moved per turn is determined by a value. Note that spawned Minions can only move in the next turn unless they have the ability to act immediately after spawning.

- **Player**, **Dungeon Master**, and Minions can attack opposing figures if they are adjacent to that figure. In this process, Health Points are deducted from the attacked game figure (Attacker's Attack Value – Defender's Defense Value). If the Health Points of the attacked figure sink to zero, it disappears from the playing field. The effects caused by this figure also expire. Note that some weapons, like bows, allow an attack beyond multiple fields. There should be Minions that can cast attacks over multiple fields and/or hit opponents on multiple fields.

- At the beginning of a game, the playing persons choose a character class. At least 3 different classes are to be implemented. The choice of the class determines the starting stats and the deck of **Player** and **Dungeon Master**.

- A deck consists of cards that achieve effects or generate Minions.

- **Player** starts in the first of seven levels of a dungeon. Represent levels suitably for the console. **Player** should be able to go from room to room within a level. In a room, the **Player** awaits fights against monsters (controlled by **Dungeon Master**), Events (Merchant, Upgrades, Healing, Treasure finds, etc.), or the stairs down to the next level. This staircase is guarded by the Level Boss. You have a free hand with the representation of the level and do not have to stick to the Dungeon Top template.

- Remember that **Player** can improve values and the deck during the course of the game. You can solve this via Experience Points. There should also be Gold, new cards, Weapons, or Talents after every successful fight. Gold should be retained in the event of an unsuccessful run. With this Gold, **Player** can improve their stats, cards, Talents, and weapons before the start of a new run.

- The monsters in the higher levels should always have better stats. Ensure that the game mechanics are exciting. You can also insert new mechanics that do not exist in Dungeon Top. In Dungeon Top, there is an AI. You are letting two humans play against each other, so pay attention to many possibilities to alter the balance.
