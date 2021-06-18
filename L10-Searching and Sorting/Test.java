public class Test {

    public static void main(String[] args) {
        int[] arr = {45, 7, 2, 8, 19, 3};

        // Q1
        L10Q1 result1 = new L10Q1();
        result1.selectionSortSmallest(arr);

        System.out.println("selectionSortSmallest(int[] arr)");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Q2
        L10Q2 result2 = new L10Q2();
        result2.selectionSortLargest(arr);

        System.out.println("selectionSortLargest(int[] arr)");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
