import java.util.Arrays;

public class Person implements Comparable<Person> {
    private final String name, gender, occupation;
    private final int age;
    private final static String[] occupation_list = {"doctor", "nurse", "teacher", "police"};
    private boolean frontliner;

    public Person(String name, int age) {
        this(name, age, null, null);
    }

    public Person(String name, int age, String gender, String occupation) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        setFrontliner();
    }

    public int getAge() {
        return age;
    }

    public boolean getFrontliner() {
        return this.frontliner;
    }

    public void setFrontliner() {
        this.frontliner = isFrontliner();
    }

    public boolean isFrontliner() {
        for (String o : occupation_list) {
            if (o.equals(this.occupation)) {
                return true;
            }
        }
        return false;
    }

    public int compareTo(Person p) {
        return Integer.compare(this.getAge(), p.getAge());
    }

    @Override
    public String toString() {
        return String.format("%s %d %s %s\n", name, age, gender, isFrontliner() ? "Frontliner" : "Not frontliner");
    }

}
