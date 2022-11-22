public class MilkTank {

    private int customCapacity;

    public MilkTank() {
    }

    public MilkTank(int customCapacity) {
        this.customCapacity = customCapacity;
    }

    public int getCustomCapacity() {
        return customCapacity;
    }

    public double freeSpace(){
        return 0;
    }

    public double addToTank(double amount){

        return 0;

    }

    public double getFromTank(double amount){

        return 0;

    }

    @Override
    public String toString() {
        return "MilkingMachine{" +
                "customCapacity=" + customCapacity +
                '}';
    }
    
}
