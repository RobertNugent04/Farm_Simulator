import java.util.Collection;

public class GoatShed extends Shed{

    //A goat shed stores only the goats so that they can be milked separately from the cows
        private MilkingMachine machine;

        private MilkTank tank;

        private Collection<Goat> goats;

        public GoatShed() {
        }

        public GoatShed(MilkTank tank) {
            this.tank = tank;
        }

        public GoatShed(Collection<Goat> goats, MilkingMachine machine, MilkTank tank) {
            this.goats = goats;
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

        public void milkAnimal(Collection<Goat> goats){

            for (int i = 0; i < goats.size(); i = 0){

                    this.tank.addToTank(((Milkable)goats.toArray()[i]).milkProduced());


            }

        }

    }
