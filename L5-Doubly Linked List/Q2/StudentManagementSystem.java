import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        System.out.println("Enter your student name list. Enter 'n' to end.....");
        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("n")) {
                break;
            }
            singlyLinkedList.add(input);
        }

        System.out.println("\nYou have entered the following students' name :");
        singlyLinkedList.printList();

        System.out.println("\nThe number of students entered is : " + singlyLinkedList.getSize());

        while (true) {
            System.out.println("\nAll the names entered are correct? Enter 'r' to rename the student name, 'n' to proceed");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("r")) {
                System.out.println("\nEnter the existing student name that u want to rename :");
                String oldName = scanner.nextLine();

                if (singlyLinkedList.contains(oldName)) {
                    System.out.println("\nEnter the new name :");
                    String newName = scanner.nextLine();
                    singlyLinkedList.replace(oldName, newName);
                }
                else {
                    System.out.println("Student name does not exist! Please enter another name!");
                }
            }
            else if (input.equalsIgnoreCase("n")) {
                break;
            }
            else {
                System.out.println("Invalid Input! Enter 'r' or 'n' only!");
            }
        }
        System.out.println("\nThe new student list is :");
        singlyLinkedList.printList();

        while (true) {
            System.out.println("\nDo you want to remove any of your student name? Enter 'y' for yes, 'n' to proceed.");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("y")) {
                System.out.println("\nEnter a student name to remove :");
                String nameToRemove = scanner.nextLine();
                if (singlyLinkedList.contains(nameToRemove)) {
                    singlyLinkedList.removeElement(nameToRemove);
                }
                else {
                    System.out.println("Student name does not exist! Please enter another name!");
                }
            }
            else if (input.equalsIgnoreCase("n")) {
                break;
            }
            else {
                System.out.println("Invalid Input! Enter 'y' for yes and 'n' for no!");
            }
        }

        System.out.println("\nThe number of updated student is :" + singlyLinkedList.getSize());

        System.out.println("The updated students list is :");
        singlyLinkedList.printList();

        System.out.println("\nAll the student data captured complete. Thank you!");
    }
}
