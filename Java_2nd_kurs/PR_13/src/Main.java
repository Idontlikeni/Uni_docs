//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Directorie home = new Directorie("home", 0);
        Directorie picture = new Directorie("pictures", 0);
        Directorie docs = new Directorie("documents", 0);
        File pic1 = new File("pic1.png", 100);
        File pic2 = new File("pic2.jpeg", 200);
        File docx1 = new File("zadanie.docx", 1000);

        picture.addNode(pic1);
        picture.addNode(pic2);
        docs.add(docx1);

        home.addNode(picture);
        home.addNode(docs);
        for(Node n: home.getNodes()){
            n.printNode(0);
            for(Node m: n.getNodes()){
                m.printNode(4);
            }
        }
    }
}
/*
Composite – Задание
Вариант №3
Создать иерархическую систему управления файлами. В системе должны быть
директории и файлы, причём каждая директория может содержать как файлы,
так и другие директории.
Требования:
Реализовать интерфейс FileComponent с методами для добавления и
отображения содержимого.
Создать классы для файлов и директорий.
Организовать древовидную структуру иерархии файлов.
*/