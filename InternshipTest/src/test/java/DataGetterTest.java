import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataGetterTest {

    @Test
    void emptyString_checkIfHasDigits() {
        DataGetter getter = new DataGetter();
        assertEquals(false, getter.checkIfHasDigits(""));
    }

    @Test
    void nullString_checkIfHasDigits() {
        DataGetter getter = new DataGetter();
        assertEquals(false, getter.checkIfHasDigits(null));
    }

    @Test
    void onlyCharString_checkIfHasDigits() {
        DataGetter getter = new DataGetter();
        assertEquals(false, getter.checkIfHasDigits("Lorem ipsum dolor sit amet"));
    }

    @Test
    void blankString_checkIfHasDigits() {
        DataGetter getter = new DataGetter();
        assertEquals(false, getter.checkIfHasDigits("              "));
    }

    @Test
    void ok_checkIfHasDigits() {
        DataGetter getter = new DataGetter();
        assertEquals(false, getter.checkIfHasDigits("Juha,1000,5,2"));
    }

    @Test
    void several_removeNonValidRows() {
        DataGetter getter = new DataGetter();
        List<String> strList = new ArrayList<String>(Arrays.asList("Okay", "   ", null, "123", "Okay123", "", ".,-", ",1lh23."));
        getter.removeNonValidRows(strList);
        assertEquals(3,strList.size());
    }

    @Test
    void removeNonValidRows() {
        DataGetter getter = new DataGetter();
        List<String> strList = new ArrayList<String>(Arrays.asList("", "   ", null, "Okay"));
        getter.removeNonValidRows(strList);
        assertEquals(0,strList.size());
    }
}