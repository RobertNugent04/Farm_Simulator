import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Random;

public class Goat extends Animal implements Milkable, Comparable<Goat>{

    //Stores the number of times the goat has been milked
    private int timesMilked;

    private double milkProduced;

    //Learned from https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/
    private static final DecimalFormat decimal = new DecimalFormat("0.00");

    public Goat() {
        Random rand = new Random();
        this.timesMilked = 0;
        this.milkProduced = Double.parseDouble(decimal.format(2 + (3 - 2) * rand.nextDouble()));
    }

    public Goat(int age, double weight){
        super(age, weight);
        Random rand = new Random();
        this.timesMilked = 0;
        this.milkProduced = Double.parseDouble(decimal.format(2 + (3 - 2) * rand.nextDouble()));
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

        return this.milkProduced;

    }

    @Override
    public int NumTimesMilked(){

        return this.timesMilked;

    }

    @Override
    public void milked() {

        this.setTimesMilked(this.timesMilked + 1);

    }

    @Override
    public String toString() {
        return "Goat{" +
                "milk produced = " + milkProduced + " liters" +
                ", times milked = " + timesMilked +
                super.toString() +
                '}';
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
