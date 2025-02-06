//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyStack<String> s = new MyStack<>();
        MyStack<String> s2;
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        s.push("5");
        try{
            s2 = (MyStack<String>)s.clone();
            System.out.println(s2.peek());

        }catch(CloneNotSupportedException e){
            System.out.println("Ошибка");
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(s.pop());
        }

    }
}