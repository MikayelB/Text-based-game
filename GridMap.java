import java.util.Scanner;

public class GridMap extends Map {
    private int gridRows;
    private int gridColumns;
    private int[] obstacleMap;

    private final static int FREE = 0;
    private final static int OBSTACLE = 1;
    private final static int SHOP = 2;


    public GridMap() throws Exception {
        String configuration = Utility.readFile("configuration");
        initializeAndValidateObstacleMap(configuration);

    }

    private void initializeAndValidateObstacleMap(String configuration) throws ConfigurationFormatException, InvalidConfigurationException {
        String[] configArray = configuration.split(":");
        String[] dimensions = configArray[0].split(" ");

        gridRows = Integer.parseInt(dimensions[0]);
        gridColumns = Integer.parseInt(dimensions[1]);

        obstacleMap = new int[gridRows * gridColumns];

        for (int i = 1; i < configArray.length; i++) {
            String[] locationValues = configArray[i].split(" ");
            if (locationValues.length != gridColumns) {
                throw new ConfigurationFormatException("Wrong number of columns!");
            }
            for (int j = 0; j < locationValues.length; j++) {
                int value = Integer.parseInt(locationValues[j]);
                if (value == FREE || value == OBSTACLE || value == SHOP) {
                    obstacleMap[j + (i -1) * gridColumns] = value;
                } else {
                    throw new InvalidConfigurationException("Incorrect Value!");
                }
            }
        }
        System.out.println();
    }

    public GridMap(int gridRows, int gridColumns, int[] obstacleMap) {
        this.gridRows = gridRows;
        this.gridColumns = gridColumns;
        this.obstacleMap = obstacleMap;
    }

    @Override
    public void move() {
        Scanner scanner = new Scanner(System.in);
        int selection = 1;
        System.out.println("1) North, 2) East, 3) South, 4) West: ");
        selection = scanner.nextInt();

        switch (selection) {
            case 1: // North
                if (!checkForBoundariesAndObstacles(0, -1)) {
                    playerYPos--; // adjusted to the positive array direction
                }
                break;
            case 2: // East
                if (!checkForBoundariesAndObstacles(1, 0)) {
                    playerXPos++;
                }
                break;
            case 3: // South
                if (!checkForBoundariesAndObstacles(0, 1)) {
                    playerYPos++; // adjusted to the positive array direction
                }
                break;
            default: // West
                if (!checkForBoundariesAndObstacles(-1, 0)) {
                    playerXPos--;
                }
                break;
        }
    }
    
    public boolean checkForShops(){

        int newXPos = playerXPos;
        int newYPos = playerYPos;
        int position = newXPos + newYPos * gridColumns;
        if (obstacleMap[position] == 2) {
            System.out.println("You reached a shop! ");
            System.out.println();
            return true;
        } return false;
    }

    private boolean checkForBoundariesAndObstacles(int x, int y) {
        int newXPos = x + playerXPos;
        int newYPos = y + playerYPos;
        int position = newXPos + newYPos * gridColumns;
        if (newXPos > gridColumns - 1 || newXPos < 0
                || newYPos > gridRows - 1 || newYPos < 0) {
            System.out.println("You have reached a boundary!");
            System.out.println();
            return true;
        } else if (obstacleMap[position] == 1) {
            System.out.println("An obstacle is ahead! you can't move to this location.");
            System.out.println();
            return true;
        /* } else if (obstacleMap[position] == 2) {
            System.out.println("You have a shop ahead! ");
            System.out.println();
            return true; */
        } return false;
    }

}
