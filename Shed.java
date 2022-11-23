import java.util.Collection;

public class Shed {

    public static int shedId;
    public static int idCount = 1;

    private MilkingMachine machine;

    private MilkTank tank;

    public Shed() {
    }

    public Shed(MilkTank tank) {
        this.tank = tank;
        this.shedId = idCount;
        idCount++;
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

    @Override
    public String toString() {
        return "Shed{" +
                "shedId=" + shedId +
                ", machine=" + machine +
                ", tank=" + tank +
                '}';
    }
}
