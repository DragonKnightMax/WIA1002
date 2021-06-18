import java.util.ArrayList;

public class ShopLot {
    private String name;
    private Person contactPerson;
    private final ArrayList<Person> employees;

    public ShopLot(String name, Person contactPerson) {
        this.name = name;
        this.contactPerson = contactPerson;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Person getContactPerson() {
        return contactPerson;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactPerson(Person contactPerson) {
        this.contactPerson = contactPerson;
    }

    public int getNumOfEmployees() {
        return employees.size();
    }

    public void addEmployee(String[] employees) {
        for (String e : employees) {
            this.employees.add(new Person(e, null));
        }
    }

    public ArrayList<Item> getItems() {
        return null;
    };

    @Override
    public String toString() {
        return "ShopLot{" +
                "shopName='" + name + '\'' +
                ", contact=" + contactPerson +
                ", employees=" + employees +
                '}';
    }
}
