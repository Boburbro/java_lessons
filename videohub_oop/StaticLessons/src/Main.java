public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();

        person1.name = "Ali";
        person1.username = "alijon_sila";

        person2.name = "Vali";
        Person.username = "valixx0";

        System.out.println(person1.name + " " + person1.username);
        System.out.println(person2.name + " " + person2.username);

        person1.printDetail();
        Person.testStatic();

    }
}