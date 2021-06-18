public class SubstituteAI {

    public static void main(String[] args) {
        System.out.println(substituteAI("flabbergasted"));
        System.out.println(substituteAI("Astronaut"));
    }

    public static String substituteAI(String word) {
        // base case: string length == 0
        if (word.length() < 1) {
            return "";
        }
        // Recursive case
        char letter = word.charAt(0);
        String remaining = word.substring(1);  // slice the string
        if (letter == 'a') {
            return "i" + substituteAI(remaining);
        }
        return letter + substituteAI(remaining);
    }
}
