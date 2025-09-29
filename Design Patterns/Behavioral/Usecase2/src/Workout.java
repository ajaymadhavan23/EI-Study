public class Workout implements Task{
    private String work;
    public Workout(String work){
        this.work = work;
    }

    @Override
    public void execute() {
        System.out.println("Working on " + this.work);
    }
}
