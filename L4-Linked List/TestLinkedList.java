public class TestLinkedList {

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

        // reverse all the elements in the list
        System.out.print("All the elements in the list in reverse order: ");
        myLinkedList.reverse();

        // retrieve the number of elements in the list
        System.out.println( "Size: " + myLinkedList.getSize());

        // retrieve the first and last value
        System.out.println("First element: " + myLinkedList.getFirst());
        System.out.println("Last element : " + myLinkedList.getLast());

        // delete middle value
        int first = myLinkedList.indexOf(myLinkedList.getFirst());
        int last = myLinkedList.indexOf(myLinkedList.getLast());
        int middle = (first + last) / 2;
        System.out.println("Middle value: " + myLinkedList.remove(middle));

        // Retrieve the index location for the second and third value.
        System.out.println("Index of 2nd value: " + myLinkedList.indexOf('b'));
        System.out.println("Index of 3rd value: " + myLinkedList.indexOf('c'));

        // check if the list has the value c
        System.out.println("List has value 'c': " + myLinkedList.contains('c'));

        // Replace the items individually with the following: h,e,l,l,o.
        char[] letters = {'h', 'e', 'l', 'l', 'o'};
        for (int i = 0; i < letters.length; i++) {
            myLinkedList.set(i, letters[i]);
        }
        myLinkedList.print();
    }
}
