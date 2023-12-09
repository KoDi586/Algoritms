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
                Arrays.toString(stringList.getStrings()));

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
        Assertions.assertEquals(Arrays.toString(stringList.getStrings()),
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
        Assertions.assertEquals(Arrays.toString(stringList.getStrings()),
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

        Assertions.assertEquals(Arrays.toString(stringList.getStrings()),
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

}
