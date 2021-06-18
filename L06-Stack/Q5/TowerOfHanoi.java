import java.util.Scanner;
import java.util.Stack;

/*
  NUmber of disks = n
  Number of moves = 2^n - 1
 
  S - source
  A - auxiliary
  D - destination
 
  If n is odd
    | | |
    S A D
  else
    | | |
    S D A
 */
public class TowerOfHanoi {
    static Stack<Disk> source;
    static Stack<Disk> auxiliary;
    static Stack<Disk> destination;
    static int disks;

    public static void main(String[] args) {
        source = new Stack<>();
        auxiliary = new Stack<>();
        destination = new Stack<>();

        // prompt users for number of disks
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of disk(s): ");
        disks = scanner.nextInt();

        // swap D and A poles when number of disks is even
        if (disks % 2 == 0) {
            Stack<Disk> temp = destination;
            destination = auxiliary;
            auxiliary = temp;
        }

        // add disks to the source rod
        for (int i = disks; i > 0; i--) {
            source.push(new Disk(i));
        }

        // determine total number of moves required to get solution
        int moves = (int) Math.pow(2, disks) - 1;

        for (int i = 1; i <= moves; i++) {
            if (i % 3 == 1) { // S <-> D
                moveDisksBetween(source, destination);
            }
            else if (i % 3 == 2) { // S <-> A
                moveDisksBetween(source, auxiliary);
            }
            else if (i % 3 == 0) { // A <-> D
                moveDisksBetween(auxiliary, destination);
            }
            display();
        }
    }

    public static void moveDisksBetween(Stack<Disk> src, Stack<Disk> dest) {
        Disk srcPoleTopDisk = null;
        Disk destPoleTopDisk = null;

        if (!src.isEmpty()) {
            srcPoleTopDisk = src.pop();
        }
        if (!dest.isEmpty()) {
            destPoleTopDisk = dest.pop();
        }

        // source pole is empty
        if (srcPoleTopDisk == null) {
            src.push(destPoleTopDisk);
        }
        // destination pole is empty
        else if (destPoleTopDisk == null) {
            dest.push(srcPoleTopDisk);
        }
        // src pole top disk > dest pole top disk
        else if (srcPoleTopDisk.getSize() > destPoleTopDisk.getSize()) {
            // add the disk back to the original pole
            src.push(srcPoleTopDisk);
            // move from dest to src
            src.push(destPoleTopDisk);
        }
        // src pole top disk < dest pole top disk
        else {
            dest.push(destPoleTopDisk);
            dest.push(srcPoleTopDisk);
        }
    }

    public static void display() {
        System.out.println(" A | B | C");
        System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐");
        for(int i = disks - 1; i >= 0; i--) {
            String d1 = " ", d2 = " ", d3 = " ";
            try {
                d1 = String.valueOf(source.get(i));
            }
            catch (Exception e) {}

            try {
                d2 = String.valueOf(auxiliary.get(i));
            }
            catch (Exception e) {}

            try {
                d3 = String.valueOf(destination.get(i));
            }
            catch (Exception e) {}

            System.out.println(" " + d1 + " | " + d2 +" | "+ d3);
        }
        System.out.println("\n");

        Scanner sc = new Scanner(System.in);
        System.out.println("Press 'Enter' to continue!");
        sc.nextLine();
    }
}