import java.util.Collection;

//A milking shed stores the animals which can be milked (dairy cows and goats)
public class DairyCowShed extends Shed{

    private MilkingMachine machine;

    private MilkTank tank;

    private Collection<DairyCow> cows;

    public DairyCowShed() {
    }

    public DairyCowShed(MilkTank tank) {
        this.tank = tank;
    }

    public DairyCowShed(Collection<DairyCow> cows, MilkingMachine machine, MilkTank tank) {
        this.cows = cows;
        this.machine = machine;
        this.tank = tank;
    }

    public MilkTank getTank() {
        return tank;
    }

    public void installMilkingMachine(MilkingMachine milkingMachine){

        this.machine = milkingMachine;
        this.machine.setMilkTank(tank);

    }

    public void milkAnimal(Animal animal){

        this.machine.milk(animal);

    }

    public void milkAnimal(Collection<Animal> animals){

        for (int i = 0; i < animals.size(); i = 0){

            if(animals.toArray()[i] instanceof Milking){
                this.tank.addToTank(((Milking)animals.toArray()[i]).milkProduced());
            }

        }

    }

}