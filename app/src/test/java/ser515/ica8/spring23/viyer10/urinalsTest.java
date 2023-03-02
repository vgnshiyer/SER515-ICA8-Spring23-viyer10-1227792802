package ser515.ica8.spring23.viyer10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.List;

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
        assertThrows(FileNotFoundException.class,() -> urinals.scanFile(filename));
    }

    @Test
    public void test_with_file_with_wrong_extension(){
        String filename = "wrong.txt"; // must be .dat
        Exception exception = assertThrows(Exception.class,() -> urinals.scanFile(filename));
        assertEquals(exception.getMessage(), "File should have an extension of .dat");
    }

    @Test
    public void test_file_with_proper_format() throws FileNotFoundException, Exception{
        String multiLineString = "110101\n" +
                                 "1010001\n" +
                                 "0000010";
        
        String filename = "urinalTest.dat";
        File file = new File(urinals.class.getClassLoader().getResource(filename).toURI());
        PrintWriter printWriter = new PrintWriter(new FileWriter(file));
        printWriter.println(multiLineString);
        printWriter.close();

        List<String> urinal_list = urinals.scanFile(filename);
        assertEquals(urinal_list.size(), 3);
    }
}
