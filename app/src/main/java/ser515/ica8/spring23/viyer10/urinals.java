package ser515.ica8.spring23.viyer10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class urinals {

    public Boolean goodString(String urinalInput){
        if(urinalInput.length() < 1){
            return false;
        }
        return null;
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