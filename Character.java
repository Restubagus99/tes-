abstract class Character {
    protected String name;
    protected int health;
    protected int attack;

    public Character(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public abstract void showCharacter();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void receiveDamage(int damage) {
        health -= damage;
        if (health < 0)
            health = 0;
    }

    public boolean isDead() {
        return health <= 0;
    }
}