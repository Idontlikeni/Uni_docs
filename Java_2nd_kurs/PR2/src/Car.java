//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Car{
    String model;
    String license;
    String color;
    int year;
    public Car(String _model, String _license, String _color, int _year){
        model = _model;
        license = _license;
        color = _color;
        year = _year;
    }
    public Car(){
        model = "";
        license = "";
        color = "";
        year = 0;
    }
    public Car(String model, int year){
        this.model = model;
        this.year = year;
        color = "grey";
        license = "default";
    }

    @Override
    public String toString(){
        return("model: " + model + "; year: " + year  + "; color: " + color + "; license: " +  license);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCarAge(){
        return 2024 - this.year;
    }
}
