import java.util.ArrayList;

public class Stack {
    private final String stack_name;
    private final ArrayList<Person> list;

    public Stack(String stack_name) {
        this.stack_name = stack_name;
        this.list = new ArrayList<>();
    }

    public void push(String name, int age) {
        list.add(new Person(name, age));
    }

    public void push(String name, int age, String gender) {
        list.add(new Person(name, age, gender, null));
    }

    public void push(String name, int age, String gender, String occupation) {
        list.add(new Person(name, age, gender, occupation));
    }

    public void push(Person person) {
        list.add(person);
    }

    public Person pop() {
        return list.remove(this.getSize() - 1);
    }

    public Person peek() {
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

    public boolean search(Person o) {
        return list.contains(o);
    }

    public void displayStack() {
        System.out.println("----" + this.stack_name + "----\n");
        if (isEmpty()) {
            System.out.println("Empty stack\n");
        }
        else {
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.println(i + " " + list.get(i));
            }
        }
        System.out.println("----------------------\n");
    }
}

