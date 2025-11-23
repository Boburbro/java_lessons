import contact.Contact;
import contact.ContactManager;
import task.TaskManager;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        ContactManager contactManager = new ContactManager();

        TaskManager taskManager = new TaskManager();

        boolean flag = true;
        while (flag) {
            menu();
            int n = getAction();

            switch (n) {
                case 1:
                    contactManager.start();
                    break;
                case 2:
                    taskManager.start();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Please choose current number");
                    break;

            }
        }


    }

    static void menu() {
        System.out.println("** Menu **");
        System.out.println("1.Contact");
        System.out.println("2.Task");
        System.out.println("0.Exit");
    }

    static int getAction() {
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}