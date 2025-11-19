public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Bobur");
        person.setSurname("Otaboyev");
        person.detailPrint();
        System.out.println(person.getName());
        System.out.println(person.getSurname());
    }

}