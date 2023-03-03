// AUTHOR: VIGNESH V IYER
// ASU ID: 1227792802
// ASURITE: viyer10

package ser515.ica8.spring23.viyer10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class urinals {

    public static String filename = "urinal.dat";

    public static Boolean goodString(String urinalInput){
        if(urinalInput.length() < 1 || urinalInput.length() > 20) return false;

        int n = urinalInput.length();
        for(int i = 0; i < n; i++){
            char c = urinalInput.charAt(i);
            if(c != '0' && c != '1') return false;
        }

        for(int i = 1; i < n; i++){
            char c1 = urinalInput.charAt(i-1);
            char c2 = urinalInput.charAt(i);
            if(c1 == '1' && c2 == '1') return false;
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
            if(line.equals("-1")){
                scanner.close();
                break;
            }
            urinal_list.add(line);
        }
        scanner.close();
        return urinal_list;
    }

    public static int countUrinals(String urinal_seq){
        if(!goodString(urinal_seq)) return -1;

        int urinalCount = 0, zeroCount = 0, n = urinal_seq.length();
        for(int i = 0; i < n;){
            char curr = urinal_seq.charAt(i);
            zeroCount += (curr == '0') ? 1 : 0; // counting consecutive zeros
            if(i == urinal_seq.length()-1 && curr == '0'){
                urinalCount += (zeroCount + 1) / 2;
                break;
            }
            if(curr == '1'){
                zeroCount -= 1;
                urinalCount += (zeroCount + 1) / 2;
                zeroCount = 0;
                i+=2;
            } else {
                i++;
            }
        }
        return urinalCount;
    }

    public static PrintWriter write(String outputFilename) throws FileNotFoundException{
        if(outputFilename != "rule.txt") throw new FileNotFoundException("Please provide filename as : rule.txt");

        String outputPath = new File("output/").getAbsolutePath();
        if(!new File(outputPath).exists()) new File(outputPath).mkdirs();

        File file = new File(outputPath,outputFilename);
        int i = 1;
        while(file.exists()){
            outputFilename = "rule" + i + ".txt";
            file = new File(outputPath,outputFilename);
            i++;
        }
        return new PrintWriter(file);
    }

    public static void main(String[] args) throws Exception{
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
            String inp = "";
            while(true){
                System.out.println("Enter a urinal sequence (0's & 1's)");
                inp = reader.readLine();
                System.out.println(countUrinals(inp));
                System.out.println("\nPress e to exit. ENTER to continue");
                inp = reader.readLine();
                if(inp.equals("e")) break;
            }
        } else {
            List<String> urinal_list = scanFile(filename);

            String outputFilename = "rule.txt";
            PrintWriter writer = write(outputFilename);
            for(String urinal_seq : urinal_list){
                int count = countUrinals(urinal_seq);
                writer.println(count);
            }
            writer.close();
            System.out.println("Output has been saved to : " + new File("output/").getAbsolutePath() + outputFilename);
        }
    }
}
