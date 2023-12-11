import my_List.stringList.StringList;
import my_List.stringList.StringListImpl;
import my_List.stringListException.NotCorrectIndexException;
import my_List.stringListException.NotFoundElement;
import my_List.stringListException.FullListException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StringListTest {

    @Test
    public void add() {
        StringList stringList = new StringListImpl(2);
        String firstString = "aabbcc";
        Assertions.assertEquals(stringList.add(firstString), "aabbcc");
        Assertions.assertEquals(stringList.add(firstString), "aabbcc");
        Assertions.assertEquals("[aabbcc, aabbcc]",
                Arrays.toString(stringList.getStringsArray()));

        Assertions.assertThrows(FullListException.class, () -> {
            stringList.add("hjk");
        });
    }

    @Test
    public void addWithIndex() {
        StringList stringList = new StringListImpl(4);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";
        String finalString = "ff";
        Assertions.assertEquals(stringList.add(firstString), "aa");
        Assertions.assertEquals(stringList.add(secondString), "bb");
        Assertions.assertThrows(NotCorrectIndexException.class, () -> {
            stringList.add(100, "hjk");
        });
        stringList.add(1, thridString);
        Assertions.assertEquals(stringList.add(finalString), "ff");
        Assertions.assertEquals(Arrays.toString(stringList.getStringsArray()),
                "[aa, cc, bb, ff]");

        Assertions.assertThrows(FullListException.class, () ->{
            stringList.add(3, "ghj");
        });
    }

    @Test
    public void set() {
        StringList stringList = new StringListImpl(2);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";
        Assertions.assertEquals(stringList.add(firstString), "aa");
        stringList.add(secondString);
        Assertions.assertEquals(stringList.set(0, thridString), "cc");
        Assertions.assertEquals(Arrays.toString(stringList.getStringsArray()),
                "[cc, bb]");

        Assertions.assertThrows(NotCorrectIndexException.class, () -> {
            stringList.set(-2, "hjk");
        });
    }

    @Test
    public void remove() {
        StringList stringList = new StringListImpl(2);
        String firstString = "aa";
        String secondString = "bb";

        stringList.add(firstString);
        stringList.add(secondString);
        Assertions.assertEquals(stringList.remove("aa"), "aa");

        Assertions.assertEquals(Arrays.toString(stringList.getStringsArray()),
                "[bb, null]");

        Assertions.assertThrows(NotFoundElement.class, () -> {
            stringList.remove("ff");
        });

    }

    @Test
    public void removeByIndex() {
        StringList stringList = new StringListImpl(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        stringList.add(firstString);
        stringList.add(secondString);
        stringList.add(thridString);
        Assertions.assertEquals(stringList.remove(1), "bb");

        Assertions.assertThrows(NotCorrectIndexException.class, ()-> {
            stringList.remove(3);
        });

    }

    @Test
    public void contain() {
        StringList stringList = new StringListImpl(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        stringList.add(firstString);
        stringList.add(secondString);
        stringList.add(thridString);

        Assertions.assertTrue(stringList.contains("bb"));
        Assertions.assertFalse(stringList.contains("ff"));
    }

    @Test
    public void indexOf() {
        StringList stringList = new StringListImpl(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        stringList.add(firstString);
        stringList.add(secondString);
        stringList.add(thridString);

        Assertions.assertEquals(stringList.indexOf("cc"), 2);
        Assertions.assertEquals(stringList.indexOf("ff"), -1);
    }


    @Test
    public void lastIndexOf() {
        StringList stringList = new StringListImpl(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        stringList.add(firstString);
        stringList.add(secondString);
        stringList.add(thridString);

        Assertions.assertEquals(stringList.indexOf("cc"), 2);
        Assertions.assertEquals(stringList.indexOf("ff"), -1);
    }

    @Test
    public void get() {
        StringList stringList = new StringListImpl(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        stringList.add(firstString);
        stringList.add(secondString);
        stringList.add(thridString);

        Assertions.assertEquals(stringList.get(1), "bb");

        Assertions.assertThrows(NotCorrectIndexException.class, () -> {
            stringList.get(3);
        });
    }

    @Test
    public void equals() {
        StringList stringList = new StringListImpl(3);
        StringList stringListNotSort = new StringListImpl(3);
        StringList stringListNotEq = new StringListImpl(3);
        StringList stringListEquals = new StringListImpl(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        stringList.add(firstString);
        stringListNotSort.add(firstString);
        stringListNotEq.add(firstString);
        stringListEquals.add(firstString);

        stringList.add(secondString);
        stringListNotSort.add(thridString);
        stringListNotEq.add(secondString);
        stringListEquals.add(secondString);

        stringList.add(thridString);
        stringListNotSort.add(secondString);
        stringListNotEq.add("ff");
        stringListEquals.add(thridString);

        Assertions.assertTrue(stringList.equals(stringListEquals));
        Assertions.assertFalse(stringList.equals(stringListNotEq));
        Assertions.assertFalse(stringList.equals(stringListNotSort));

        Assertions.assertThrows(NullPointerException.class, () -> {
            stringList.equals(null);
        });
    }

    @Test
    public void size() {
        StringList stringList = new StringListImpl(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        stringList.add(firstString);
        stringList.add(secondString);

        Assertions.assertEquals(stringList.size(), 2);

        stringList.add(thridString);

        Assertions.assertEquals(stringList.size(), 3);
    }

    @Test
    public void idEmpty() {
        StringList stringList = new StringListImpl(3);
        Assertions.assertTrue(stringList.isEmpty());


        String firstString = "aa";
        stringList.add(firstString);
        Assertions.assertFalse(stringList.isEmpty());

        stringList.remove(0);
        Assertions.assertTrue(stringList.isEmpty());
    }

    @Test
    public void clear() {
        StringList stringList = new StringListImpl(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        stringList.add(firstString);
        stringList.add(secondString);
        stringList.add(thridString);

        Assertions.assertFalse(stringList.isEmpty());
        stringList.clear();
        Assertions.assertTrue(stringList.isEmpty());

        stringList.add(firstString);
    }

    @Test
    public void toArray() {
        StringList stringList = new StringListImpl(3);
        String firstString = "aa";
        String secondString = "bb";
        String thridString = "cc";

        stringList.add(firstString);
        stringList.add(secondString);
        stringList.add(thridString);

        String[] newStrings = stringList.toArray();

        Assertions.assertEquals(Arrays.toString(newStrings), "[aa, bb, cc]");
    }
}
