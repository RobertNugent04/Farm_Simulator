import java.util.Collection;

//A dairy cow shed stores only the dairy cows so that they are milked separately from the goats
public class DairyCowShed extends Shed{

    public DairyCowShed() {
    }

    public DairyCowShed(MilkTank tank) {
        super(tank);
    }

    public DairyCowShed(Collection<Animal> animals) {
        super(animals);
    }

    public DairyCowShed(Collection<Animal> animals, MilkingMachine machine, MilkTank tank) {
        super(animals, machine, tank);
    }

    @Override
    public String toString() {
        return "DairyCowShed{" +
                super.toString() +
                '}';
    }
}
