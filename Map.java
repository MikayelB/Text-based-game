import java.util.Scanner;

public class Map {

    protected int playerXPos;
    protected int playerYPos;

    public Map() {
        playerXPos = 0;
        playerYPos = 0;
    }

    public void move() {
        Scanner scanner = new Scanner(System.in);
        int selection = 1;
        System.out.println("1) North, 2) East, 3) South, 4) West: ");
        selection = scanner.nextInt();

        switch (selection) {
            case 1: // North
                playerYPos++;
                break;
            case 2: // East
                playerXPos++;
                break;
            case 3: // South
                playerYPos--;
                break;
            default: // West
                playerXPos--;
                break;
        }
    }

    public void printPlayerPos() {
        System.out.println("Player Position = (" + playerXPos + ", "
                + playerYPos + ")");
    }

    public Character[] checkForEnemies() {
        int roll = Utility.random(0, 20);
        Enemy enemy = null;

        if (roll <= 10) {
            Weapon weapon = new Weapon("dagger", 5, 10);
            Shield shield = new Shield("Wooden", 5);
            enemy = new Enemy("Zombie", 10, 4, 200, weapon, shield);
            System.out.println("You encountered a Zombie!");
            System.out.println("Prepare for battle!");
        } else if (roll >= 11 && roll <= 15) {
            Weapon weapon = new Weapon("dagger", 5, 10);
            Shield shield = new Shield("Iron", 5);
            enemy = new Enemy("Dark soul", 10, 3, 200, weapon, shield);
            System.out.println("You encountered a Dark soul!");
            System.out.println("Prepare for battle!");
        }

        Character[] enemies = null;
        if(enemy != null) {
            enemies = new Character[4];
            int multipleEncounterChance = Utility.random(0, 100);
            if (multipleEncounterChance <= 100) {
                int numberOfCopies = Utility.random(2, 4);
                for (int i = 0; i < numberOfCopies; i++) {
                    Enemy newEnemy = new Enemy(enemy);
                    enemies[i] = newEnemy;
                }
            } else {
                enemies[0] = enemy;
            }
        }

        return enemies;
    }

}
