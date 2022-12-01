public class MilkingMachine {

private MilkTank MilkTank;

    public MilkingMachine() {
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

}

