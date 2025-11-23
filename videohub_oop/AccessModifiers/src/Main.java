import person.Person;
import test.Test;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Ali";
        student.age = 18;
        student.printDetail();

        Person person = new Person();
        person.name = "Valish";
        person.age = 20;

        person.printDetail();

        Test test = new Test();
        test.start();

    }
}