# Singleton Printer Spooler

----

## Overview :
* This project demonstrates the Singleton Design Pattern using a **Printer Spooler** system. 
* A printer spooler manages all print jobs in an office or networked environment.
* Ensures only one instance exists, preventing duplicates and maintaining a consistent print queue.
----

## Features :

* Thread-safe Singleton implementation.
* Add print jobs to the queue.
* Process jobs in order (FIFO).
* View pending jobs in the queue.
* Ensures all users/modules share the same spooler instance.

----

## Implementation :

* `PrinterSpooler` is a singleton class using a thread-safe implementation.
* The constructor for `PrinterSpooler` is made as private so we can't create multiple instance.
* This class have methods to `addJob`, `processNextJob`, `showQueue` which are used in the main class.
* I used a Queue that stores the jobs in order, executed in a synchronized way.