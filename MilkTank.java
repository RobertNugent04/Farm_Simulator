public class MilkTank{

    private double customCapacity;

    private double remainingCapacity;

    public MilkTank() {
    }

    public MilkTank(double customCapacity) {
        this.customCapacity = customCapacity;
        this.remainingCapacity = customCapacity;
    }

    public double getCustomCapacity() {
        return customCapacity;
    }

    public double getRemaingCapacity() {
        return remainingCapacity;
    }

    public double freeSpace(){

        this.remainingCapacity = this.customCapacity;

        return this.remainingCapacity;

    }

    public void addToTank(double amount){

        this.remainingCapacity = this.remainingCapacity - amount;

    }

    public double getFromTank(double amount){

        this.remainingCapacity = this.remainingCapacity + amount;

        return this.remainingCapacity;
    }

    @Override
    public String toString() {
        return "MilkingMachine{" +
                "customCapacity=" + customCapacity +
                '}';
    }

}
