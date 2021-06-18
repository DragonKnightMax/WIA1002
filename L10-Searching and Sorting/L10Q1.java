public class L10Q1 {

    public void selectionSortSmallest(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int currentSmallestIndex = i;
            int currentSmallest = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < currentSmallest) {
                    currentSmallestIndex = j;
                    currentSmallest = arr[j];
                }
            }

            if (currentSmallestIndex != i) {
                arr[currentSmallestIndex] = arr[i];
                arr[i] = currentSmallest;
            }
        }
    }
}
