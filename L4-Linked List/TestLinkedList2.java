public class TestLinkedList2 {

    public static void main(String[] args) {
        MyLinkedList<Character> myLinkedList = new MyLinkedList<>();

        // append the following: a, b,c, d, e
        myLinkedList.addLast('a');
        myLinkedList.addLast('b');
        myLinkedList.addLast('c');
        myLinkedList.addLast('d');
        myLinkedList.addLast('e');

        // print all the elements in the list
        System.out.print("All the elements in the list: ");
        myLinkedList.print();

        System.out.println("Middle value: " + myLinkedList.getMiddleValue());
    }
}
