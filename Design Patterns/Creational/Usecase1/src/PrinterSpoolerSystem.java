public class PrinterSpoolerSystem {
    public static void main(String[] args) {

        PrinterSpooler spooler1 = PrinterSpooler.getInstance();
        PrinterSpooler spooler2 = PrinterSpooler.getInstance();

        // We ensure that both instance are same
        System.out.println("Are both spoolers same? " + (spooler1 == spooler2));

        // Adding print jobs
        spooler1.addJob("Document_A.pdf");
        spooler2.addJob("Report_B.docx");
        spooler1.addJob("Presentation_C.pptx");

        // Even though we gave spooler2.addJob() it will still refer to the same spooler1 object (Singleton Implementation)


        // Show pending jobs
        spooler1.showQueue();

        // Process jobs
        spooler2.processNextJob();
        spooler1.processNextJob();
        spooler2.processNextJob();

        // Show queue after processing
        spooler1.showQueue();
    }
}
