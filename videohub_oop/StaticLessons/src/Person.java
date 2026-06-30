public class Person {
    public String name;
    public static String username;

    static {
        username
                = "USermane";
    }

    public void printDetail() {
        System.out.println(name + " " + username);
    }

    public static void testStatic() {
        System.out.println("testStatic");
    }
}
