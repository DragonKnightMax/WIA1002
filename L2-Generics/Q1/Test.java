public class Test {
    public static void main(String[] args) {
        StorePair<Integer> a = new StorePair<>(6, 4);
        StorePair<Integer> b = new StorePair<>(2, 2);
        StorePair<Integer> c = new StorePair<>(6, 3);

        if (a.compareTo(b) > 0 && a.compareTo(c) > 0) {
            System.out.println(a);
        } else if (b.compareTo(a) > 0 && b.compareTo(c) > 0) {
            System.out.println(b);
        } else if (c.compareTo(a) > 0 && c.compareTo(b) > 0) {
            System.out.println(c);
        }
        
        System.out.println("a == b : " + a.equals(b));
        System.out.println("b == c : " + b.equals(c));
        System.out.println("a == c : " + a.equals(c));
    }
}
