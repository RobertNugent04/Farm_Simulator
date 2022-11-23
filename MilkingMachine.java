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

        if(animal instanceof Milking){
            this.MilkTank.addToTank(((Milking)animal).milkProduced());
        }
        else{
            System.out.println("Animal does not produce milk");
        }

    }

}
