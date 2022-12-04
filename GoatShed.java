import java.util.Collection;

public class GoatShed extends Shed{

    //A goat shed stores only the goats so that they can be milked separately from the cows
        private MilkingMachine machine;

        private MilkTank tank;

        public GoatShed(MilkTank tank) {
            this.tank = tank;
        }

        public GoatShed(Collection<Animal> animals, MilkingMachine machine, MilkTank tank) {
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

        public void milkAnimal(Milkable animal){

            this.machine.milk(animal);

        }

        public void milkAnimal(Collection<Animal> animals){

            for (int i = 0; i < animals.size(); i = 0){

                if(animals instanceof Milkable) {
                    this.tank.addToTank(((Milkable) animals.toArray()[i]).milkProduced());
                }

            }

        }

    @Override
    public String toString() {
        return "GoatShed{" +
                super.toString() +
                "machine=" + machine +
                ", tank=" + tank +
                '}';
    }
}
