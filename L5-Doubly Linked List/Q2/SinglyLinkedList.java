public class SinglyLinkedList<E> {
    private SNode<E> head;
    private SNode<E> tail;
    private int size;

    public SinglyLinkedList() {
    }

    public void add(E e) {
        if (tail == null) {
            head = tail = new SNode<>(e);
        }
        else {
            tail.next = new SNode<>(e);
            tail = tail.next;
        }
        size++;
    }

    public void removeElement(E e) {
        if (size == 0) {
            throw new IllegalStateException();
        }

        SNode<E> current;
        if (head.element.equals(e)) {
            current = head;
            head = head.next;
        }
        else {
            SNode<E> previous = head;
            while (!previous.next.element.equals(e)) {
                previous = previous.next;
            }
            current = previous.next;
            previous.next = current.next;
        }
        size--;
        System.out.println(current.element);
    }

    public void printList() {
        SNode<E> current = head;
        String separator = "";
        while (current != null) {
            System.out.print(separator + current.element);
            current = current.next;
            separator = ", ";
        }
        System.out.println(".");
    }

    public int getSize() {
        return size;
    }

    public boolean contains(E e) {
        SNode<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void replace(E e, E newE) {
        SNode<E> current = head;
        while (!current.element.equals(e)) {
            current = current.next;
        }
        current.element = newE;
    }
}
