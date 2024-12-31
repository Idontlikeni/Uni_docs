public class Square extends GeometricObject implements Colorable{
    private double side1;

    public Square(){
        this.side1 = 0.0;
    }

    public Square(double side1) {
        this.side1 = side1;
    }

    public Square(String color, boolean filled, double side1) {
        super(color, filled);
        this.side1 = side1;
    }

    public double getArea(){
        return side1 * side1;
    }

    public double getPerimetr(){
        return 4 * side1;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    @Override
    public void howToColor() {
        System.out.println("Раскрастье все четыре стороны");
    }
}
