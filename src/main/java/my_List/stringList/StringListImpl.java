package my_List.stringList;

import my_List.stringListException.NotCorrectIndexException;
import my_List.stringListException.NotFoundElement;
import my_List.stringListException.FullListException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] strings;
    private int count;

    public StringListImpl(int size) {
        strings = new String[size];
        count = 0;
    }

    @Override
    public String add(String string) {
        if (count >= strings.length) {
            throw new FullListException("список заполнен");
        }
        strings[count] = string;
        count++;
        return string;
    }

    @Override
    public String add(int index, String item) {
        if (count >= strings.length) {
            throw new FullListException("список заполнен");
        }
        if (index < 0 | index > count) {
            throw new NotCorrectIndexException("введен не корректный индекс");
        }
        for (int i = count; i >= index; i--) {
            strings[count] = strings[count-1];
        }
        strings[index] = item;
        count++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 | index > count-1) {
            throw new NotCorrectIndexException("введен не корректный индекс");
        }
        strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        boolean firstRemove = true;
        for (int i = 0; i <= count-1; i++) {
            if (!strings[i].equals(item) & firstRemove) {
                continue;
            }
            firstRemove = false;
            if (i == count-1) {
                strings[i] = null;
                continue;//чтобы не было ошибки при последнем элементе
            }
            strings[i] = strings[i + 1];
        }
        count--;
        if (firstRemove) {
            throw new NotFoundElement("Вы пытаетесь удалить не существующий элемент");
        }
        return item;
    }

    @Override
    public String remove(int index) {
        if (index < 0 | index >= count) {
            throw new NotCorrectIndexException("удалить по индексу не удалось!");
        }
        String save = strings[index];
        for (int i = index; i <= count-1; i++) {
            if (i == count - 1) {
                strings[i] = null;
                continue;
            }
            strings[i] = strings[i + 1];
        }
        count--;
        return save;
    }

    @Override
    public boolean contains(String item) {
        for (String string : strings) {
            if (string.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < strings.length; i++) {
            if (item.equals(strings[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = strings.length-1; i >= 0 ; i--) {
            if (item.equals(strings[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= strings.length | index < 0) {
            throw new NotCorrectIndexException("проблема в индексе get()");
        }
        return strings[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullPointerException("переданный лист является null");
        }
        return Arrays.equals(strings, otherList.getStringsArray());
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
        strings = new String[strings.length];
        count = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(strings, strings.length);
    }

    public String[] getStringsArray() {
        return strings;
    }

}
