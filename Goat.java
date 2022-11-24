import java.util.Random;

public class Goat extends Animal implements Milking{

    @Override
    public double milkProduced() {

        Random rand = new Random();

        double produced = 2 + (3 - 2) * rand.nextDouble();

        return produced;

    }

}
