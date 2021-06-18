public class Exponent {

    public static void main(String[] args) {
        System.out.println(exponent(10, 3));
        System.out.println(exponent(2, 8));
        System.out.println(exponent(5, 3));
    }

    public static long exponent(int x, int m) {
        // Base case
        if (m == 0) {
            return 1;
        }
        // Recursive case
        return (x * exponent(x, --m));
    }
}
