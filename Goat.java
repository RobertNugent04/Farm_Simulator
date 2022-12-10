import java.util.Objects;
import java.util.Random;

public class Goat extends Animal implements Milkable, Comparable<Goat>{

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goat)) return false;
        Goat goat = (Goat) o;
        return Double.compare(goat.getMilkProduced(), getMilkProduced()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMilkProduced());
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

    @Override
    public int compareTo(Milkable m) {
        return Double.compare(this.milkProduced, m.milkProduced());
    }

    /**
     * @param g the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Goat g) {
        return Double.compare(this.milkProduced, g.milkProduced);
    }

}
