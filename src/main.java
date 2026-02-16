import java.util.Scanner;

public class main {
    Scanner scan = new Scanner(System.in);

    int currentHealth = 100;
    int maxHealth = 100;
    int level = 5;
    int xp = 2300;
    double gold = 156.50;
    boolean isAlive = true;
    int enemyHealth = 90;
    String[] inventory = {"Dragon Sword", "Wooden Shield", "Leather Boots", "Healing potion"};


    void main() {
        String name = nameChoice();

        String CCchoice = classChoice();

        System.out.println(" ");

        playerStats(name, CCchoice);

        System.out.println(" ");

        showInventory();

        System.out.println(" ");

        System.out.println("==== COMBAT ====");
        System.out.println(" ");
        printUserCombatStats();
        printEnemyCombatStats();
        takenDamage(30, CCchoice);
        heal(25, name);
        System.out.println(" ");
        printUserCombatStats();
        inflectedDamage(50);



        System.out.println(" ");

        System.out.println("==== Status ====");
        if (isHealthCritical()) {
            System.out.println("FIND HEALING!");
        }

        if (!stillAlive()){
            return;
        }

        addXP(38);

        levelUp();

        addGold(435);

        if(removeGold(100)) {
            System.out.println("You bought a potion");
        }else{
            System.out.println("Buy attempt failed! Insufficient gold");
        }

        System.out.println("Health: " + getHealthPercentage() + "%");

        System.out.println(" ");

        playerStats(name, CCchoice);

    }



    String nameChoice(){
        System.out.println("Type character name");
        String name = scan.nextLine();
        return name;
    }

    String classChoice(){
        String[] chosenClass = {"W - Warrior", "M - Mage", "R - Rogue"};
        System.out.println("Please chose a class:");
        for (int i = 0; i < chosenClass.length; i++) {
            System.out.println(chosenClass[i]);
        }

        String choice = scan.nextLine();

        switch (choice.toUpperCase()) {
            case "W":
                return ("Warrior");
            case "M":
                return ("Mage");
            case "R":
                return ("Rogue");
            default:
                return ("Invalid choice");
        }

    }

    void takenDamage(int amount, String CCchoice) {
        currentHealth -= amount;
        System.out.println("Your " + CCchoice + " took " + amount + " damage");
        if (amount > 0){
            System.out.println("Damages: " + (currentHealth+amount) + " -> " + currentHealth);
            System.out.println("Health: " + currentHealth + "/" + maxHealth);
        }
    }

    void playerStats(String name, String CCchoice){
        System.out.println("==== Your stats ====");
        System.out.println("Name: " + name);
        System.out.println("class: You are a " + CCchoice);
        System.out.println("Level: " + level);
        System.out.println("Health: " + currentHealth + "/" +  maxHealth);
        System.out.println("XP: " + xp);
        System.out.println("gold: " + gold);
        System.out.println("alive: " + isAlive);
    }

    void showInventory(){
        System.out.println("==== Inventory ====");
        System.out.println((inventory.length) + " items");
        for (int i = 0; i < inventory.length; i++) {
            System.out.println( i+1+". " + inventory[i]);
        }

    }

    void heal(int amount, String name){
        currentHealth += amount;
        if (currentHealth > maxHealth){
            currentHealth = maxHealth;
        }
        System.out.println(name + " gained " + amount + " health!" );
        System.out.println("Health: " + currentHealth + "/" +  maxHealth);
    }

    double addGold(double amount){
        gold += amount;
        System.out.println("You gained " + amount + " gold!");
        return gold;

    }

    boolean removeGold(double amount){
        if (amount > gold){
            return false;
        }else{
            gold -= amount;
            return true;
        }
    }

    void addXP(int amount){
        xp += amount;
        if (xp > 1000){
            System.out.println("Ready to level up!");
        }
    }

    void levelUp(){
        while (xp > 1000){
            xp -= 1000;
            level++;
            maxHealth += 15;
        }
        System.out.println("You have leveled up! Your new level is: " + level);
    }

    boolean isHealthCritical(){
        if (currentHealth < ((maxHealth/100)*25) && currentHealth > 0){
            System.out.println("CRITICAL HEALTH!");
            return true;
        }else{

            return false;
        }
    }

    boolean stillAlive(){
        if (currentHealth > 0) {
            return true;
        }else{
            System.out.println("YOU DIED");
            return false;
        }
    }

    double getHealthPercentage(){
        double healthPercentage = (double) currentHealth /maxHealth *100;
        return healthPercentage;
    }

    void printUserCombatStats(){
        System.out.println("---- Your Stats ----");
        System.out.println("Level: " + level + "| Health: " + currentHealth + "/" + maxHealth + "| XP: " + xp);
        System.out.println(" ");
    }


    void printEnemyCombatStats(){
        System.out.println("---- Enemy Stats ----");
        System.out.println("Level: " + 4 + "| Health: " + enemyHealth + "/" + 90 + "| XP: " + 1000);
        System.out.println(" ");
    }

    void inflectedDamage(int amount){
        enemyHealth -= amount;
        if (enemyHealth <= 0){
            System.out.println("You killed the enemy. You win!");
        }else{
            System.out.println("You dealt " + amount + " damage!");
            printEnemyCombatStats();
        }
    }

}

