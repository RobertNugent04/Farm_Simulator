import java.util.Collection;

//A dairy cow shed stores only the dairy cows so that they are milked separately from the goats
public class DairyCowShed extends Shed{

    private MilkingMachine machine;

    private MilkTank tank;

    public DairyCowShed() {
    }

    public DairyCowShed(MilkTank tank) {
        this.tank = tank;
    }

    public DairyCowShed(Collection<Animal> animals) {
        super(animals);
    }

    public DairyCowShed(Collection<Animal> animals, MilkingMachine machine, MilkTank tank) {
        super(animals);
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

    public void setTank(MilkTank tank) {
        this.tank = tank;
    }

    public MilkingMachine getMachine() {
        return machine;
    }

    public void setMachine(MilkingMachine machine) {
        this.machine = machine;
    }

    public void milkAnimal(Milkable animal){

        this.machine.milk(animal);

    }

    public void milkAnimal(Collection<Animal> animals){

        for (int i = 0; i < animals.size(); i++){

            if(animals.toArray()[i] instanceof Milkable){
                this.tank.addToTank(((Milkable)animals.toArray()[i]).milkProduced());
            }

        }

    }

    @Override
    public String toString() {
        return "DairyCowShed{" +
                super.toString() +
                "Milking machine = " + machine +
                ", tank=" + tank +
                '}';
    }
}
