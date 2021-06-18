import java.util.Stack;

public class FindSum {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 20; i++) {
            stack.push(i);
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println("Sum of every element in stack is " + sum);
    }
}
