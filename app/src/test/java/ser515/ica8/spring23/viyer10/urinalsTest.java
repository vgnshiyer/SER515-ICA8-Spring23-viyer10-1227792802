package ser515.ica8.spring23.viyer10;

import static org.junit.jupiter.api.Assertions.assertFalse;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.jupiter.api.Test;

public class urinalsTest {
    urinals urinal = new urinals();

    @Test
    public void test_string_empty(){
        String input = "";
        var result = urinal.goodString(input);
        assertFalse(result);
    }
}
