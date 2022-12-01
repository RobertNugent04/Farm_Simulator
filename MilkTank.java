public class MilkTank{

    private double customCapacity;

    private double amountInTank;

    public static final int STANDARD_CAPACITY = 2000;

    public MilkTank() {

        this.customCapacity = STANDARD_CAPACITY;
        amountInTank = STANDARD_CAPACITY;

    }

    public MilkTank(double customCapacity) {
        this.customCapacity = customCapacity;
        this.amountInTank = 0;
    }

    public double getCustomCapacity() {
        return customCapacity;
    }

    public double getRemainingCapacity() {
        return amountInTank;
    }

    public void setCustomCapacity(double customCapacity) {
        this.customCapacity = customCapacity;
    }

    public void setAmountInTank(double amountInTank) {
        this.amountInTank = amountInTank;
    }

    public double freeSpace(){

        //Empty the tank
        this.setAmountInTank(0);

        return this.amountInTank;

    }

    public void addToTank(double amount){

        //If the tank runs out of space then you cannot add any more milk
        if(this.amountInTank + amount > customCapacity){

            this.setAmountInTank(customCapacity);

        }
        else {

            this.setAmountInTank(this.amountInTank + amount);

        }

    }

    public double getFromTank(double amount){

        //You cannot take more milk than is available
        if(this.amountInTank - amount < 0){

            this.setAmountInTank(0);

        }

        else{

            this.setAmountInTank(this.amountInTank - amount);

        }

        return this.amountInTank;
    }

    @Override
    public String toString() {
        return "MilkingMachine{" +
                "customCapacity=" + customCapacity +
                '}';
    }

}
