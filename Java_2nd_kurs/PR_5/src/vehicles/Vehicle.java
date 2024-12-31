package vehicles;

public abstract class Vehicle {
    private String model;
    private String license;
    private String color;
    private int year;
    protected String ownerName;
    protected int insuranceNumber;
    protected String engineType;

    public Vehicle(){}

    public Vehicle(String ownerName, int insuranceNumber, String engineType) {
        this.insuranceNumber = insuranceNumber;
        this.ownerName = ownerName;
        this.engineType = engineType;
    }

    public abstract String vehicleType();

    @Override
    public String toString() {
        return "Vehicle: " +
                "model='" + model + '\'' +
                ", license='" + license + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", ownerName='" + ownerName + '\'' +
                ", insuranceNumber=" + insuranceNumber +
                ", engineType='" + engineType + '\'' +
                '|';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
