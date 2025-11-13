import java.util.Scanner;

import static java.lang.System.exit;

public class Main {


    public static void main(String[] args) {

        while (true) {
            menu();
            int n = getAction();

            switch (n) {
                case 1:
                    Contact contact = addContact();
                    if (!isValidContact(contact)) {
                    }
                    System.out.println(contact.name + " " + contact.surname);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    exit(0);
                    break;
                default:
                    System.out.println("Please choose current number");
                    break;

            }
        }
    }

    public static void menu() {
        System.out.println("** Menu **");
        System.out.println("1.Add Contact");
        System.out.println("2.Contact List");
        System.out.println("3.Search");
        System.out.println("4.Delete contact");
        System.out.println("0.Exit");
    }

    public static int getAction() {
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static Contact addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.next();

        System.out.print("Enter your surname: ");
        String surname = scanner.next();

        System.out.print("Enter your phone: ");
        String phone = scanner.next();


        Contact contact = new Contact();
        contact.name = name;
        contact.surname = surname;
        contact.phone = phone;

        return contact;

    }

    public static boolean isValidContact(Contact contact) {

        if (contact.name == null || contact.name.trim().length() < 3) {
            System.out.println("Name is wrong");
            return false;
        }

        if (contact.surname == null || contact.surname.trim().length() < 3) {
            System.out.println("Surname is wrong");
            return false;
        }

        if (contact.phone == null || contact.phone.trim().length() < 7) {
            System.out.println("Phone is wrong");
            return false;
        }

        char[] phoneArr = contact.phone.toCharArray();
        for (char ch : phoneArr) {
            if (!Character.isDigit(ch)) {
                System.out.println("Phone number is wrong");
                return false;
            }
        }

        return true;
    }

}