import my_List.stringList.MyListStOrInt;
import my_List.stringList.ListWithInteger;
import my_List.stringListException.FullListException;
import my_List.stringListException.NotCorrectIndexException;
import my_List.stringListException.NotFoundElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ListWithIntegersTest {

    @Test
    public void add() {
        MyListStOrInt<Integer> integerList = new ListWithInteger(2);
        Integer firstString = 1234;
        Assertions.assertEquals(integerList.add(firstString), 1234);
        Assertions.assertEquals(integerList.add(firstString), 1234);
        Assertions.assertEquals("[1234, 1234]",
                Arrays.toString(integerList.getStringsArray()));


        Assertions.assertEquals(integerList.size(),2);
        Assertions.assertEquals(integerList.add(12345), 12345);
        Assertions.assertEquals(integerList.size(),3);
    }

    @Test
    public void addWithIndex() {
        MyListStOrInt<Integer> integerList = new ListWithInteger(4);
        Integer firstNum = 11;
        Integer secondNum = 22;
        Integer thirdNum = 33;
        Integer finalNum = 44;
        Assertions.assertEquals(integerList.add(firstNum), 11);
        Assertions.assertEquals(integerList.add(secondNum), 22);
        Assertions.assertThrows(NotCorrectIndexException.class, () -> {
            integerList.add(100, secondNum);
        });
        integerList.add(1, thirdNum);
        Assertions.assertEquals(integerList.add(finalNum), 44);
        Assertions.assertEquals(Arrays.toString(integerList.getStringsArray()),
                "[11, 33, 22, 44]");

        Assertions.assertEquals(integerList.size(),4);
        Assertions.assertEquals(integerList.add(1, thirdNum), 33);
        Assertions.assertEquals(integerList.getStringsArray().length,6);
    }

    @Test
    public void set() {
        MyListStOrInt<Integer> integerList = new ListWithInteger(2);
        Integer firstNum = 11;
        Integer secondNum = 22;
        Integer thirdNum = 33;
        Assertions.assertEquals(integerList.add(firstNum), 11);
        integerList.add(secondNum);
        Assertions.assertEquals(integerList.set(0, thirdNum), 33);
        Assertions.assertEquals(Arrays.toString(integerList.getStringsArray()),
                "[33, 22]");

        Assertions.assertThrows(NotCorrectIndexException.class, () -> {
            integerList.set(-2, secondNum);
        });
    }

    @Test
    public void remove() {
        MyListStOrInt integerList = new ListWithInteger(2);
        String firstString = "aa";
        String secondString = "bb";

        integerList.add(firstString);
        integerList.add(secondString);
        Assertions.assertEquals(integerList.remove("aa"), "aa");

        Assertions.assertEquals(Arrays.toString(integerList.getStringsArray()),
                "[bb, null]");

        Assertions.assertThrows(NotFoundElement.class, () -> {
            integerList.remove("ff");
        });

    }

    @Test
    public void removeByIndex() {
        MyListStOrInt integerList = new ListWithInteger(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        integerList.add(firstString);
        integerList.add(secondString);
        integerList.add(thridString);
        Assertions.assertEquals(integerList.remove(1), "bb");

        Assertions.assertThrows(NotCorrectIndexException.class, ()-> {
            integerList.remove(3);
        });

    }

    @Test
    public void contain() {
        MyListStOrInt integerList = new ListWithInteger(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        integerList.add(firstString);
        integerList.add(secondString);
        integerList.add(thridString);

        Assertions.assertTrue(integerList.contains("bb"));
        Assertions.assertFalse(integerList.contains("ff"));
    }

    @Test
    public void indexOf() {
        MyListStOrInt integerList = new ListWithInteger(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        integerList.add(firstString);
        integerList.add(secondString);
        integerList.add(thridString);

        Assertions.assertEquals(integerList.indexOf("cc"), 2);
        Assertions.assertEquals(integerList.indexOf("ff"), -1);
    }


    @Test
    public void lastIndexOf() {
        MyListStOrInt integerList = new ListWithInteger(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        integerList.add(firstString);
        integerList.add(secondString);
        integerList.add(thridString);

        Assertions.assertEquals(integerList.indexOf("cc"), 2);
        Assertions.assertEquals(integerList.indexOf("ff"), -1);
    }

    @Test
    public void get() {
        MyListStOrInt integerList = new ListWithInteger(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        integerList.add(firstString);
        integerList.add(secondString);
        integerList.add(thridString);

        Assertions.assertEquals(integerList.get(1), "bb");

        Assertions.assertThrows(NotCorrectIndexException.class, () -> {
            integerList.get(3);
        });
    }

    @Test
    public void equals() {
        MyListStOrInt integerList = new ListWithInteger(3);
        MyListStOrInt stringListNotSort = new ListWithInteger(3);
        MyListStOrInt stringListNotEq = new ListWithInteger(3);
        MyListStOrInt stringListEquals = new ListWithInteger(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        integerList.add(firstString);
        stringListNotSort.add(firstString);
        stringListNotEq.add(firstString);
        stringListEquals.add(firstString);

        integerList.add(secondString);
        stringListNotSort.add(thridString);
        stringListNotEq.add(secondString);
        stringListEquals.add(secondString);

        integerList.add(thridString);
        stringListNotSort.add(secondString);
        stringListNotEq.add("ff");
        stringListEquals.add(thridString);

        Assertions.assertTrue(integerList.equals(stringListEquals));
        Assertions.assertFalse(integerList.equals(stringListNotEq));
        Assertions.assertFalse(integerList.equals(stringListNotSort));

        Assertions.assertThrows(NullPointerException.class, () -> {
            integerList.equals(null);
        });
    }

    @Test
    public void size() {
        MyListStOrInt integerList = new ListWithInteger(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        integerList.add(firstString);
        integerList.add(secondString);

        Assertions.assertEquals(integerList.size(), 2);

        integerList.add(thridString);

        Assertions.assertEquals(integerList.size(), 3);
    }

    @Test
    public void idEmpty() {
        MyListStOrInt integerList = new ListWithInteger(3);
        Assertions.assertTrue(integerList.isEmpty());


        String firstString = "aa";
        integerList.add(firstString);
        Assertions.assertFalse(integerList.isEmpty());

        integerList.remove(0);
        Assertions.assertTrue(integerList.isEmpty());
    }

    @Test
    public void clear() {
        MyListStOrInt integerList = new ListWithInteger(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        integerList.add(firstString);
        integerList.add(secondString);
        integerList.add(thridString);

        Assertions.assertFalse(integerList.isEmpty());
        integerList.clear();
        Assertions.assertTrue(integerList.isEmpty());

        integerList.add(firstString);
    }

    @Test
    public void toArray() {
        MyListStOrInt integerList = new ListWithInteger(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        integerList.add(firstString);
        integerList.add(secondString);
        integerList.add(thridString);

        Integer[] newStrings = (Integer[]) integerList.toArray();

        Assertions.assertEquals(Arrays.toString(newStrings), "[aa, bb, cc]");
    }


    @Test
    public void binaryFindInSortedArray() {
        MyListStOrInt<Integer> integersList = new ListWithInteger(5);
        integersList.add(5);
        integersList.add(4);
        integersList.add(3);
        integersList.add(1);
        integersList.add(2);

        Assertions.assertEquals(integersList.indexOf(3),2);

//        так же здесь тест и на рекурсивную сортировку, так как она участвует в бинарном поиске.
    }
}
