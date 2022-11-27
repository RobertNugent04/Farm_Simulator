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

    public void milk(Milking animal){

        //An animal cannot be milked more than 5 times a day
        if(animal instanceof Milking && animal.timesMilked() < 6){
            this.MilkTank.addToTank((animal.milkProduced())/5);
            animal.milked();
        }

    }

}
