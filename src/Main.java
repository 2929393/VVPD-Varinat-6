import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menuKey;
        do {
            System.out.println("Выберите систему вводимого счисления: 2, 8, 10, 16");
            int numberSystem = getNumberSystem(input);
            menuKey = getValue(input);
        }
        while (menuKey != 0);
    }

    public static int getValue(Scanner input) {
        String result;
        while (!isCorrectValue(result = input.nextLine())) {
            System.out.println("Введите число");
        }
        return Integer.parseInt(result);
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

    public static int getNumberSystem(Scanner input) {
        int result;
        while (!isNumberSystem(result = getValue(input))) {
            System.out.println("Введите систему счисления");
        }
        return result;
    }

    public static boolean isNumberSystem(int value) {
        int[] numberSystems = new int[] {2, 8, 10, 16};
        for (int numberSystem : numberSystems) {
            if (value == numberSystem)
                return true;
        }
        return false;
    }
}