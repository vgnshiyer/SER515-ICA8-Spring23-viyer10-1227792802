package ser515.ica8.spring23.viyer10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class urinals {

    public static Boolean goodString(String urinalInput){
        if(urinalInput.length() < 1 || urinalInput.length() > 20) return false;

        int n = urinalInput.length();
        for(int i = 0; i < n; i++){
            char c = urinalInput.charAt(i);
            if(c != '0' && c != '1') return false;
        }
        return true;
    }

    public static List<String> scanFile(String filename) throws FileNotFoundException, Exception{
        if(!filename.endsWith(".dat")) throw new Exception("File should have an extension of .dat");

        InputStream inputStream = urinals.class.getClassLoader().getResourceAsStream(filename);

        if(inputStream == null){
            throw new FileNotFoundException("File with name "+filename+" not found.");
        }
        Scanner scanner = new Scanner(inputStream);

        List<String> urinal_list = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.equals("-1")) break;
            urinal_list.add(line);
        }
        return urinal_list;
    }

    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // input from command line or from file
        int choice = 0;

        System.out.println("Select choice of input:\n");
        System.out.println("0 : Input from command line");
        System.out.println("1 : Input from file");
        
        try {
            choice = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a value 0 or 1.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Invalid input! Please enter a value 0 or 1.");
            e.printStackTrace();
        }

        if(choice == 0){
            // read cmd
        } else {
            // read file
        }
    }
}
