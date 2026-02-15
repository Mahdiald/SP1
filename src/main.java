import java.util.Scanner;

public class main {
    Scanner scan = new Scanner(System.in);

    void main() {
        System.out.println("Type character name");
        String name = scan.nextLine();
        System.out.println("You are " + name);

        String[] chosenClass = {"W - Warrior", "M - Mage", "R - Rogue"};
        System.out.println("Please chose a class:");
        for (int i = 0; i < chosenClass.length; i++) {
            System.out.println(chosenClass[i]);
        }


        String choice = classChoice();


        int currentHealth = 85;
        int maxHealth = 100;
        int level = 5;
        int xp = 2300;
        double gold = 156.50;
        boolean alive = true;
        String[] inventory = {"Dragon Sword", "Wooden Shield", "Leather Boots", "Healing potion"};

        System.out.println("==== Your stats ====");
        System.out.println("Name: " + name);
        System.out.println("class: " + choice);
        System.out.println("Level: " + level);
        System.out.println("Health: " + currentHealth + "/" +  maxHealth);
        System.out.println("XP: " + xp);
        System.out.println("gold: " + gold);
        System.out.println("alive: " + alive);

        System.out.println("==== Inventory ====");
        for (int i = 0; i < inventory.length; i++) {
            System.out.println( i+1+". " + inventory[i]);
        }


    }

    String classChoice(){
        String choice = scan.nextLine();

        switch (choice.toUpperCase()) {
            case "W":
                return ("You are a Warrior");
            case "M":
                return ("You are a Mage");
            case "R":
                return ("You are a Rogue");
            default:
                return ("Invalid choice");
        }

    }
}

