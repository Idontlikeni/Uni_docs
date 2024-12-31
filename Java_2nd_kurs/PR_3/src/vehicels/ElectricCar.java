package vehicels;

public class ElectricCar extends Car{
    double batteryCapacity;
    public ElectricCar(){
        engineType = "Electric";
    }

    public ElectricCar(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public ElectricCar(String ownerName, int insuranceNumber, String engineType, double batteryCapacity) {
        super(ownerName, insuranceNumber, engineType);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String vehicleType() {
        return "electric Car";
    }
}
