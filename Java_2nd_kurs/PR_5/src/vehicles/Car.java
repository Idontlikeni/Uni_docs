package vehicles;

public class Car extends Vehicle {
    public Car(){
        this.ownerName = "Tim";
        this.insuranceNumber = 88;
        this.engineType = "Combustion";
    }

    public Car(String ownerName, int insuranceNumber, String engineType) {
        super(ownerName, insuranceNumber, engineType);
    }

    @Override
    public String vehicleType() {
        return "Car";
    }

}