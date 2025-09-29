public class DoToTask {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addtask(new GroceryTask("Apple"));
        manager.addtask(new Studytask("OOP"));
        manager.addtask(new Workout("Workout"));

        manager.showTasks();

        manager.finishTask(1);

        manager.showTasks();
    }
}
