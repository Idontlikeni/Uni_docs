import java.lang.Comparable;

public abstract class GeometricObject implements Comparable<GeometricObject>{
    private String color = "белый";
    private boolean filled;
    private java.util.Date dateCreated;

    /** Создает по умолчанию заданный геометрический объект */
    public GeometricObject() {
        dateCreated = new java.util.Date();
    }

    /** Создает геометрический объект с указанным цветом и заливкой */
    public GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    /** Возвращает цвет */
    public String getColor() {
        return color;
    }

    /** Присваивает новый цвет */
    public void setColor(String color) {
        this.color = color;
    }

    /** Возвращает заливку. Поскольку filled типа boolean,
     *  getter-метод называется isFilled */
    public boolean isFilled() {
        return filled;
    }
    public abstract double getArea();
    /** Присваивает новую заливку */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /** Получает dateCreated */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    /** Возвращает строковое представление этого объекта */
    public String toString() {
        return "создан " + dateCreated + ",\nцвет: " + color +
                ", заливка: " + filled;
    }

    static GeometricObject max(GeometricObject a, GeometricObject b){
        if(a.compareTo(b) >= 0)return a;
        else return b;
    }

    @Override
    public int compareTo(GeometricObject o) {
        if(this.dateCreated.after(o.getDateCreated())) return 1;
        if(this.dateCreated.before(o.getDateCreated())) return -1;
        return 0;
    }
}