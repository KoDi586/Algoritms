package my_List;

import my_List.stringList.ListWithInteger;
import my_List.stringList.MyListStOrInt;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
        int[] array1 = randomArray();
        int[] array2 = randomArray();

//        long start = System.currentTimeMillis();
//        mergeSort(array1);
//        long firstTime = System.currentTimeMillis() - start;
//
//        long middle = System.currentTimeMillis();
//        quickSort(array2,0,array2.length-1);
//        long secondTime = System.currentTimeMillis() - middle;
//
//        if (firstTime < secondTime) {
//            System.out.println("первая быстрее на " + (secondTime - firstTime) + "ms");
//        } else {
//            System.out.println("вторая быстрее на " + (firstTime - secondTime) + "ms");
//
//        }



        // Вывод массива для проверки
//        for (int value : array2) {
//            System.out.println(value);
//        }


        MyListStOrInt<Integer> list = new ListWithInteger(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        for (Integer value : list.getStringsArray()) {
            System.out.println(value);
        }
        System.out.println(list.indexOf(3));
    }

//  рандом массив
    private static int[] randomArray() {
        int arraySize = 1_000_000; // Задайте размер массива по вашему желанию
        int[] randomArray = new int[arraySize];

        Random random = new Random();

        for (int i = 0; i < arraySize; i++) {
            randomArray[i] = random.nextInt(2001) - 1000; // Генерация случайного целого числа
        }

        // Вывод массива для проверки
//        for (int value : randomArray) {
//            System.out.println(value);
//        }
        return randomArray;
    }

//  сортировка слиянием
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

//  продолжение
    public static void merge(int[] arr, int[] left, int[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }




//  быстрая сортирвка
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
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
        int arraySize = 10_000_000;

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
        ListWithInteger myList = new ListWithInteger(3);
        myList.add(3);
        myList.add(2);
        myList.add(1);
//        System.out.println(myList.get(0));
        System.out.println(myList.binaryFindWithSortArray(1));
    }
}

