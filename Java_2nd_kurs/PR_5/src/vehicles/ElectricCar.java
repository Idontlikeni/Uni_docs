package vehicles;

public class ElectricCar extends Car implements ElectricVehicle{
    private int batteryCapacity;

    public ElectricCar(){
        this.ownerName = "Tim";
        this.insuranceNumber = 57;
        this.engineType = "Electric";
    }

    @Override
    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public void setBatteryCapacity(int capacity) {
        batteryCapacity = capacity;
    }
}
