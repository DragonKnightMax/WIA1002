public class Permutation {

    public static void main(String[] args) {
        permuteString("", "DOG");
    }

    public static void permuteString(String beginningString, String endingString) {
        // See the process
        //System.out.println(beginningString + ", " + endingString);

        // Base case
        if (endingString.length() <= 1) {
            System.out.println(beginningString + endingString);
        }
        // Recursive case
        else {
            for (int i = 0; i < endingString.length(); i++) {
                String newString = endingString.substring(0, i) + endingString.substring(i + 1);
                permuteString(beginningString + endingString.charAt(i), newString);
            }
        }
    }
}
