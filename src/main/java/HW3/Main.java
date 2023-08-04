package HW3;

import java.util.*;

abstract class People {
    protected String name;

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Student extends HW3.People {
    private int age;

    public Student(String name, int age) {
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

class StudentGroup {
    private String groupName;
    private List<HW3.Student> students;

    public StudentGroup(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    public void addStudent(HW3.Student student) {
        students.add(student);
    }

    public void printStudents() {
        System.out.println("Студенты в группе №" + groupName + ":");
        for (HW3.Student student : students) {
            System.out.println("Имя: " + student.getName() + ", Возраст: " + student.getAge());
        }
        System.out.println();
    }
}

class Stream implements Iterable<HW3.StudentGroup> {
    private List<HW3.StudentGroup> studentGroups;

    public Stream(List<HW3.StudentGroup> studentGroups) {
        this.studentGroups = studentGroups;
    }

    @Override
    public Iterator<HW3.StudentGroup> iterator() {
        return studentGroups.iterator();
    }
    public int size() {
        return studentGroups.size();
    }
}

class StreamComparator implements Comparator<HW3.Stream> {
    @Override
    public int compare(HW3.Stream s1, HW3.Stream s2) {
        return Integer.compare(s1.size(), s2.size());
    }
}

class PotokService {
    public void sortirvatSpisokPotokov(List<HW3.Stream> potoki) {
        Collections.sort(potoki, new HW3.StreamComparator());
    }
}

class Kontroller {
    private HW3.PotokService potokService;

    public Kontroller(HW3.PotokService potokService) {
        this.potokService = potokService;
    }

    public void sortirovatSpisokPotokov(List<HW3.Stream> potoki) {
        potokService.sortirvatSpisokPotokov(potoki);
    }
}

public class Main {
    public static void main(String[] args) {
        HW3.StudentGroup group1 = new HW3.StudentGroup("311");
        group1.addStudent(new HW3.Student("Григорий", 20));
        group1.addStudent(new HW3.Student("Евгений", 21));
        group1.addStudent(new HW3.Student("Павел", 22));

        HW3.StudentGroup group2 = new HW3.StudentGroup("452");
        group2.addStudent(new HW3.Student("Анатолий", 19));
        group2.addStudent(new HW3.Student("Виктор", 20));

        List<HW3.StudentGroup> stream1 = new ArrayList<>();
        stream1.add(group1);
        stream1.add(group2);

        List<HW3.StudentGroup> stream2 = new ArrayList<>();
        stream2.add(group1);

        HW3.Stream s1 = new HW3.Stream(stream1);
        HW3.Stream s2 = new HW3.Stream(stream2);

        HW3.PotokService potokService = new HW3.PotokService();
        HW3.Kontroller kontroller = new HW3.Kontroller(potokService);

        List<HW3.Stream> potoki = new ArrayList<>();
        potoki.add(s1);
        potoki.add(s2);

        kontroller.sortirovatSpisokPotokov(potoki);

        for (HW3.Stream potok : potoki) {
            for (HW3.StudentGroup group : potok) {
                group.printStudents();
            }
        }
    }
}
