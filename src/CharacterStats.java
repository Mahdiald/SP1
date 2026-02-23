public class CharacterStats {
    int currentHealth;
    int maxHealth;
    int level;
    boolean isAlive;
    int xp;
    double gold;


    CharacterStats(int currentHealth, int maxHealth, int level, boolean isAlive, int xp, double gold) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.level = level;
        this.isAlive = isAlive;
        this.xp = xp;
        this.gold = gold;

    }

    CharacterStats(int currentHealth, int maxHealth, int level, boolean isAlive) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.level = level;
        this.isAlive = isAlive;

    }
}