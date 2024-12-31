import java.util.Arrays;

public class GenericStack<E> {
    private E[] List;
    int last = -1;
    public int getSize() {
        return List.length;
    }
    public E peek() {
        return List[last];
    }
    public void push(E o) {
        last++;
        if(last == List.length){
            List = Arrays.copyOf(List, List.length * 2);
        }
        List[last] = o;
    }
    public E pop() {
        E o = List[last];
        E[]temp = (E[]) new Object[List.length - 1];
        for (int i = 0; i < last; i++) {
            temp[i] = List[i];
        }
        List = temp;
        last--;
        return o;
    }
    public boolean isEmpty() {
        return List.length == 0;
    }
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < List.length; i++) {
            str += List[i] + " ";
        }
        return "стек: " + str;
    }

    public GenericStack() {
        List = (E[]) new Object[1];
    }
}