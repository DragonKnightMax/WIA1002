import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    private DNode<E> head;
    private DNode<E> tail;
    private int size;

    public DoublyLinkedList() {
    }

    public void addFirst(E e) {
        DNode<E>  temp = new DNode<>(e, head, null);
        if (head != null) {
            head.prev = temp;
        }
        head = temp;
        if (tail == null) {
            tail = temp;
        }
        size++;
        System.out.println("Adding: " + e);
    }

    public void addLast(E e) {
        DNode<E> temp = new DNode<>(e, null, tail);
        if (tail != null) {
            tail.next = temp;
        }
        tail = temp;
        if (head == null) {
            head = temp;
        }
        size++;
        System.out.println("Adding: " + e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0) {
            addFirst(e);
        }
        else if (index == size) {
            addLast(e);
        }
        else {
            DNode<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            DNode<E> insert = new DNode<>(e, temp, temp.prev);
            temp.prev.next = insert;
            temp.prev = insert;
            size++;
            System.out.println("Adding: " + e);
        }
    }

    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        DNode<E> temp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("Deleted: " + temp.element);
        return temp.element;
    }

    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        DNode<E> temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("Deleted: " + temp.element);
        return temp.element;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0) {
            return removeFirst();
        }
        else if (index == size - 1) {
            return removeLast();
        }
        else {
            DNode<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            E element = current.element;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.prev = null;
            current.next = null;
            size--;
            System.out.println("Deleted: " + element);
            return element;
        }
    }

    public void traverseForward() {
        System.out.println("Iterating forward..");
        DNode<E> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void traverseBackward() {
        System.out.println("Iterating backward..");
        DNode<E> current = tail;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        int count = 0;
        DNode<E> temp;
        while (head != null) {
            temp = head.next;
            head.next = head.prev = null;
            head = temp;
            count++;
        }
        tail.next = tail.prev = null;
        size = 0;
        System.out.println("Successfully clear " + count + " node(s)");
    }
}
