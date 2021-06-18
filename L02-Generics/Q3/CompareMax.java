public class CompareMax {
    
    public static void main(String[] args) {
        System.out.println(maximum("a", "b", "c"));
        System.out.println(maximum("a", "a", "b"));

        System.out.println(maximum(2, 2, 1));
        System.out.println(maximum(2, 1, 2));
        System.out.println(maximum(1, 2, 2));
        System.out.println(maximum(1, 1, 1));
        System.out.println(maximum(1, 2, 3));
        System.out.println(maximum(3, 2, 1));
        System.out.println(maximum(2, 3, 1));
    }

    public static <T extends Comparable<T>> T maximum(T a, T b, T c) {
        if (a.compareTo(b) >= 0 && a.compareTo(c) >= 0)
            return a;
        else if (b.compareTo(a) >= 0 && b.compareTo(c) >= 0)
            return b;
        else
            return c;
    }
}
