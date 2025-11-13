//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {

import java.util.ArrayList;

//        int age = getAge();
//        System.out.println("Your age is " + age);
//
//        User detail = getUser();
//        String name = detail.name;
//        String surname = detail.surname;
//        int age = detail.age;
//        System.out.println(name + " " + surname + " " + age);
//    }
//
//    public static int getAge() {
//        System.out.print("Enter your age > ");
//        Scanner scanner = new Scanner(System.in);
//
//        int age = scanner.nextInt();
//        scanner.close();
//        return age;
//    }
//
//    public static Object[] getUserDetail() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter your name > ");
//        String name = scanner.next();
//
//        System.out.print("Enter your surname > ");
//        String surname = scanner.next();
//
//        System.out.print("Enter your age > ");
//        int age = scanner.nextInt();
//
//        scanner.close();
//
//        Object[] obj = new Object[3];
//
//        obj[0] = name;
//        obj[1] = surname;
//        obj[2] = age;
//
//        return obj;
//    }
//
//    public static User getUser() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter your name > ");
//        String name = scanner.next();
//
//        System.out.print("Enter your surname > ");
//        String surname = scanner.next();
//
//        System.out.print("Enter your age > ");
//        int age = scanner.nextInt();
//
//        scanner.close();
//
//        User user = new User();
//        user.name = name;
//        user.surname = surname;
//        user.age = age;
//
//
//        return user;
//    }
//}


//public class Main {
//    public static void main(String[] args) {
//
//        User user = new User();
//
//        user.name = "Alish";
//        user.surname = "Qo'chqorov";
//        user.age = 17;
//
//        System.out.println(user.name + " " + user.surname + " " + user.age);
//
//        user.name = "Hasan";
//        System.out.println(user.name + " " + user.surname + " " + user.age);
//
//    }
//
//}


public class Main {
    public static void main(String[] args) {
        User user1 = new User();

        user1.name = "Ali";
        user1.surname = "Sharipov";

        User user2 = new User();
        user2.name = "Karan";
        user2.surname = "Aliyerv";

        user1.printDetail();
        user2.printDetail();

        System.out.println(user1.toString());

        System.out.println(user1.nameUpper());



    }
}