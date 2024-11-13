import java.util.*;

public class StackOnQueue{
    private ArrayDeque<Integer> queue1 = new ArrayDeque<>();
    private ArrayDeque<Integer> queue2 = new ArrayDeque<>();
    public int getSize() {
        return queue1.size();
    }
    public void push(int x){
        queue1.add(x);
    }
    public int top(){
        //System.out.println(queue1);
        int n = getSize();
        queue2 = queue1.clone();
        for (int i = 0; i < n - 1; i++) {
            queue2.poll();
        }
        //System.out.println(queue1);
        // System.out.println(queue2);
        return queue2.poll();
    }
    public int pop(){
        //System.out.println(queue1);
        int n = getSize();
        queue2 = queue1.clone();
        queue1.clear();
        for (int i = 0; i < n - 1; i++) {
            queue1.add(queue2.poll());
        }
        //System.out.println(queue1);
        // System.out.println(queue2);
        return queue2.poll();
    }

    public boolean isEmpty(){
        return queue1.isEmpty();
    }
/*    @Override
    public String toString() {
        return "стек: " + list.toString();
    }*/
}
