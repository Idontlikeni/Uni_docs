import java.util.ArrayList;

public class Main {
    static<T extends Comparable<T>> T find_max(T[]a){
        T mx = a[0];
        for (int i = 0; i < a.length; i++) {
            if(a[i].compareTo(mx) > 0)mx = a[i];
        }
        return mx;
    }

    public static void main(String[] args) {
        Circle[] arr = {new Circle(5.5), new Circle(5.0), new Circle(8.0)};
        System.out.println(find_max(arr).toString());
        GenericStack<String> stack = new GenericStack<String>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.toString());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.toString());
        ArrayStack<String>st = new ArrayStack<String>();
        st.push("1");
        st.push("2");
        st.push("3");
        st.push("4");
        st.push("5");
        for (int i = 0; i < 5; i++) {
            System.out.println(st.pop());
        }
    } 
}