public class CharacterStats {
    int currentHealth;
    int maxHealth;
    int level;

    boolean isAlive;

    CharacterStats(int currentHealth, int maxHealth, int level, boolean isAlive ){
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.level = level;
        this.isAlive = isAlive;

    }
}
