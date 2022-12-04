public class MilkingMachine {

private MilkTank MilkTank;

    public int machineId;

    public static int idCount = 1;

    public MilkingMachine() {

        this.machineId = idCount;
        idCount++;

    }

    public MilkTank getMilkTank() {
        return MilkTank;
    }

    public void setMilkTank(MilkTank milkTank) {
        MilkTank = milkTank;
    }

    public void milk(Milkable animal){

        //An animal cannot be milked more than 5 times a day
        if(animal.timesMilked() < 6){
            this.MilkTank.addToTank((animal.milkProduced())/5);
            animal.milked();
        }

    }

    @Override
    public String toString() {
        return "{MachineId = " + machineId + "}";
    }
}

