package Lab.L2.Q6;

public class MinMaxTwoDArray {
    
    public static void main(String[] args) {
        Integer[][] numbers = {{4, 5, 6}, {1, 2, 3}};
        System.out.println("Min = " + min(numbers));
        System.out.println("Max = " + max(numbers));
    }

    public static <E extends Comparable<E>> E min(E[][] list) {
        E minimum = list[0][0];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j].compareTo(minimum) < 0) {
                    minimum = list[i][j];
                }
            }
        }
        return minimum;
    }

    public static <E extends Comparable<E>> E max(E[][] list) {
        E maximum = list[0][0];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j].compareTo(maximum) > 0) {
                    maximum = list[i][j];
                }
            }
        }
        return maximum;

    }
}
