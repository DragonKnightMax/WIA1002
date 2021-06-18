import java.util.ArrayList;

public class MyStack<E> {
    private ArrayList<E> list;

    public MyStack() {
        list = new ArrayList<>();
    }

    public void push(E o) {
        list.add(o);
    }

    public E pop() {
        return list.remove(this.getSize() - 1);

    }

    public E peek() {
        return list.get(0);
    }

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "list=" + list.toString() +
                '}';
    }

    public boolean search(E o) {
        return list.contains(o);
    }
}
