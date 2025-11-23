package task;

import java.util.Scanner;

import static java.lang.System.exit;

public class TaskManager {

    public Task[] taskArray = new Task[10];
    public int currentIndex = 0;
    public int generalID = 1;

    public void start() {
        boolean flag = true;
        while (flag) {
            menu();
            int n = getAction();

            switch (n) {
                case 1:
                    Task task = addTask();
                    addToArray(task);
                    break;
                case 2:
                    printAllTasks();
                    break;
                case 3:
                    String title = getTaskTitle();
                    changeStatusByTitle(title);
                    break;
                case 4:
                    int id = getTaskId();
                    changeStatusById(id);
                    break;
                case 5:
                    printActiveTasks();
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

    public void menu() {
        System.out.println("** Menu **");
        System.out.println("1.Add Task");
        System.out.println("2.Task List");
        System.out.println("3.ChangeStatus by name");
        System.out.println("4.ChangeStatus by id");
        System.out.println("5.Active TaskList");
        System.out.println("0.Exit");
    }

    public int getAction() {
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public Task addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter content: ");
        String content = scanner.nextLine();

        Task task = new Task();
        task.setTitle(title);
        task.setContent(content);


        return task;
    }

    public void addToArray(Task task) {
        if (currentIndex == taskArray.length) {
            Task[] newArr = new Task[taskArray.length + 1];
            for (int i = 0; i < taskArray.length; i++) {
                newArr[i] = taskArray[i];

            }
            taskArray = newArr;
        }
        task.setStatus("ACTIVE");
        task.setId(generalID++);
        taskArray[currentIndex] = task;
        currentIndex++;
        System.out.println(task.getTitle() + " " + task.getContent());
    }

    public void printAllTasks() {
        for (Task task : taskArray) {
            if (task != null) {
                System.out.println(task.getId() + " " + task.getTitle() + " " + task.getContent() + " " + task.getStatus());
            }
        }
    }

    public void printActiveTasks() {
        for (Task task : taskArray) {
            if (task != null && task.getStatus().equals("ACTIVE")) {
                System.out.println(task.getId() + " " + task.getTitle() + " " + task.getContent() + " " + task.getStatus());
            }
        }
    }

    public String getTaskTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter title: ");
        return scanner.nextLine();
    }

    public void changeStatusByTitle(String title){
        for (Task t : taskArray) {
            if (t == null) {
                continue;
            }
            if (t.getTitle().equals(title)) {
                t.setStatus(t.getStatus().equals("DONE") ? "ACTIVE" : "DONE");
                break;
            }
        }
    }

    public int getTaskId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        return scanner.nextInt();
    }

    public void changeStatusById(int id){
        for (Task t : taskArray) {
            if (t == null) {
                continue;
            }
            if (t.getId() == id) {
                t.setStatus(t.getStatus().equals("DONE") ? "ACTIVE" : "DONE");
                break;
            }
        }
    }

}
