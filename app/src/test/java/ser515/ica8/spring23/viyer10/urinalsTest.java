package ser515.ica8.spring23.viyer10;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.jupiter.api.Test;

public class urinalsTest {
    urinals urinal = new urinals();

    @Test
    public void test_string_empty(){
        System.out.println("====== Vignesh Iyer == TEST ONE EXECUTED =======");
        String input = "";
        var result = urinal.goodString(input);
        assertFalse(result);
    }
    
    @Test
    public void test_string_longer_than_20(){
        System.out.println("====== Vignesh Iyer == TEST TWO EXECUTED =======");
        String input = "123456789012345678901";
        var result = urinal.goodString(input);
        assertFalse(result);
    }

    @Test
    public void test_string_with_invalid_characters(){
        System.out.println("====== Vignesh Iyer == TEST THREE EXECUTED =======");
        String input = "10xxxx";
        var result = urinal.goodString(input);
        assertFalse(result);
    }

    @Test
    public void test_string_with_valid_chars(){
        System.out.println("====== Vignesh Iyer == TEST FOUR EXECUTED =======");
        String input = "10010";
        var result = urinal.goodString(input);
        assertTrue(result);
    }

    
}
