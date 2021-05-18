import java.util.Scanner;

public class GameDemo {
    public static void main(String[] args) {
     /*   int[] obstacleMap = {
                0, 0, 0,
                1, 0, 1,
                0, 0, 0
        };
        GridMap gameMap = new GridMap(3, 3, obstacleMap);*/
        GridMap gameMap = null;
        try {
            gameMap = new GridMap();
        } catch (Exception e) {
            System.out.println("Couldn't initialize the Grid Map!");
            System.out.println(e.getMessage());
            System.exit(0);
        }

      /*  Player mainPlayer = new Player("Bob", 40, 10,
                0, new Weapon("Sword", 5, 20), 1, 20, 1000, 5);*/

        Player mainPlayer = new Player("Bob", 40, 10,
                0, new Bomb("Bomb", 5, 20, 2), 1, 20,
                1000, 5/* , Inventory in(4) */);

        Scanner input = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            gameMap.printPlayerPos();
            int selection = 1;
            System.out.println("1) Move, 2) Rest, 3) View Stats, 4) Quit: ");
            selection = input.nextInt();
            Character[] enemies = null;
            switch (selection) {
                case 1:
                    gameMap.move();

                    if(gameMap.checkForShops() == true){

                        WeaponTrader newShop = new WeaponTrader(new Inventory(4));

 
                        System.out.println("1) Buy a weapon  2) Sell your weapon  3) List all items  4) Quit the shop");
                        int num = input.nextInt();

                        if(num == 1){
                            System.out.println("Choose a weapon and type its #: ");
                            int num1 = input.nextInt(); 
                            mainPlayer.buyFrom(newShop, num1);
                            newShop.inventory.removeItem(num1);
                        }
                        if(num == 2){
                            mainPlayer.sellTo(newShop);
                        }
                        if(num == 3){
                          newShop.listAllItems();
                        }

                    }

                    enemies = gameMap.checkForEnemies();

                    if (enemies != null) {
                        while (true) {
                            mainPlayer.displayHealth();
                            printEnemiesHealth(enemies);

                            boolean runAway = mainPlayer.attack(enemies);
                            if (runAway) break;

                            boolean allDead = handleDeadEnemies(mainPlayer, enemies);
                            if (allDead) break;

                            done = handleEnemiesAttack(mainPlayer, enemies);
                            if (done) break;
                        }
                    }
                    break;
                case 2:
                    mainPlayer.rest();
                    break;
                case 3:
                    mainPlayer.viewStats();
                    break;
                case 4:
                    done = true;
                    break;
            }
        }
    }

    private static boolean handleDeadEnemies(Player mainPlayer, Character[] enemies) {
        int totalExperienceReward = 0;
        boolean allDead = true;
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] != null) {
                if (enemies[i].isDead()) {
                    totalExperienceReward += ((Enemy) enemies[i]).getExperienceReward();
                }else{
                    allDead = false;
                }
            }
        }
        if(allDead) {
            mainPlayer.win(totalExperienceReward);
            mainPlayer.levelUp();
        }
        return allDead;
    }

    private static boolean handleEnemiesAttack(Player mainPlayer, Character[] enemies) {
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] != null  && !enemies[i].isDead()) {
                enemies[i].attack(mainPlayer);
                if (mainPlayer.isDead()) {
                    mainPlayer.gameOver();
                    return true;
                }
            }
        }
        return false;
    }

    private static void printEnemiesHealth(Character[] enemies) {
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] != null && !enemies[i].isDead())
                enemies[i].displayHealth();
        }
    }
}
