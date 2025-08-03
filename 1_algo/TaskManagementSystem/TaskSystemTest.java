public class TaskSystemTest {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(new Task(1, "Design database", "Pending"));
        manager.addTask(new Task(2, "Implement login", "In Progress"));
        manager.addTask(new Task(3, "Test app", "Pending"));

        System.out.println("All Tasks:");
        manager.displayTasks();

        System.out.println("\nSearching Task with ID 2:");
        Task found = manager.searchTask(2);
        System.out.println(found != null ? found : "Not found");

        System.out.println("\nDeleting Task with ID 2:");
        manager.deleteTask(2);
        manager.displayTasks();
    }
}
