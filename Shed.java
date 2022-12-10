import java.util.ArrayList;
import java.util.Collection;

//There will only be 2 sheds on a farm: a dairy cow shed and a goat shed. These two sheds keep the dairy cows and goats separated so that their milk don't get mixed in the milk tanks.
//Other animals are also put in these two sheds along with the dairy cows and goats
public abstract class Shed{

    public int shedId;

    public static int idCount = 1;

    private Collection<Animal> animals;

    private MilkingMachine machine;

    private MilkTank tank;

    public Shed() {
        this.shedId = idCount;
        idCount++;
    }

    public Shed(Collection<Animal> animals) {
        this.animals = animals;
        this.shedId = idCount;
        idCount++;
    }

    public Shed(MilkTank tank) {
        this.tank = tank;
    }

    public Shed(Collection<Animal> animals, MilkingMachine machine, MilkTank tank) {
        this.animals = animals;
        this.machine = machine;
        this.tank = tank;
        this.shedId = idCount;
        idCount++;
    }

    public int getShedId() {
        return shedId;
    }

    public Collection<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Collection<Animal> animals) {
        this.animals = animals;
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
        return "shedId = " + shedId +
                ", animals=" + animals +
                '}';
    }
}
