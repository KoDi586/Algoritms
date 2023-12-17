package my_List.stringList;

import my_List.stringListException.NotCorrectIndexException;
import my_List.stringListException.NotFoundElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListWithInteger implements MyListStOrInt<Integer> {
    private Integer[] integers;
    private int count;

    public ListWithInteger(int size) {
        integers = new Integer[size];
        count = 0;
    }

    @Override
    public Integer add(Integer integer) {
        if (count >= integers.length) {
            grow();
        }
        integers[count] = integer;
        count++;
        return integer;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (count >= integers.length) {
            grow();
        }
        if (index < 0 | index > count) {
            throw new NotCorrectIndexException("введен не корректный индекс");
        }
        for (int i = count; i >= index; i--) {
            integers[count] = integers[count-1];
        }
        integers[index] = item;
        count++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index < 0 | index > count-1) {
            throw new NotCorrectIndexException("введен не корректный индекс");
        }
        integers[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        boolean firstRemove = true;
        for (int i = 0; i <= count-1; i++) {
            if (!integers[i].equals(item) & firstRemove) {
                continue;
            }
            firstRemove = false;
            if (i == count-1) {
                integers[i] = null;
                continue;//чтобы не было ошибки при последнем элементе
            }
            integers[i] = integers[i + 1];
        }
        count--;
        if (firstRemove) {
            throw new NotFoundElement("Вы пытаетесь удалить не существующий элемент");
        }
        return item;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 | index >= count) {
            throw new NotCorrectIndexException("удалить по индексу не удалось!");
        }
        Integer save = integers[index];
        for (int i = index; i <= count-1; i++) {
            if (i == count - 1) {
                integers[i] = null;
                continue;
            }
            integers[i] = integers[i + 1];
        }
        count--;
        return save;
    }

    @Override
    public boolean contains(Integer item) {
        for (Integer string : integers) {
            if (string.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        return binaryFindWithSortArray(item);
//        for (int i = 0; i < integers.length; i++) {
//            if (item.equals(integers[i])) {
//                return i;
//            }
//        }
//        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = integers.length-1; i >= 0 ; i--) {
            if (item.equals(integers[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index >= integers.length | index < 0) {
            throw new NotCorrectIndexException("проблема в индексе get()");
        }
        return integers[index];
    }

    @Override
    public boolean equals(MyListStOrInt otherList) {
        if (otherList == null) {
            throw new NullPointerException("переданный лист является null");
        }
        return Arrays.equals(integers, otherList.getStringsArray());
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void clear() {
        integers = new Integer[integers.length];
        count = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integers, integers.length);
    }

    public Integer[] getStringsArray() {
        return integers;
    }

    private Integer[] sort(Integer[] integers1) {

        quickSort(integers1, 0, integers1.length - 1);
        return integers1;
    }

    public int binaryFindWithSortArray(Integer integer) {
        Integer[] sortIntegers = sort(integers);
        if (sortIntegers.length != 0) {
            List<Integer> list = new ArrayList<>(List.of(sortIntegers));
            return Collections.binarySearch(list, integer);
        }
        return -1;
    }


    private void grow() {
        Integer[] newIntegers;
        int newSize = (int) (integers.length * 1.5);
        newIntegers = Arrays.copyOf(integers, newSize);
        integers = newIntegers;
        for (int i = count; i < newSize; i++) {
            integers[i] = 0;
        }
    }


    //  быстрая сортирвка
    public static void quickSort(Integer[] arr, Integer begin, Integer end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static Integer partition(Integer[] arr, Integer begin, Integer end) {
        Integer pivot = arr[end];
        Integer i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, Integer left, Integer right) {
        Integer temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


}
