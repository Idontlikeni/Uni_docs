public class Main {
    public static void main(String[] args) {
        StackOnQueue st = new StackOnQueue();
        st.push(1);
        st.push(2);
        System.out.println(st.top());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.getSize());
        System.out.println(st.isEmpty());
    }
}