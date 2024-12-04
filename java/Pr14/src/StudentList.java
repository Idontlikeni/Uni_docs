import java.util.Iterator;

public class StudentList {
    private String[] students;

    public Iterator<String> getIterator(){
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<String>{
        int index = 0;
        public boolean hasNext() {return index < students.length;}
        public String next(){return students[index++];}
    }

    public StudentList(String[] students) {
        this.students = students;
    }
}
