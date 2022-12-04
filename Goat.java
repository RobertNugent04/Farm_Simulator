import java.util.Random;

public class Goat extends Animal implements Milkable {

    //Goats have separate ids from dairy cows
    public int goatId;

    public static int idCount = 1;

    private int timesMilked;

    public Goat() {
        this.goatId = idCount;
        this.timesMilked = 0;
        idCount++;
    }

    public Goat(double weight){

        super(weight);
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

    @Override
    public String toString() {
        return "Goat{" +
                "goatId=" + goatId +
                super.toString() +
                '}';
    }
}
