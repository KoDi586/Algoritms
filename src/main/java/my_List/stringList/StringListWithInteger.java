package my_List.stringList;

import my_List.stringListException.FullListException;
import my_List.stringListException.NotCorrectIndexException;
import my_List.stringListException.NotFoundElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringListWithInteger implements StringList <Integer> {
    private Integer[] integers;
    private int count;

    public StringListWithInteger(int size) {
        integers = new Integer[size];
        count = 0;
    }

    @Override
    public String add(Integer integer) {
        if (count >= integers.length) {
            throw new FullListException("список заполнен");
        }
        integers[count] = integer;
        count++;
        return integer.toString();
    }

    @Override
    public String add(int index, Integer item) {
        if (count >= integers.length) {
            throw new FullListException("список заполнен");
        }
        if (index < 0 | index > count) {
            throw new NotCorrectIndexException("введен не корректный индекс");
        }
        for (int i = count; i >= index; i--) {
            integers[count] = integers[count-1];
        }
        integers[index] = item;
        count++;
        return item.toString();
    }

    @Override
    public String set(int index, Integer item) {
        if (index < 0 | index > count-1) {
            throw new NotCorrectIndexException("введен не корректный индекс");
        }
        integers[index] = item;
        return item.toString();
    }

    @Override
    public String remove(Integer item) {
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
        return item.toString();
    }

    @Override
    public String remove(int index) {
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
        return save.toString();
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
        for (int i = 0; i < integers.length; i++) {
            if (item.equals(integers[i])) {
                return i;
            }
        }
        return -1;
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
    public String get(int index) {
        if (index >= integers.length | index < 0) {
            throw new NotCorrectIndexException("проблема в индексе get()");
        }
        return integers[index].toString();
    }

    @Override
    public boolean equals(StringList otherList) {
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
        List<Integer> list = new ArrayList<>(List.of(integers1));
        Collections.sort(list);

        Integer[] newIntegers = new Integer[list.size()];
        for (int i = 0; i < newIntegers.length; i++) {
            newIntegers[i] = list.get(i);
        }
        return newIntegers;
    }

    public int binarnFindWithSortArray(Integer integer) {
        Integer[] sortIntegers = sort(integers);
        if (sortIntegers.length != 0) {
            List<Integer> list = new ArrayList<>(List.of(sortIntegers));
            return Collections.binarySearch(list, integer);
        }
        return -1;
    }

//    public int binarnFind(Integer integer) {
//        Integer[] sortIntegers = sort(integers);
//        if (sortIntegers.length != 0) {
//            return binarnFind(integer, integers);
//        }
//        return -1;
//    }
//
//    private Integer binarnFind(Integer integer, Integer[] list) {
//        if (list.length == 1) {
//            return list[0];
//        }
//        int medium;
//        if (list.length % 2 == 0) {//если четное кол во элементов
//            medium = list.length / 2 - 1;
//        } else {
//            medium = list.length / 2;
//        }
//
//        if (list[medium] = integer) {
//            return
//        }
//    }

}
