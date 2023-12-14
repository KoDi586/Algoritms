package my_List;

import my_List.stringList.StringListWithInteger;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
        task3();

    }

    public static void task1() {
        double b = 0;
        long start = System.currentTimeMillis();
        for (double i = 1; i < 10000; i++) {
            for (double j = 1; j < 100000; j++) {
                double a = i * i / j * i;
                b += (long) a;
            }

        }
        ;
        System.out.println(System.currentTimeMillis() - start);
        System.out.println((b));
    }

    public static void task2() {

        long start = System.currentTimeMillis();
        // Задаем размер массива
        int arraySize = 100_000;

        // Создаем объект класса Random
        Random random = new Random();

        // Создаем массив
        Integer[] randomArray = new Integer[arraySize];

        // Заполняем массив случайными числами
        for (int i = 0; i < arraySize; i++) {
            randomArray[i] = random.nextInt(1000); // Генерация случайного int
            // Если вам нужны числа в определенном диапазоне, вы можете использовать следующий код:
            // randomArray[i] = random.nextInt(100); // Генерация случайного int от 0 до 99
        }

        // Выводим массив на экран
        System.out.println("Случайный массив:");
        int count = 0;
        for (int number : randomArray) {
            System.out.println(count + ") " + number);
            count++;
        }

        System.out.println(System.currentTimeMillis() - start);

    }

    public static void task3() {
        StringListWithInteger myList = new StringListWithInteger(3);
        myList.add(3);
        myList.add(2);
        myList.add(1);
//        System.out.println(myList.get(0));
        System.out.println(myList.binarnFindWithSortArray(1));
    }
}

