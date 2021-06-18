import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String before = scanner.nextLine();

        MyQueue<Character> queue = new MyQueue<>();
        for (int i = before.length() - 1; i >= 0; i--) {
            queue.enqueue(before.charAt(i));
        }

        String after = "";
        while (!queue.isEmpty()) {
            after += queue.dequeue().toString();
        }

        if (before.equalsIgnoreCase(after)) {
            System.out.println("Palindrome");
        }
        else {
            System.out.println("Not a palindrome");
        }
    }
}
