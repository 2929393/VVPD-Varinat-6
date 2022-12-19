import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    public static String getValue(Scanner input) {
        String result;
        while (!isCorrectValue(result = input.nextLine())) {
            System.out.println("Введите число");
        }
        return result;
    }

    public static boolean isCorrectValue(String line) {
        try {
            Integer.parseInt(line);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}