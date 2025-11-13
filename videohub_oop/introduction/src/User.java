public class User {

    String name;
    String surname;
    int age;


    public void printDetail(){
        System.out.println(name + " " + surname + " " + age);
    }

    public String toString(){
        return name + " " + surname + " " + age;
    }

    public String nameUpper(){
        return name.toUpperCase();
    }
}
