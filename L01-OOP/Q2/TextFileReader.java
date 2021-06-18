import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TextFileReader {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Filename  -> Delimiters ");
        System.out.println("text1.txt -> ,");
        System.out.println("text2.txt -> ,[space]");
        System.out.println("text3.txt -> ;[space]");
        System.out.println("text4.txt -> \\d+\n");

        System.out.print("Enter txt file to read: ");
        String filename = input.nextLine();

        System.out.print("Enter special characters (delimiter): ");
        String delimiter = input.nextLine();

        try {
            Scanner inputStream = new Scanner(new FileInputStream(filename));

            int charNum = 0;
            while (inputStream.hasNextLine()) {
                String line = inputStream.nextLine();

                Pattern pattern = Pattern.compile(delimiter);
                String[] afterSplit = pattern.split(line);

                for (int i = 0; i < afterSplit.length; i++) {
                    System.out.print(afterSplit[i]);
                    charNum += afterSplit[i].length();
                }
                System.out.println();
            }
            System.out.println("\nNumber of characters : " + charNum);
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
    }
}
