package SList;

public class TestSList {

    public static void main(String[] args) {
        SList<String> sList = new SList<>();

        // Append the following values individually: “Linked list, is, easy.”
        sList.appendEnd("Linked list");
        sList.appendEnd("is");
        sList.appendEnd("easy");

        // Display these values.
        sList.display();

        // Remove the word “Linked list” and display the removed value.
        System.out.println("Removed value: " + sList.removeInitial());

        // Check if ‘difficult’ is in the list.
        System.out.println("'difficult' in list: " + sList.contains("difficult"));

        // Clear the list.
        sList.clear();
        System.out.println("After clearing list:");
        sList.display();
    }
}
