import java.util.ArrayList;

public class MyStack2<E> extends ArrayList<E> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();
    public int getSize() {
        return list.size();
    }
    public E peek() {
        return list.get(getSize() - 1);
    }
    public void push(E o) {
        list.add(o);
    }
    public E pop() {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }
}