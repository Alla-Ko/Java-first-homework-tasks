import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class TaskManager {
	private List<Task> tasks;
	public TaskManager() {
		tasks = new ArrayList<>();
	}
	public void addTask(String title, String description) {
		Task newTask = new Task(title, description);
		tasks.add(newTask);
	}
	public void viewTasks() {
		if (tasks.isEmpty()) {
			System.out.println("\033[0;31mНемає завдань.\033[0m");
		} else {
			int count=1;
			for (Task task : tasks) {
				System.out.println("Завдання " + count + ":");
				System.out.println(task);
				System.out.println("-------------------------------");
				count++;
			}
		}
	}
	public int getTasksCount() {
        return tasks.size();
    }
	public void editTask(int index, String newTitle, String newDescription, boolean newStatus) {
		if (index >= 0 && index < tasks.size()) {
			Task task = tasks.get(index);
			task.setDescription(newDescription);
			task.setCompleted(newStatus);
			task.setTitle(newTitle);
		}
		else {
            System.out.println("\033[0;31mЗавдання не знайдено.\033[0m");
        }
	}
	public void deleteTask(int index) {
		if (index >= 0 && index < tasks.size()) {
			tasks.remove(index);
		}
		else {
            System.out.println("\033[0;31mЗавдання не знайдено.\033[0m");
        }
	}
	public void sortByDate() {
		tasks.sort((task1, task2) -> task1.getCreatedDate().compareTo(task2.getCreatedDate()));
		viewTasks();
	}
	public void filterByStatus(boolean status) {
		List<Task> filteredTasks = tasks.stream()
				.filter(task -> task.isCompleted() == status)
				.collect(Collectors.toList());
		if (filteredTasks.isEmpty()) {
			System.out.println("\033[0;31mНемає завдань з таким статусом.\033[0m");
		} else {
			int count=1;
			for (Task task : filteredTasks) {
				System.out.println("Завдання " + count + ":");
				System.out.println(task);
				System.out.println("-------------------------------");
				count++;
			}
		}
	}
	public void searchTasks(String keyword) {
		List<Task> foundTasks = tasks.stream()
				.filter(task -> task.getTitle().contains(keyword) || task.getDescription().contains(keyword))
				.collect(Collectors.toList());
		if (foundTasks.isEmpty()) {
			System.out.println("\033[0;31mНе знайдено завдань з таким ключовим словом.\033[0m");
		} else {
			int count=1;
			for (Task task : foundTasks) {
				System.out.println("Завдання " + count + ":");
				System.out.println(task);
				System.out.println("-------------------------------");
				count++;
			}
		}
	}
}
