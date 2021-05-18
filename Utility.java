import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Utility {

    public static int random(Range r) {
        Random random = new Random();
        return random.nextInt((r.getHigh() - r.getLow()) + 1) + r.getLow();
    }

    public static int random(int low, int high) {
        Random random = new Random();
        return random.nextInt((high - low) + 1) + low;
    }

    public static String readFile(String fileName) {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(fileName + ".txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File configuration.txt was not found");
            System.exit(0);
        }
        String configuration = inputStream.nextLine();
        return configuration;
    }
}
