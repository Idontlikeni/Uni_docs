package app;

import vehicles.*;
public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        ElectricCar e = new ElectricCar();
        c.setYear(1980);
        e.setInsuranceNumber(101);
        e.setBatteryCapacity(1000);
        System.out.println(e.getBatteryCapacity());
        System.out.println(c);
        System.out.println(e);
    }
}