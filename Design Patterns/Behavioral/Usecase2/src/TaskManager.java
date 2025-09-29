// This is the TaskManager class which will do all different tasks,
// It's mainly useful in future if we have more different classes

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> arr = new ArrayList<>();

    public void addtask(Task task){
        arr.add(task);
    }

    // Run all the task in FIFO
    public void runTasks() {
        System.out.println("\n--- Executing All Tasks ---");
        for (Task task : arr) {
            task.execute();
        }
        arr.clear();
    }

    // Finish a specific task by giving the index
    public void finishTask(int index) {
        if (index >= 0 && index < arr.size()) {
            Task task = arr.remove(index);
            System.out.println("\nFinishing Task...");
            task.execute();
        } else {
            System.out.println("Invalid task index!");
        }
    }

    // Show current tasks (tasks in the list)
    public void showTasks() {
        System.out.println("\n--- Current To-Do List ---");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + ": " + arr.get(i).getClass().getSimpleName());
        }
    }
}
