import java.util.Date;
public class Task {
	private String title;
	private String description;
	private Date createdDate;
	private boolean isCompleted;

	public Task(String title, String description) {
		this.title = title;
		this.description = description;
		this.createdDate = new Date(); // поточна дата створення
		this.isCompleted = false; // статус за замовчуванням
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

    public boolean isCompleted() {
        return isCompleted;
    }
	public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }

	@Override
	public String toString() {
		return "Завдання: " + title + "\n" +
				"Опис: " + description + "\n" +
				"Дата створення: " + createdDate + "\n" +
				"Статус: " + (isCompleted ? "Виконано" : "Не виконано");
	}








}
