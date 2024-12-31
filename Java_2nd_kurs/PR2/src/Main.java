public class Main {
    public static void main(String[] args) {
        Car fiat = new Car("Fiat", "License", "yellow", 1970);
        Car ford = new Car("Fiat", 1984);
        Car def = new Car();
        System.out.println(fiat.toString());
    }
}