import java.util.Scanner;

public class main {
    Scanner scan = new Scanner(System.in);

    CharacterStats user1 = new CharacterStats(100, 100, 5, true, 2300, 156.50);
    CharacterStats enemy1 = new CharacterStats(90, 90, 3, true);

    String[] inventory = {"Dragon Sword", "Wooden Shield", "Leather Boots", "Healing potion"};

    String name = nameChoice();
    String CCchoice = classChoice();

    void main() {


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
        inflectedDamage(45);



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
        user1.currentHealth -= amount;
        System.out.println("Your " + CCchoice + " took " + amount + " damage");
        if (amount > 0){
            System.out.println("Damages: " + (user1.currentHealth+amount) + " -> " + user1.currentHealth);
            System.out.println("Health: " + user1.currentHealth + "/" + user1.maxHealth);
        }
    }

    void playerStats(String name, String CCchoice){
        System.out.println("==== Your stats ====");
        System.out.println("Name: " + name);
        System.out.println("class: You are a " + CCchoice);
        System.out.println("Level: " + user1.level);
        System.out.println("Health: " + user1.currentHealth + "/" +  user1.maxHealth);
        System.out.println("XP: " + user1.xp);
        System.out.println("gold: " + user1.gold);
        System.out.println("alive: " + user1.isAlive);
    }

    void showInventory(){
        System.out.println("==== Inventory ====");
        System.out.println((inventory.length) + " items");
        for (int i = 0; i < inventory.length; i++) {
            System.out.println( i+1+". " + inventory[i]);
        }

    }

    void heal(int amount, String name){
        user1.currentHealth += amount;
        if (user1.currentHealth > user1.maxHealth){
            user1.currentHealth = user1.maxHealth;
        }
        System.out.println(name + " gained " + amount + " health!" );
        System.out.println("Health: " + user1.currentHealth + "/" +  user1.maxHealth);
    }

    double addGold(double amount){
        user1.gold += amount;
        System.out.println("You gained " + amount + " gold!");
        return user1.gold;

    }

    boolean removeGold(double amount){
        if (amount > user1.gold){
            return false;
        }else{
            user1.gold -= amount;
            return true;
        }
    }

    void addXP(int amount){
        user1.xp += amount;
        if (user1.xp > 1000){
            System.out.println("Ready to level up!");
        }
    }

    void levelUp(){
        while (user1.xp > 1000){
            user1.xp -= 1000;
            user1.level++;
            user1.maxHealth += 15;
        }
        System.out.println("You have leveled up! Your new level is: " + user1.level);
    }

    boolean isHealthCritical(){
        if (user1.currentHealth < ((user1.maxHealth/100)*25) && user1.currentHealth > 0){
            System.out.println("CRITICAL HEALTH!");
            return true;
        }else{

            return false;
        }
    }

    boolean stillAlive(){
        if (user1.currentHealth > 0) {
            return true;
        }else{
            System.out.println("YOU DIED");
            return false;
        }
    }

    double getHealthPercentage(){
        double healthPercentage = (double) user1.currentHealth /user1.maxHealth *100;
        return healthPercentage;
    }

    void printUserCombatStats(){
        System.out.println("---- Your Stats ----");
        System.out.println("Level: " + user1.level + "| Health: " + user1.currentHealth + "/" + user1.maxHealth + "| XP: " + user1.xp);
        System.out.println(" ");
    }

    void printEnemyCombatStats(){
        System.out.println("---- Enemy Stats ----");
        System.out.println("Level: " + enemy1.level + "| Health: " + enemy1.currentHealth + "/" + enemy1.maxHealth);
        System.out.println(" ");
    }

    void inflectedDamage(int amount){

        while (enemy1.isAlive == true){
            enemy1.currentHealth -= amount;
            if (enemy1.currentHealth <= 0) {
                enemy1.isAlive = false;
            }
            System.out.println("You dealt " + amount + " damage!");
            System.out.println(" ");
            if (enemy1.currentHealth < 0){
                enemy1.currentHealth=0;
            }
            printEnemyCombatStats();
            takenDamage(50, CCchoice);
            heal(25, name);
        }
        System.out.println("You killed the enemy. You win!");
    }

}

