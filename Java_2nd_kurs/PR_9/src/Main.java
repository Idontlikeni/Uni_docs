import java.util.ArrayList;

public class Main {
    static<T> ArrayList<T> meth(ArrayList<T> a){
        ArrayList<T> temp = new ArrayList<>();
        for(T i: a){
            if(!temp.contains(i))temp.add(i);
        }
        return temp;
    }

    static<T> int find(T[] a, T p){
        for (int i = 0; i < a.length; i++) {
            if(a[i] == p)return i;
        }
        return -1;
    }

    static<T extends Comparable<T>> T find_max(T[]a){
        T mx = a[0];
        for (int i = 0; i < a.length; i++) {
            if(a[i].compareTo(mx) > 0)mx = a[i];
        }
        return mx;
    }

    static<T extends Comparable<T>> T find_max(T[][]a){
        T mx = a[0][0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if(a[i][j].compareTo(mx) > 0)mx = a[i][j];
            }
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