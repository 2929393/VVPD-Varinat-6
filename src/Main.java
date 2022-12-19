import java.util.Scanner;

public class Main {

    static Number value;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        createNumber(input);
        int menuKey;
        do {
            System.out.println(value);
            System.out.println("1 - Ввод нового числа");
            System.out.println("2 - Перевод числа из 2-ной в 10-ную систему");
            System.out.println("3 - Перевод числа из 10-ной в 2-ную систему");
            System.out.println("4 - Перевод числа из 2-ной в 8-ную систему");
            System.out.println("5 - Перевод числа из 8-ной в 2-ную систему");
            System.out.println("6 - Перевод числа из 8-ной в 16-ную систему");
            System.out.println("7 - Перевод числа из 16-ной в 8-ную систему");
            System.out.println("0 - Выход");
            menuKey = Integer.parseInt(getValue(input, 10));
            switch (menuKey) {
                case 1 -> createNumber(input);
                case 2 -> convert(2, 10);
                case 3 -> convert(10, 2);
                case 4 -> convert(2, 8);
                case 5 -> convert(8, 2);
                case 6 -> convert(8, 16);
                case 7 -> convert(16, 8);
                case 0 -> System.out.println("Программа завершает работу");
                default -> System.out.println("Введите корректный пункт меню");
            }
        }
        while (menuKey != 0);
    }

    public static void createNumber(Scanner input) {
        System.out.println("Выберите систему вводимого счисления: 2, 8, 10, 16");
        int numberSystem = getNumberSystem(input);
        System.out.println("Введите значение");
        value = new Number(getValue(input, numberSystem), numberSystem);
    }

    public static void convert(int from, int to) {
        if (value.getNumberSystem() == from) {
            String result = value.getValue();
            int decimal = Integer.parseInt(value.getValue(), from);
            switch (to) {
                case 2 -> result = Integer.toBinaryString(decimal);
                case 8 -> result = Integer.toOctalString(decimal);
                case 16 -> result = Integer.toHexString(decimal);
                case 10 -> result = String.valueOf(decimal);
            }
            value.setValue(result);
            value.setNumberSystem(to);
        } else System.out.println("Система счисления должны быть " + from + "-ной");
    }

    public static String getValue(Scanner input, int numberSystem) {
        String result;
        while (!isCorrectValue(result = input.nextLine(), numberSystem)) {
            System.out.println("Введите число");
        }
        return result;
    }

    public static boolean isCorrectValue(String line, int numberSystem) {
        try {
            Integer.parseInt(line, numberSystem);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static int getNumberSystem(Scanner input) {
        int result;
        while (!isNumberSystem(result = Integer.parseInt(getValue(input, 10)))) {
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