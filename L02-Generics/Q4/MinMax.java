public class MinMax {
    
    public static void main(String[] args) {
        Integer[] intArray = {5, 3, 7, 1, 4, 9, 8, 2};
        String[] strArray = {"red", "blue", "orange", "tan"};

        System.out.println(minmax(intArray));
        System.out.println(minmax(strArray));
    }

    public static <T extends Comparable<T>> String minmax(T[] arr) {
        T min = arr[0];
        T max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            T item = arr[i];

            if (item.compareTo(max) > 0) {
                max = item;
            }
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return String.format("Min = %s Max = %s", min, max);
    }
}