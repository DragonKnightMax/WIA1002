package Lab.L2.Q5;

public class FindMax {

    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3};
        String[] strArr = {"red", "green", "blue"};
        Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};

        System.out.println(max(intArr));
        System.out.println(max(strArr));
        System.out.println(max(circles));
    }

    public static <E extends Comparable<E>> E max(E[] list) {
        E maximum = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i].compareTo(maximum) > 0) {
                maximum = list[i];
            }
        }
        return maximum;
    }
}