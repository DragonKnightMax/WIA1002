import java.util.ArrayList;

public class ShoppingMall {

    public static void main(String[] args) {
        //--------------------------- FoodStore ---------------------------

        // McDonalds
        FoodStore mcDonalds = new FoodStore("McDonalds", new Person("Mike", "0101122334"));
        mcDonalds.addMenu("Burger", 10);
        mcDonalds.addMenu("Fried Chicken", 12);
        String[] mcDonaldsEmployees = {"Jack", "Jane"};
        mcDonalds.addEmployee(mcDonaldsEmployees);

        // Sushi Mentai
        FoodStore sushiMentai = new FoodStore("Sushi Mentai", new Person("Max", "0112233445"));
        sushiMentai.addMenu("Chicken Katsu Don", 15);
        sushiMentai.addMenu("Ramen", 12);
        String[] sushiMentaiEmployees = {"Adam", "Alex", "Andrew"};
        sushiMentai.addEmployee(sushiMentaiEmployees);

        // Warong Penyet
        FoodStore waroengPenyet = new FoodStore("Waroeng Penyet", new Person("Mike", "0101122334"));
        waroengPenyet.addMenu("Burger", 10);
        waroengPenyet.addMenu("Fried Chicken", 12);
        String[] waroengPenyetEmployees = {"Lex", "Leon"};
        waroengPenyet.addEmployee(waroengPenyetEmployees);

        FoodStore[] foodStores = {mcDonalds, sushiMentai, waroengPenyet};

        //--------------------------- FashionStore ---------------------------

        // Uniqlo
        FashionStore uniqlo = new FashionStore("Uniqlo", new Person("Nate", "0199988776S"));
        uniqlo.addClothes("Shirt", 80);
        uniqlo.addClothes("T-shirt", 60);
        String[] uniqloEmployees = {"Kate", "Ken", "Kurt"};
        uniqlo.addEmployee(uniqloEmployees);

        FashionStore padini = new FashionStore("Padini", new Person("Nick", "0195544332"));
        padini.addClothes("Blouse", 100);
        padini.addClothes("Skirt", 80);
        String[] padiniEmployees = {"Frank", "Felix"};
        padini.addEmployee(padiniEmployees);

        FashionStore mango = new FashionStore("Mango", new Person("Nicole", "0194433221"));
        mango.addClothes("Dress", 120);
        String[] mangoEmployees = {"Ron", "John"};
        mango.addEmployee(mangoEmployees);

        FashionStore[] fashionStores = {uniqlo, padini, mango};

        //------------------- Testing -------------------

        // 1
        System.out.println(sushiMentai + "\n");
        System.out.println(mango + "\n");

        // 2
        System.out.println("Food store with the highest number of employees: " + getHighestEmployees(foodStores));
        System.out.println("Fashion store with the highest number of employees: " + getHighestEmployees(fashionStores));
        System.out.println();

        // 3
        String result = "different";
        if (mcDonalds.equals(sushiMentai)) {
            result = "the same";
        }
        System.out.println("The contact person for McDonalds and Sushi Mentai is " + result);

        result = "different";
        if (mcDonalds.equals(waroengPenyet)) {
            result = "the same";
        }
        System.out.println("The contact person for McDonalds and Waroeng Penyet is " + result);

        result = "different";
        if (sushiMentai.equals(waroengPenyet)) {
            result = "the same";
        }
        System.out.println("The contact person for Sushi Mentai and Waroeng Penyet is " + result);
        System.out.println();

        // 4
        if (sushiMentai.compareTo(waroengPenyet) > 0) {
            System.out.println("Sushi Mentai have more employees than Waroeng Penyet");
        }
        else if (sushiMentai.compareTo(waroengPenyet) < 0) {
            System.out.println("Waroeng Penyet have more employees than Sushi Mentai");
        }
        else {
            System.out.println("Sushi Mentai have the same number of employees as Waroeng Penyet");
        }
        System.out.println();
        
        // 5
        System.out.println("The most expensive item in McDonalds is " + getMostExpensiveItem(mcDonalds));
        System.out.println("The most expensive item in Padini is " + getMostExpensiveItem(padini));
    }

    public static <E extends ShopLot> String getHighestEmployees(E[] shoplot) {
        int maxIndex = 0;
        int maxEmployees = 0;
        for (int i = 0; i < shoplot.length; i++) {
            int employees = shoplot[i].getNumOfEmployees();
            if (employees > maxEmployees) {
                maxIndex = i;
                maxEmployees = employees;
            }
        }
        return shoplot[maxIndex].getName();
    }

    public static <E extends ShopLot> String getMostExpensiveItem(E shoplot) {
        ArrayList<Item> items = shoplot.getItems();
        int maxIndex = 0;
        int maxPrice = 0;
        for (int i = 0; i < items.size(); i++) {
            int price = items.get(i).getPrice();
            if (price > maxPrice) {
                maxIndex = i;
                maxPrice = price;
            }
        }
        return items.get(maxIndex).getName();
    }

    public static String findFoodStoreNameWithHighestEmployees(FoodStore[] foodStores) {
        FoodStore max = foodStores[0];
        for (int i = 1; i < foodStores.length; i++) {
            if (foodStores[i].compareTo(max) > 0) {
                max = foodStores[i];
            }
        }
        return max.getName();
    }

    public static String findFashionStoreNameWithHighestEmployess(FashionStore[] fashionStores) {
        FashionStore max = fashionStores[0];
        for (int i = 1; i < fashionStores.length; i++) {
            if (fashionStores[i].compareTo(max) > 0) {
                max = fashionStores[i];
            }
        }
        return max.getName();
    }
}
