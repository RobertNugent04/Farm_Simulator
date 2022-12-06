import java.util.Random;

public class Goat extends Animal implements Milkable {

    //Goats have separate ids from dairy cows

    private int timesMilked;

    private double milkProduced;

    public Goat() {
        Random rand = new Random();
        this.timesMilked = 0;
        this.milkProduced = 2 + (3 - 2) * rand.nextDouble();
    }

    public Goat(int age, double weight){
        super(age, weight);
        Random rand = new Random();
        this.timesMilked = 0;
        this.milkProduced = 2 + (3 - 2) * rand.nextDouble();
    }

    public int getTimesMilked() {
        return timesMilked;
    }

    public double getMilkProduced() {
        return milkProduced;
    }

    public void setTimesMilked(int timesMilked) {
        this.timesMilked = timesMilked;
    }

    public void setMilkProduced(double milkProduced) {
        this.milkProduced = milkProduced;
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
                "milk produced = " + milkProduced +
                super.toString() +
                '}';
    }
}
