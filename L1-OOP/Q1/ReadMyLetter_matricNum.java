import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadMyLetter_matricNum {
    public static void main(String[] args) {
        // Part 1
        try {
            Scanner inputStream = new Scanner(new FileInputStream("name_matricNum.txt"));
            while (inputStream.hasNextLine()) {
                System.out.println(inputStream.nextLine());
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
        System.out.println("");


        // Part 2
        try {
            Scanner sc = new Scanner(System.in);
            String input;

            PrintWriter outputStream = new PrintWriter(new FileOutputStream("name_matricNum.txt", true));
            outputStream.println("\n\nThursday, 18 June 2021.\n");
            outputStream.print("It’s me again. Finally, it’s the end of the term and the DS class has finished! ");

            System.out.println("How you performed in the class?");
            input = sc.nextLine();
            // I think I performed moderately in the class.
            outputStream.println(input + ". ");

            System.out.println("\nAre you happy with your performance?");
            input = sc.nextLine();
            // I am happy with my performance
            outputStream.println(input + ". ");

            System.out.println("\nWhat has learning DS taught you / what did you learn from DS?");
            input = sc.nextLine();
            // I learn to use data structures in my program to organize the data
            outputStream.println(input + ". ");

            System.out.println("\nIs there any change to your target grade?");
            input = sc.nextLine();
            // No, my target grade still remains A
            outputStream.println(input + ". ");

            System.out.println("\nWhat you did well during the course?");
            input = sc.nextLine();
            // I love lab session because it gives me hands-on learning experience
            outputStream.println(input + ". ");

            System.out.println("\nWhat could have been done better during the course?");
            input = sc.nextLine();
            // I hope there is more hands-on learning session during the course
            outputStream.println(input + ". ");

            outputStream.close();
            System.out.println("File saved!");

        } catch (IOException e) {
            System.out.println("Problem with file output!");
        }
    }
}

