import java.util.*;

public class StackOnQueue{
    private LinkedList<Integer> queue1 = new LinkedList<>();
    private LinkedList<Integer> queue2 = new LinkedList<>();
    public int getSize() {
        return queue1.size();
    }
    public void push(int x){
        queue1.add(x);
    }
    public int top(){
        int n = getSize();
        int r;
        for (int i = 0; i < n - 1; i++) {
            queue2.add(queue1.poll());
        }
        r = queue1.poll();
        for (int i = 0; i < n - 1; i++) {
            queue1.add(queue2.poll());
        }
        queue1.add(r);
        return r;
    }

    public int pop(){
        int n = getSize();
        int r;
        for (int i = 0; i < n - 1; i++) {
            queue2.add(queue1.poll());
        }
        r = queue1.poll();
        for (int i = 0; i < n - 1; i++) {
            queue1.add(queue2.poll());
        }
        return r;
    }

    public boolean isEmpty(){
        return queue1.isEmpty();
    }
}
