import java.util.Objects;

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
        if(animal.NumTimesMilked() < 5){
            this.MilkTank.addToTank((animal.milkProduced())/5);
            animal.milked();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilkingMachine)) return false;
        MilkingMachine that = (MilkingMachine) o;
        //Two milking machines are equal if they have the same id
        return machineId == that.machineId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(machineId);
    }

    @Override
    public String toString() {
        return "{MachineId = " + machineId + "}";
    }

}



