import java.awt.*;
import java.util.Scanner;

public class TestCircleRectangle {
    public static void main(String[] args) throws IllegalTriangleException {
        // Задание 1
        Scanner s = new Scanner(System.in);
        System.out.println("Введите стороны треугольника, его цвет и закрашен ли он");
        double s1, s2, s3;
        s1 = s.nextDouble();
        s2 = s.nextDouble();
        s3 = s.nextDouble();
        String color = s.next();
        boolean filled = s.nextBoolean();
        Triangle t = new Triangle(s1, s2, s3);
        t.setColor(color);
        t.setFilled(filled);
        System.out.println(t.toString() + t.getArea() + t.getPerimeter() + t.getColor() + t.isFilled());
        // Задание 3
        ComparableCircle cc1 = new ComparableCircle(10.0);
        ComparableCircle cc2 = new ComparableCircle(12.0);

        Circle c = new Circle(10.0);

        System.out.println(cc1.toString() + cc2.toString() + cc1.compareTo(cc2) + c.compareTo(t));

        //Задание 4
        GeometricObject[] arr = {new Circle(10.0), new ComparableCircle(2.0), new Triangle(3, 4, 5), new Square(10), new Rectangle(10, 20)};
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i].getArea());
            if(arr[i] instanceof Colorable)((Colorable) arr[i]).howToColor();
        }
    }
}