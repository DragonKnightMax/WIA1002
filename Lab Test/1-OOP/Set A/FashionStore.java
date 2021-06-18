import java.util.ArrayList;

public class FashionStore extends ShopLot implements Comparable<FashionStore> {
    private ArrayList<Item> clothes;

    public FashionStore(String shopName, Person contactPerson) {
        super(shopName, contactPerson);
        this.clothes = new ArrayList<>();
    }

    public void addClothes(String clothesName, int clothesPrice) {
        clothes.add(new Item(clothesName, clothesPrice));
    }

    @Override
    public int compareTo(FashionStore fashionStore) {
        if (super.getNumOfEmployees() > fashionStore.getNumOfEmployees())
            return 1;
        else if (super.getNumOfEmployees() < fashionStore.getNumOfEmployees())
            return -1;
        return 0;
    }

    @Override
    public ArrayList<Item> getItems() {
        return clothes;
    }
}
