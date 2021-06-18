public class Test {
    public static void main(String[] args) {
        MyGeneric<String> strObj = new MyGeneric<>();
        strObj.setE("Hello");
        System.out.println(strObj.getE());

        MyGeneric<Integer> intObj = new MyGeneric<>();
        intObj.setE(5);
        System.out.println(intObj.getE());
    }
}
