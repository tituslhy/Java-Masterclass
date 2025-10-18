package GenericLesson2;

public class LPAStudent extends Student{
    private double percentComplete;

    // This constructor implements the super constructor inherently
    // and uses the `random` static field from the parent class (student).
    public LPAStudent(){
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString(){
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }
}
