import Lab.L6.Q1.MyStack;

import java.util.Scanner;

// Output of the elements is from 1 to n.
// The output is in th reverse order because stack is a LIFO (last in first out) data structure

public class TestIntMyStack {

    public static void main(String[] args) {
        MyStack<Integer> intMyStack = new MyStack<>();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            intMyStack.push(i);
        }

        System.out.println("Size of stack: " + intMyStack.getSize());

        System.out.println("Content of the stack: ");
        while (!intMyStack.isEmpty()) {
            System.out.print(intMyStack.pop() + " ");
        }
        System.out.println();
    }
}
