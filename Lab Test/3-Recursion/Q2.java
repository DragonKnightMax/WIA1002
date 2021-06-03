public class Q2 {

    public static void main(String[] args) {
        System.out.println("Mesh Topology");
        display(4);
        display(7);
    }

    // Helper method to display the total number of connections
    public static void display(int switches) {
        System.out.printf("There are %d switches in the campus.\n", switches);
        System.out.println("The total number of connections required is " + connections(switches));
    }

    // Recursive method to calculate total number of connections required for n switches in campus
    public static int connections(int switches) {
        // Base case
        if (switches <= 1) {
            return 0;
        }
        // Recursive case: c = (n - 1) + (n - 2) + ... + 0
        return (switches - 1) + connections(switches - 1);
    }
}
