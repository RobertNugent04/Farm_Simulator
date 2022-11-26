public class MilkingMachine {

private MilkTank MilkTank;

    public MilkingMachine() {
    }

    public Object getMilkTank() {
        return MilkTank;
    }

    public void setMilkTank(MilkTank milkTank) {
        MilkTank = milkTank;
    }

    public void milk(Animal animal){

        //An animal cannot be milked more than 5 times a day
        if(animal instanceof Milking && ((Milking)animal).timesMilked() < 6){
            this.MilkTank.addToTank(((Milking)animal).milkProduced());
        }

    }

}
