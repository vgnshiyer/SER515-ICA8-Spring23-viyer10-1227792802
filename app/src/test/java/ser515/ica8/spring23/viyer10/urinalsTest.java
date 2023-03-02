package ser515.ica8.spring23.viyer10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.jupiter.api.Test;

public class urinalsTest {
    urinals urinal = new urinals();

    @Test
    public void test_string_empty(){
        System.out.println("====== Vignesh Iyer == TEST ONE EXECUTED =======");
        String input = "";
        var result = urinals.goodString(input);
        assertFalse(result);
    }
    
    @Test
    public void test_string_longer_than_20(){
        System.out.println("====== Vignesh Iyer == TEST TWO EXECUTED =======");
        String input = "123456789012345678901";
        var result = urinals.goodString(input);
        assertFalse(result);
    }

    @Test
    public void test_string_with_invalid_characters(){
        System.out.println("====== Vignesh Iyer == TEST THREE EXECUTED =======");
        String input = "10xxxx";
        var result = urinals.goodString(input);
        assertFalse(result);
    }

    @Test
    public void test_string_with_valid_chars(){
        System.out.println("====== Vignesh Iyer == TEST FOUR EXECUTED =======");
        String input = "10010";
        var result = urinals.goodString(input);
        assertTrue(result);
    }

    @Test
    public void test_with_no_file_in_directory(){
        String filename = "not_there.dat";
        assertThrows(FileNotFoundException.class,() -> urinals.openFile(filename));
    }

    @Test
    public void test_with_file_with_wrong_extension(){
        String filename = "wrong.txt"; // must be .dat
        Exception exception = assertThrows(Exception.class,() -> urinals.openFile(filename));
        assertEquals(exception.getMessage(), "File should have an extension of .dat");
    }
}
