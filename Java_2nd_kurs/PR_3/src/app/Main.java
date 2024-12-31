package app;

import vehicels.*;

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        ElectricCar e = new ElectricCar();
        c.setColor("Green");
        e.setYear(2020);
        System.out.println(c.toString());
        System.out.println(e.toString());
    }
}