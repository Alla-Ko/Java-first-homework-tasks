import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        boolean exit = false;

        while (!exit) {
            System.out.println("\033[0;30m\033[48;5;10m Менеджер завдань: \033[0m");
            System.out.println("____________________________________");
            System.out.println("1. Додати завдання");
            System.out.println("2. Переглянути всі завдання");
            System.out.println("3. Редагувати завдання");
            System.out.println("4. Видалити завдання");
            System.out.println("5. Сортувати завдання за датою");
            System.out.println("6. Фільтрувати завдання за статусом");
            System.out.println("7. Пошук завдань за ключовим словом");
            System.out.println("8. Вихід");
            System.out.println("____________________________________");
            System.out.print("\033[0;30m\033[44m Виберіть опцію: \033[0m");

	        int choice = 0;

	        do {

			        choice = getInteger();
                    if (choice < 1 || choice > 8) {
                        System.out.println("\033[0;31mСпробуйте ще раз, будь ласка\033[0m");
                    }
                    else {break;}


	        } while (true);

	        switch (choice) {

                case 1: {
                    System.out.print("Введіть назву завдання: ");
                    String title = getString();
                    System.out.print("Введіть опис завдання: ");
                    String description = getString();
                    taskManager.addTask(title, description);
                    break;
                }
                case 2: {
                    taskManager.viewTasks();
                    break;
                }
                case 3: {
                    System.out.print("Введіть номер завдання для редагування: ");
                    int index = getInteger();

                    // очищення буфера вводу
                    if(index<1||index>taskManager.getTasksCount()) {
                        System.out.println("\033[0;31mЗавдання не знайдено\033[0m");
                        break;
                    }

                    System.out.print("Введіть нову назву завдання: ");
                    String newTitle = getString();
                    System.out.print("Введіть новий опис завдання: ");
                    String newDescription = getString();
                    System.out.print("Змінити статус на виконано (true/false): ");

	                boolean newStatus = getBoolean();



	                taskManager.editTask(index-1, newTitle, newDescription, newStatus);
                    break;
                }
                case 4: {
                    System.out.print("Введіть номер завдання для видалення: ");

                    int index = getInteger();
                    taskManager.deleteTask(index-1);
                    break;
                }
                case 5: {
                    taskManager.sortByDate();
                    break;
                }
                case 6: {
                    System.out.print("Фільтрувати за статусом (true для виконаних, false для невиконаних): ");
                    boolean status = scanner.nextBoolean();
                    taskManager.filterByStatus(status);
                    break;
                }
                case 7: {
                    System.out.print("Введіть ключове слово для пошуку: ");
                    String keyword = getString();
                    taskManager.searchTasks(keyword);
                    break;
                }
                case 8: {
                    exit = true;
                    break;
                }
                default:
                    System.out.println("\033[0;31mНевірний вибір. Спробуйте ще раз.\033[0m");
            }

        }

    }
    public static int getInteger(){
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            try {
                number = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("\033[0;31mВведіть ціле число. Спробуйте ще раз.\033[0m");
                scanner.nextLine();
            }
        } while (true);
        return number;
    }
    public static String getString(){
        Scanner scanner = new Scanner(System.in);
        String newString;
        do {
            newString = scanner.nextLine();
            if(newString.isEmpty()){
                System.out.println("\033[0;31mПоле не може бути пустим. Спробуйте ще раз.\033[0m");
            } else {
                break;
            }
        }while(true);
        return newString;
    }
    public static boolean getBoolean(){
        Scanner scanner = new Scanner(System.in);
        boolean newBoolean;
        do {
            try {
                newBoolean = scanner.nextBoolean();
                scanner.nextLine();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("\033[0;31mВведіть значення true або false. Спробуйте ще раз.\033[0m");
                scanner.nextLine();
            }
        } while (true);
        return newBoolean;
    }
}
