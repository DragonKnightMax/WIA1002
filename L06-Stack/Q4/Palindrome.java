import java.util.Scanner;
import java.util.Stack;

public class Palindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String before = scanner.nextLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < before.length(); i++) {
            stack.push(before.charAt(i));
        }

        String after = "";
        while (!stack.isEmpty()) {
            after += stack.pop().toString();
        }

        if (before.equalsIgnoreCase(after)) {
            System.out.println("Palindrome!");
        }
        else {
            System.out.println("Not a palindrome");
        }
    }
}
