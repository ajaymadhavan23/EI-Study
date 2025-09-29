# Exercise 1: Design Patterns Implementation

---

## Overview :

This folder contains six real-world implementations of software design patterns in Java, demonstrating behavioral, creational, and structural patterns.
Each program showcases a practical use-case, highlighting how design patterns help in writing clean, modular, and maintainable code.

---

## Implemented Patterns & Programs :

## Creational Patterns : 

### [1. Singleton: Printer Spooler](Creational/Usecase1/README.md)

* Ensures only one instance of the printer spooler exists in a network.

* All print jobs go through the **same object**, maintaining a consistent queue.

### [2. Factory: Vehicle Booking App](Creational/Usecase2/README.md)

* Users can book different vehicles (Car/Bike/Auto) via a common Transport interface.

* `TransportFactory` creates objects based on user choice without exposing creation logic.

---

## Structural Patterns :

### [1. Bridge: Remote Control Device](Structural/Usecase1/README.md)

* Decouples **abstraction** (Remote) from **implementation** (Device) allowing independent extension.

* Supports multiple devices and remote types without modifying existing classes.

### [2. Decorator: Coffee Shop Customizer](Structural/Usecase2/README.md)

* Base coffee can be dynamically enhanced with add-on's like **Milk, Sugar, Chocolate**.

* Demonstrates how behavior can be added to objects at runtime without modifying the base class.

---

## Behavioral Patterns :

### [1. Observer: Stock Price Alerts](Behavioral/Usecase1/README.md)

* `Stock` (Subject) notifies all registered observers (Messenger, Mails) automatically on price updates.

* Demonstrates one-to-many dependency and dynamic subscriptions.

### [2. Command: To-Do Task App](Behavioral/Usecase1/README.md)

* Each task is a command object (`GroceryTask`, `WorkoutTask`, `StudyTask`).

* `TaskManager` (Invoker) schedules and executes tasks, supporting execution in order or individually.