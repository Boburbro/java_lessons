public class Person {
    String name;
    String surname;
    String country;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person() {
        this("Mazgi", "Mazgiyev");
        country = "Uzbekistan";
    }

    public void printDetail() {
        System.out.println(name + " " + surname + " " + country);
    }

    public void sayHello() {
        System.out.println(this);
        System.out.println("Hello World");
        this.printDetail();
    }

}
