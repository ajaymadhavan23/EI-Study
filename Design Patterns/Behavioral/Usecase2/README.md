# To-Do Task App (Command Pattern)

It's a simple To-Do Task Manager...we create different type of tasks. We add all the task and save it in a list. Later we can finish each task at the given oder or Finish any particular we want



## Overview :

* This project demonstrates the **Command Design Pattern** using a **To-Do Task Manager**.

* Each to-do item (like buy groceries, workout, study) is wrapped as a command object.

* The `TaskManager` (Invoker) handles tasks without knowing their internal logic.

* `finishTask()` lets you complete tasks out of order, like a real To-Do app.

* The user creates tasks and hands them to Invoker(TaskManager), which later we can execute them.

---

## Features :

* **Add tasks dynamically:** `Grocery`, `Workout`, `Study`, etc.

* Execute all tasks in order (FIFO).

* **Finish specific tasks** out of order using `finishTask(index)`.

* Show current pending tasks with `showTasks()`.

* **Easy to extend** → add new tasks without modifying TaskManager.

---

## Implementation :

* `Task` (Interface):

  * Declares a common `execute`() method for all tasks (Task).

* **Concrete Commands:**

  * Each real-life task implements Task.

  * Examples: `GroceryTask`, `WorkoutTask`, `StudyTask`.

* **Invoker** (`TaskManager`):

  * Stores tasks in a list.

  * Executes all tasks or specific tasks using `finishTask`(index).

  * Can display current pending tasks with `showTasks`().

* **Client** (Main):

  * Creates task objects.

  * Adds them to the manager and executes tasks in order or out of order.

---

## Sample Flow / Output :

`TaskManager manager = new TaskManager();` -- create a obejct for TaskManager to use it

`manager.addtask(new GroceryTask("Apple"));` -- Adding new Grocery task

`manager.addtask(new Studytask("OOP"));` -- Adding new Study task

`manager.addtask(new Workout("Workout"));` -- Adding new Workout task

`manager.showTasks();` -- show all task

--- Current To-Do List ---

0: GroceryTask

1: Studytask

2: Workout

`manager.finishTask(1);` - finish the 1st task (StudyTask)

Finishing Task...

Study: OOP

--- Current To-Do List ---

0: GroceryTask

1: Workout
