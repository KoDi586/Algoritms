package my_List;

public class StringListImpl implements StringList {
    private String[] strings;
    private int count;

    public StringListImpl(int size) {
        strings = new String[size];
        count = 0;
    }

    public String add(String string) {
        if (count >= strings.length) {
            throw new ZfullListException("список заполнен");
        }
        strings[count] = string;
        count++;
        return string;
    }

    public String add(int index, String item) {
        if (count >= strings.length) {
            throw new ZfullListException("список заполнен");
        }
        if (index < 0 | index > count) {
            throw new ZNotCorrectIndexException("введен не корректный индекс");
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
            throw new ZNotCorrectIndexException("введен не корректный индекс");
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
            throw new ZNotfoundElement("Вы пытаетесь удалить не существующий элемент");
        }
        return item;
    }

    @Override
    public String remove(int index) {
        if (index < 0 | index >= count) {
            throw new ZNotCorrectIndexException("удалить по индексу не удалось!");
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

    public String[] getStrings() {
        return strings;
    }

}
