// Concrete class for Task Interface

public class Studytask implements Task {

    private String subject;

    Studytask(String subject) {
        this.subject = subject;
    }

    @Override
    public void execute() {
        System.out.println("Study: "+subject);
    }
}
