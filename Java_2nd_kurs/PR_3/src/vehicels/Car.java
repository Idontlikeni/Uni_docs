package vehicels;

public class Car extends Vehicle {
    public Car(){
        this.ownerName = "Tim";
        this.insuranceNumber = 88;
        this.engineType = "diesel";
    }

    public Car(String ownerName, int insuranceNumber, String engineType) {
        super(ownerName, insuranceNumber, engineType);
    }

    public String getownerName() {
        return ownerName;
    }

    public void setownerName(String ownerName) {
        ownerName = ownerName;
    }

    @Override
    public String vehicleType() {
        return "Car";
    }

    @Override
    public String toString(){
        return("model: " + getModel() + "; year: " + getYear()  + "; color: " + getColor() + "; license: " +  getLicense());
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(int insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
}
