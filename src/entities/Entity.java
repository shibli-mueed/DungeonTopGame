package entities;

public abstract class Entity {
    // Protected means: "Only me and my children (subclasses) can touch this"
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attack;
    protected int x, y;

    public Entity(String name, int maxHealth, int attack) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth; // Start with full HP
        this.attack = attack;
    }

    // Abstract method: Children MUST define how they look
    public abstract String getSymbol();

    public int getX() { return x; }
    public int getY() { return y; }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // We will use this later for combat
    public String getName() { return name; }

    public int getAttack(){return attack;}
    public void attack(Entity target) {
        target.takeDamage(this.attack);
    }

    public void takeDamage(int amount) {
        this.health -= amount;
        if (this.health < 0) this.health = 0;
    }

    public boolean isAlive() {
        return this.health > 0;
    }


    public int getHealth() {
        return health;
    }
}