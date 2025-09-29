import java.util.LinkedList;
import java.util.Queue;

// This is the Singleton class
public class PrinterSpooler {

    private static PrinterSpooler instance;

    // Queue to store print jobs
    private final Queue<String> printQueue;

    // We make the Constructor as private,
    // so we won't be able to call this method from outside to create object
    private PrinterSpooler() {
        printQueue = new LinkedList<>();
    }

    // Thread-safe way method used here
    public static PrinterSpooler getInstance() {
        if (instance == null) {
            synchronized (PrinterSpooler.class) {
                if (instance == null) {
                    instance = new PrinterSpooler();
                    System.out.println("Printer Spooler initialized!");
                }
            }
        }
        return instance;
    }

    public void addJob(String jobName) {
        printQueue.add(jobName);
        System.out.println("Job added: " + jobName);
    }

    public void processNextJob() {
        if (printQueue.isEmpty()) {
            System.out.println("No jobs in the queue.");
        } else {
            String job = printQueue.poll();
            System.out.println("Printing job: " + job);
        }
    }

    public void showQueue() {
        if (printQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Pending jobs: " + printQueue);
        }
    }
}
