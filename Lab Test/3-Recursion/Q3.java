import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = 5;
        int[] arr = new int[size];
        getUserInput(arr, 0);
        display(arr);
    }

    // Recursive method to accept user input for the array
    public static void getUserInput(int[] arr, int current) throws IOException {
        System.out.print("Enter an Integer: ");
        String input = bf.readLine();

        // Recursive case
        try {
            int num = Integer.parseInt(input);

            arr[current++] = num;
            getUserInput(arr, current);
        }
        // Detect improper inputs
        catch (NumberFormatException e) {
            System.out.println("Invalid input type");
            getUserInput(arr, current);
        }
        // Base case
        catch (ArrayIndexOutOfBoundsException e) {}
    }

    // Display the array
    public static void display(int[] arr) {
        System.out.println("The array of integers is: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
