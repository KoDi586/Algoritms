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
        MyListStOrInt<Integer> integerList = new ListWithInteger(2);
        Integer firstNum = 11;
        Integer secondNum = 22;

        integerList.add(firstNum);
        integerList.add(secondNum);
        Assertions.assertEquals(integerList.remove(firstNum), 11);

        Assertions.assertEquals(Arrays.toString(integerList.getStringsArray()),
                "[22, null]");

        Integer forRemove = 44;

        Assertions.assertThrows(NotFoundElement.class, () -> {
            integerList.remove(forRemove);
        });

    }

    @Test
    public void removeByIndex() {
        MyListStOrInt<Integer> integerList = new ListWithInteger(3);
        Integer firstNum = 11;
        Integer secondNum = 22;
        Integer thirdNum = 33;

        integerList.add(firstNum);
        integerList.add(secondNum);
        integerList.add(thirdNum);
        Assertions.assertEquals(integerList.remove(1), 22);

        Assertions.assertThrows(NotCorrectIndexException.class, ()-> {
            integerList.remove(3);
        });

    }

    @Test
    public void contain() {
        MyListStOrInt<Integer> integerList = new ListWithInteger(3);
        Integer firstNum = 11;
        Integer secondNum = 22;
        Integer thirdNum = 33;

        integerList.add(firstNum);
        integerList.add(secondNum);
        integerList.add(thirdNum);

        Assertions.assertTrue(integerList.contains(22));
        Assertions.assertFalse(integerList.contains(55));
    }

    @Test
    public void indexOf() {
        MyListStOrInt<Integer> integerList = new ListWithInteger(3);
        Integer firstNum = 11;
        Integer secondNum = 22;
        Integer thirdNum = 33;

        integerList.add(firstNum);
        integerList.add(secondNum);
        integerList.add(thirdNum);

        Assertions.assertEquals(integerList.indexOf(33), 2);
        Assertions.assertEquals(integerList.indexOf(55), -1);
    }


    @Test
    public void lastIndexOf() {
        MyListStOrInt<Integer> integerList = new ListWithInteger(3);
        Integer firstNum = 11;
        Integer secondNum = 22;
        Integer thirdNum = 33;

        integerList.add(firstNum);
        integerList.add(secondNum);
        integerList.add(thirdNum);

        Assertions.assertEquals(integerList.lastIndexOf(33), 2);
        Assertions.assertEquals(integerList.lastIndexOf(66), -1);
    }

    @Test
    public void get() {
        MyListStOrInt<Integer> integerList = new ListWithInteger(3);
        Integer firstNum = 11;
        Integer secondNum = 22;
        Integer thirdNum = 33;

        integerList.add(firstNum);
        integerList.add(secondNum);
        integerList.add(thirdNum);

        Assertions.assertEquals(integerList.get(1), 22);

        Assertions.assertThrows(NotCorrectIndexException.class, () -> {
            integerList.get(3);
        });
    }

    @Test
    public void equals() {
        MyListStOrInt<Integer> integerList = new ListWithInteger(3);
        MyListStOrInt<Integer> stringListNotSort = new ListWithInteger(3);
        MyListStOrInt<Integer> stringListNotEq = new ListWithInteger(3);
        MyListStOrInt<Integer> stringListEquals = new ListWithInteger(3);

        Integer firstNum = 11;
        Integer secondNum = 22;
        Integer thirdNum = 33;

        integerList.add(firstNum);
        stringListNotSort.add(firstNum);
        stringListNotEq.add(firstNum);
        stringListEquals.add(firstNum);

        integerList.add(secondNum);
        stringListNotSort.add(thirdNum);
        stringListNotEq.add(secondNum);
        stringListEquals.add(secondNum);

        integerList.add(thirdNum);
        stringListNotSort.add(secondNum);
        stringListNotEq.add(555);
        stringListEquals.add(thirdNum);

        Assertions.assertTrue(integerList.equals(stringListEquals));
        Assertions.assertFalse(integerList.equals(stringListNotEq));
        Assertions.assertFalse(integerList.equals(stringListNotSort));

        Assertions.assertThrows(NullPointerException.class, () -> {
            integerList.equals(null);
        });
    }

    @Test
    public void size() {
        MyListStOrInt<Integer> integerList = new ListWithInteger(3);
        Integer firstNum = 11;
        Integer secondNum = 22;
        Integer thirdNum = 33;

        integerList.add(firstNum);
        integerList.add(secondNum);

        Assertions.assertEquals(integerList.size(), 2);

        integerList.add(thirdNum);

        Assertions.assertEquals(integerList.size(), 3);
    }

    @Test
    public void idEmpty() {
        MyListStOrInt<Integer> integerList = new ListWithInteger(3);
        Assertions.assertTrue(integerList.isEmpty());


        Integer firstNum = 11;
        integerList.add(firstNum);
        Assertions.assertFalse(integerList.isEmpty());

        integerList.remove(0);
        Assertions.assertTrue(integerList.isEmpty());
    }

    @Test
    public void clear() {
        MyListStOrInt<Integer> integerList = new ListWithInteger(3);
        Integer firstNum = 11;
        Integer secondNum = 22;
        Integer thirdNum = 33;

        integerList.add(firstNum);
        integerList.add(secondNum);
        integerList.add(thirdNum);

        Assertions.assertFalse(integerList.isEmpty());
        integerList.clear();
        Assertions.assertTrue(integerList.isEmpty());

        integerList.add(firstNum);
    }

    @Test
    public void toArray() {
        MyListStOrInt<Integer> integerList = new ListWithInteger(3);
        Integer firstNum = 11;
        Integer secondNum = 22;
        Integer thirdNum = 33;

        integerList.add(firstNum);
        integerList.add(secondNum);
        integerList.add(thirdNum);

        Integer[] newStrings = integerList.toArray();

        Assertions.assertEquals(Arrays.toString(newStrings),Arrays.toString(new Integer[]{11, 22, 33}));
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
