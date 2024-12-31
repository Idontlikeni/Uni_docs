import java.util.List;

public class File extends Node implements FileComponent{
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
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
        return "File: " + name + "; Size: " + size + "b";
    }

    @Override
    public void addNode(Node n) {
        System.out.println("Нельзя добавить файл, т.к это не является директорией");
    }

    @Override
    public void printNode(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s+=" ";
        }
        System.out.println(s + this);
    }

    @Override
    public List<Node> getNodes() {
        return null;
    }
}
