import java.util.Random;

public class Goat extends Animal implements Milking{

    public static int goatId;

    public static int idCount = 1;

    private String name;

    private int timesMilked;

    public Goat() {
        this.goatId = idCount;
        this.timesMilked = 0;
        idCount++;
    }

    public int getTimesMilked() {
        return timesMilked;
    }

    public void setTimesMilked(int timesMilked) {
        this.timesMilked = timesMilked;
    }

    @Override
    public double milkProduced() {

        Random rand = new Random();

        double produced = 2 + (3 - 2) * rand.nextDouble();

        return produced;

    }

    @Override
    public int timesMilked(){

        return this.timesMilked;

    }

    @Override
    public void milked() {

        this.setTimesMilked(this.timesMilked++);

    }

}
