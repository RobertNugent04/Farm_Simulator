public class MilkTank {

    private double customCapacity;

    private double remaingCapacity;

    public MilkTank() {
    }

    public MilkTank(double customCapacity) {
        this.customCapacity = customCapacity;
        this.remaingCapacity = customCapacity;
    }

    public double getCustomCapacity() {
        return customCapacity;
    }

    public double getRemaingCapacity() {
        return remaingCapacity;
    }

    public double freeSpace(){

        this.remaingCapacity = this.customCapacity;

        return this.remaingCapacity;

    }

    public void addToTank(double amount){

        this.remaingCapacity = this.remaingCapacity - amount;

    }

    public double getFromTank(double amount){

        this.remaingCapacity = this.remaingCapacity + amount;

        return this.remaingCapacity;
    }

    @Override
    public String toString() {
        return "MilkingMachine{" +
                "customCapacity=" + customCapacity +
                '}';
    }

}
