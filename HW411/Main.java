import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Planner planner = new Planner();
        String userInput;
        boolean stopFlag = true;

        while(stopFlag) {
            System.out.println("Выберите действие:\n" +
                    "1. Добавить задачу\n" +
                    "2. Вывести список задач\n" +
                    "3. Удалить задачу\n" +
                    "0. Выход");
            userInput = scanner.nextLine();

            switch (Integer.parseInt(userInput)) {
                case 1:
                    System.out.println("Введите задачу и нажмите Enter:");
                    planner.addTask(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Вводите задачи через enter для удаления:");
                    while(true) {
                        userInput = scanner.nextLine();
                        if (userInput.equals("Finish")) {
                            planner.removeTasks(planner.tasksToRemove);
                            planner.getTask();
                            break;
                        } else {
                            planner.addTasksToRemove(Integer.parseInt(userInput) - 1);
//                            planner.removeTasks(Integer.parseInt(userInput) - 1);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Введите номер удаляемой задачи и нажмите Enter:");
                    userInput = scanner.nextLine();
                    planner.addTasksToRemove(Integer.parseInt(userInput) - 1);
                    planner.removeTasks(planner.tasksToRemove);
//                    planner.removeTasks(Integer.parseInt(userInput) - 1);
                    break;
                case 0:
                    System.out.println("До встречи!");
                    stopFlag = false;
                    break;
                default:
                    System.out.println("Введите допустимое значение!");
                    break;
            }
        }
    }
}
