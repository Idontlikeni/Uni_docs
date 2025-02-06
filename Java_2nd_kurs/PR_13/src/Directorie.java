import java.util.ArrayList;
import java.util.List;

public class Directorie extends Node implements FileComponent{
    private String name;
    private int size;
    private List<Node>nodes;
    public Directorie(String name, int size) {
        this.name = name;
        this.size = size;
        nodes = new ArrayList<>();
    }

    public void add(Node n){
        nodes.add(n);
    }

    public void remove(Node n){
        nodes.remove(n);
    }

    public List<Node> getNodes(){
        return nodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String toString(){
        return "\\" + name;
    }

    @Override
    public void addNode(Node n) {
        nodes.add(n);
    }

    @Override
    public void printNode(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += " ";
        }
        System.out.println(s + toString());
    }
}