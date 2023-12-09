import my_List.*;
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

        Assertions.assertThrows(ZfullListException.class, () -> {
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
        Assertions.assertThrows(ZNotCorrectIndexException.class, () -> {
            stringList.add(100, "hjk");
        });
        stringList.add(1, thridString);
        Assertions.assertEquals(stringList.add(finalString), "ff");
        Assertions.assertEquals(Arrays.toString(stringList.getStrings()),
                "[aa, cc, bb, ff]");

        Assertions.assertThrows(ZfullListException.class, () ->{
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

        Assertions.assertThrows(ZNotCorrectIndexException.class, () -> {
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

        Assertions.assertThrows(ZNotfoundElement.class, () -> {
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

        Assertions.assertThrows(ZNotCorrectIndexException.class, ()-> {
            stringList.remove(3);
        });

    }

}
