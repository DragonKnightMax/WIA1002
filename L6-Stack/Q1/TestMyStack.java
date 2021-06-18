public class TestMyStack {

    public static void main(String[] args) {

        MyStack<Character> stack = new MyStack<>();

        stack.push('a');
        stack.push('b');
        stack.push('c');

        System.out.println(stack);

        System.out.println("element 'b' is in the stack: " + stack.search('b'));

        System.out.println("element 'k' is in the stack: " + stack.search('k'));


        MyStack<Integer> intStack = new MyStack<>();

        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        System.out.println(intStack);

        System.out.println("Element '6' is in the stack: " + intStack.search(6));
    }
}
