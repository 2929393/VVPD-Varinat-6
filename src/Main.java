import java.util.Scanner;

public class Main {

    /**
     * Объект класса Number, представляющего собой число в некоторой системе счисления
     */
    static Number value;
    public static void main(String[] args) {
        //Создание сканера для ввода в консоль
        Scanner input = new Scanner(System.in);
        //Ввод первоначального числа
        createNumber(input);

        //Вывод меню. Цикл будет повторяться, пока пользователь не выберет "Выход"
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

    /**
     * Метод для ввода числа
     * @param input Сканер ввода
     */
    public static void createNumber(Scanner input) {
        System.out.println("Выберите систему вводимого счисления: 2, 8, 10, 16");
        int numberSystem = getNumberSystem(input);
        System.out.println("Введите значение");
        value = new Number(getValue(input, numberSystem), numberSystem);
    }

    /**
     * Метод для конвертации значения из одной системы счисления в другую
     * @param from Система счисления, из которой надо перевести
     * @param to Система счисления, в которую надо перевести
     */
    public static void convert(int from, int to) {
        //Проверка, что система счисления числа является подходящей для данной конвертации
        if (value.getNumberSystem() == from) {
            String result = value.getValue();
            //Перевод числа в десятичную систему счисления. Это обязательный шаг
            int decimal = Integer.parseInt(value.getValue(), from);
            switch (to) {
                //Перевод в 2-ную систему
                case 2 -> result = Integer.toBinaryString(decimal);
                //Перевод в 8-ную систему
                case 8 -> result = Integer.toOctalString(decimal);
                //Перевод в 16-ную систему
                case 16 -> result = Integer.toHexString(decimal);
                //Перевод в 10-ную отсутствует. Просто возвращается число ранее переведенное в десятичную
                case 10 -> result = String.valueOf(decimal);
            }
            //Изменение значений объекта числа
            value.setValue(result);
            value.setNumberSystem(to);
        } else System.out.println("Система счисления должны быть " + from + "-ной");
    }

    /**
     * Метод для получения числа в определенной системе счисления
     * @param input Сканер ввода
     * @param numberSystem Система счисления
     * @return Строка, содержащая число в системе счисления
     */
    public static String getValue(Scanner input, int numberSystem) {
        String result;
        //Метод isCorrectValue проверяет, что это число, и оно в нужной системе счисления
        while (!isCorrectValue(result = input.nextLine(), numberSystem)) {
            System.out.println("Введите число");
        }
        return result;
    }

    /**
     * Метод для проверки корректности числа
     * @param line Строка, содержащая число
     * @param numberSystem Система счисления
     * @return Результат проверки
     */
    public static boolean isCorrectValue(String line, int numberSystem) {
        try {
            //Если это не число или число в другой системе счисления, сгенерируется исключение
            Integer.parseInt(line, numberSystem);
            //Если число прошло проверку, возвращается Истина
            return true;
        }
        catch (NumberFormatException e) {
            //В случае исключения строка не прошла проверку. Возвращается Ложь
            return false;
        }
    }

    /**
     * Метод для получения системы счисления
     * @param input Сканер ввода
     * @return Система счисления
     */
    public static int getNumberSystem(Scanner input) {
        int result;
        //Пользователь вводит число системы счисления. Метод isNumberSystem проверяет, что это 2, 9, 10 или 16.
        while (!isNumberSystem(result = Integer.parseInt(getValue(input, 10)))) {
            //Если это ни одно из вышеперечисленных значений, выдается ошибка
            System.out.println("Введите систему счисления");
        }
        return result;
    }

    /**
     * Метод для проверки введенной системы счисления, как обрабатываемой
     * @param value Номер системы счисления
     * @return Результат проверки
     */
    public static boolean isNumberSystem(int value) {
        int[] numberSystems = new int[] {2, 8, 10, 16};
        for (int numberSystem : numberSystems) {
            //Если полученная система - это 2, 8, 10, 16, возвращается Истина
            if (value == numberSystem)
                return true;
        }
        //Если нет, возвращается Ложь
        return false;
    }
}