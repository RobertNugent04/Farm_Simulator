public class MilkTank{

    private double customCapacity;

    private double remainingCapacity;

    public static final int STANDARD_CAPACITY = 2000;

    public MilkTank() {

        this.customCapacity = STANDARD_CAPACITY;
        remainingCapacity = STANDARD_CAPACITY;

    }

    public MilkTank(double customCapacity) {
        this.customCapacity = customCapacity;
        this.remainingCapacity = customCapacity;
    }

    public double getCustomCapacity() {
        return customCapacity;
    }

    public double getRemainingCapacity() {
        return remainingCapacity;
    }

    public double freeSpace(){

        //Empty the tank
        this.remainingCapacity = this.customCapacity;

        return this.remainingCapacity;

    }

    public void addToTank(double amount){

        //If the tank runs out of space then you cannot add any more milk
        if(this.remainingCapacity - amount < 0){

            this.remainingCapacity = 0;

        }
        else {

            this.remainingCapacity = this.remainingCapacity - amount;

        }

    }

    public double getFromTank(double amount){

        //You cannot take more milk than is available
        if(this.remainingCapacity + amount > customCapacity){

            this.remainingCapacity = this.customCapacity;

        }

        else{

            this.remainingCapacity = this.remainingCapacity + amount;

        }

        return this.remainingCapacity;
    }

    @Override
    public String toString() {
        return "MilkingMachine{" +
                "customCapacity=" + customCapacity +
                '}';
    }

}
