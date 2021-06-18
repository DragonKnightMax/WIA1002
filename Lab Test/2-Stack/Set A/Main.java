public class Main {
    public static void main(String[] args) {
        //---------------- Part A ----------------
        Stack raw = new Stack("Raw list");
        raw.push("ali",32,"m","doctor");
        raw.push("lisa",29,"f","nurse");
        raw.push("tanaka",41);
        raw.push("ahmad",18,"m","developer");
        raw.push("maria",20,"f","accountant");
        raw.push("chong",70,"m","lawyer");
        raw.push("raju",55,"m","police");
        raw.push("alex",16,"f","business man ");
        Person katie = new Person("katie",36,"f","teacher");
        raw.push(katie);
        raw.displayStack();


        //--------------- Part B ---------------
        Stack frontliners = new Stack("Frontliners");
        Stack others = new Stack("Others");

        System.out.println("\n~~~~~~Sort into frontliners and others~~~~~~\n");
        while (!raw.isEmpty()) {
            Person personToCheck = raw.pop();
            if (personToCheck.getFrontliner()) {
                frontliners.push(personToCheck);
            }
            else {
                others.push(personToCheck);
            }
        }
        raw.displayStack();
        frontliners.displayStack();
        others.displayStack();


        //--------------- Part C ---------------
        Stack priority = new Stack("Vaccine Priority List");
        System.out.println("\n~~~~~Sort into vaccine list~~~~~\n");

        sortStack(frontliners, others, priority);

        others.displayStack();
        frontliners.displayStack();
        priority.displayStack();
    }

    /**
     * Sort the people to get vaccinated according to their priority in ascending order.
     *
     * Criteria:
     * - Frontliner has higher priority than non-frontliner
     * - The higher the age of a person, the higher the priority
     */
    public static void bubbleSort(Person[] people) {
        boolean nextPass = true;
        for (int p = 1; p < people.length && nextPass; p++) {
            nextPass = false;
            for (int i = 0; i < people.length - p; i++) {
                if (people[i].compareTo(people[i + 1]) > 0) {
                    // Swap people[i] and people[i + 1]
                    Person temp = people[i];
                    people[i] = people[i + 1];
                    people[i + 1] = temp;
                    nextPass = true;
                }
            }
        }
    }

    /**
     * Sort the frontliners and others into a priority stack
     */
    public static void sortStack(Stack frontliners, Stack others, Stack priority) {
        Person[] sortOthers = new Person[others.getSize()];
        Person[] sortFrontliners = new Person[frontliners.getSize()];

        // load others into array
        int index = 0;
        while (!others.isEmpty()) {
            sortOthers[index++] = others.pop();
        }

        // load frontliners into array
        index = 0;
        while (!frontliners.isEmpty()) {
            sortFrontliners[index++] = frontliners.pop();
        }

        bubbleSort(sortOthers);
        bubbleSort(sortFrontliners);

        // Push others into priority stack
        for (Person p : sortOthers) {
            priority.push(p);
        }

        // Push frontliners into priority stack
        for (Person p : sortFrontliners) {
            priority.push(p);
        }
    }
}
