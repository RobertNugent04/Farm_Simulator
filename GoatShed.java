import java.util.Collection;

public class GoatShed extends Shed {

    //A dairy cow shed stores only the dairy cows so that they are milked separately from the goats

    public GoatShed() {
    }

    public GoatShed(MilkTank tank) {
        super(tank);
    }

    public GoatShed(Collection<Animal> animals) {
        super(animals);
    }

    public GoatShed(Collection<Animal> animals, MilkingMachine machine, MilkTank tank) {
        super(animals, machine, tank);
    }


    @Override
    public String toString() {
        return "GoatShed{" +
                super.toString() +
                '}';
    }
}
