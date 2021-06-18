public class MyLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    private int size;

    public MyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public void addFirst(E e) {
        Node<E> temp = new Node<>(e);
        temp.next = head;
        head = temp;
        size++;
        if (tail == null) {
            tail = head;
        }
    }

    public void addLast(E e) {
        if (size == 0) {
            head = tail = new Node<>(e);
        }
        else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        }
        else if (index >= size) {
            addLast(e);
        }
        else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        else {
            Node<E> temp = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return temp.element;
        }
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        }
        else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }
        else {
            Node<E> current = head;
            for (int i = 1; i < size - 1; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        else if (index == 0) {
            return removeFirst();
        }
        else if (index == size - 1) {
            return removeLast();
        }
        else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }



    //Return nothing, but adds an element to the list
    public void add(E e) {
        addLast(e);
    }

    // Return true if list contains the element e
    public boolean contains(E e) {
        boolean found = false;
        Node<E> current = head;
        while (!found && current != null) {
            if ((current.element).equals(e)) {
                found = true;
            }
            current = current.next;
        }
        return found;
    }

    // Return element at the specified index
    public E get(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    // Return the value of the first item
    public E getFirst() {
        if (head == null) {
            return null;
        }
        return head.element;
    }

    // Return the value of the last item
    public E getLast() {
        if (tail == null) {
            return null;
        }
        return tail.element;
    }

    // Return the index of the head matching element in this list.
    // Return -1 of no match
    public int indexOf(E e) {
        int index = -1;
        Node<E> current = head;
        if (current != null) {
            for (int i = 0; i < size; i++) {
                if ((current.element).equals(e)) {
                    index = i;
                    break;
                }
                current = current.next;
            }
        }
        return index;
    }

    // Return the index of the last matching element in this list.
    // Return -1 of no match
    public int lastIndexOf(E e) {
        int index = -1;
        Node<E> current = head;
        if (current != null) {
            for (int i = 0; i < size; i++) {
                if (current.element.equals(e)) {
                    index = i;
                }
                current = current.next;
            }
        }
        return index;
    }

    // Replace the element at the specified position in this list with the specified element
    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> current = head;
        if (current == null) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E temp = current.element;
        current.element = e;
        return temp;
    }

    // Clear the list
    public void clear() {
        while (size > 0) {
            removeLast();
        }
    }

    // Print all the elements in the list
    public void print() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Print all elements in reverse order
    public void reverse() {
        Node<E> current = head;
        Node<E> last = null;
        while (last != head) {
            while (current.next != last) {
                current = current.next;
            }
            // store current element as new last
            last = current;
            System.out.print(last.element + " ");
            // reset current back to head
            current = head;
        }
        System.out.println();
    }

    // Q2
    public E getMiddleValue() {
        int middle = size / 2;
        Node<E> current = head;
        for (int i = 0; i < middle; i++) {
            current = current.next;
        }
        return current.element;
    }
}
