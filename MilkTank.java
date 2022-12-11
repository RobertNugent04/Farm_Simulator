import java.util.Objects;

public class MilkTank{

    private double customCapacity;

    private double amountInTank;

    //Default capacity of a tank as said in brief
    public static final int STANDARD_CAPACITY = 2000;

    public MilkTank() {
        this.customCapacity = STANDARD_CAPACITY;
        amountInTank = 0;
    }

    public MilkTank(double customCapacity) {
        this.customCapacity = customCapacity;
        this.amountInTank = 0;
    }

    public double getCustomCapacity() {
        return customCapacity;
    }

    public double getAmountInTank() {
        return amountInTank;
    }

    public void setCustomCapacity(double customCapacity) {
        this.customCapacity = customCapacity;
    }

    public void setAmountInTank(double amountInTank) {
        this.amountInTank = amountInTank;
    }

    //Was originally called freeSpace() in the brief, but I renamed it to emptyTank() to make it clearer what happens within the method
    public double emptyTank(){

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilkTank)) return false;
        MilkTank milkTank = (MilkTank) o;
        //Two milk tanks are equal if they have the same capacity and amount in tank
        return Double.compare(milkTank.getCustomCapacity(), getCustomCapacity()) == 0 && Double.compare(milkTank.getAmountInTank(), getAmountInTank()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomCapacity(), getAmountInTank());
    }

    @Override
    public String toString() {
        return "MilkTank{" +
                "customCapacity=" + customCapacity +
                ", amountInTank=" + amountInTank +
                '}';
    }
}
