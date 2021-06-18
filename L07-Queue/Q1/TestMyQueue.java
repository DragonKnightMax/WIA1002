public class TestMyQueue {

    public static void main(String[] args) {
        String[] fruits = {"Durian", "Blueberry"};
        MyQueue<String> fruitQ = new MyQueue<>(fruits);

        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");


        System.out.println("Content of the queue: " + fruitQ);

        System.out.println("Top item: " + fruitQ.peek());

        System.out.println("Queue size: " + fruitQ.getSize());

        System.out.println("Deleted: " + fruitQ.dequeue());

        System.out.println("Item at index position 2: " + fruitQ.getElement(2));

        System.out.println("Queue consists of cherry: " + fruitQ.contains("Cherry"));

        System.out.println("Queue consists of durian: " + fruitQ.contains("Durian"));

        System.out.println("Content of queue: ");
        while (!fruitQ.isEmpty()) {
            System.out.print(fruitQ.dequeue() + " ");
        }
        System.out.println();

    }
}
