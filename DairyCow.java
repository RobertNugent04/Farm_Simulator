import java.util.Objects;
import java.util.Random;

public class DairyCow extends Animal implements Milkable, Comparable<DairyCow> {

    //String array filled with random names to be given to the cows
    static final String[] names = new String[]{"Mary", "Maxine", "Ivy", "Elena", "Fiona"};

    //Dairy cows are the only animals which have names
    private String name;

    private int udderCapacity;

    private int timesMilked;

    public DairyCow(){

    }

    public DairyCow(int age, double weight) {
        super(age, weight);
        Random rand = new Random();
        //Picks a random name from the array
        this.name = names[rand.nextInt(names.length)];
        this.udderCapacity = rand.nextInt(40 - 20) + 20;
        this.timesMilked = 0;

    }

    public DairyCow(String name, int age, double weight) {
        super(age, weight);
        Random rand = new Random();
        this.name = name;
        this.udderCapacity = rand.nextInt(40 - 20) + 20;
        this.timesMilked = 0;

    }

    public String getName() {
        return name;
    }

    public int getUdderCapacity() {
        return udderCapacity;
    }

    public int getTimesMilked() {
        return timesMilked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUdderCapacity(int udderCapacity) {
        this.udderCapacity = udderCapacity;
    }

    public void setTimesMilked(int timesMilked) {
        this.timesMilked = timesMilked;
    }

    //Two dairy cows are the same if they have the same name and udder capacity
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DairyCow)) return false;
        DairyCow dairyCow = (DairyCow) o;
        //Two dairy cows are considered equal if they have the same udder capacity and name
        return getUdderCapacity() == dairyCow.getUdderCapacity() && getName().equals(dairyCow.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getUdderCapacity());
    }

    @Override
    public double milkProduced(){

        return this.udderCapacity;

    }

    @Override
    public int NumTimesMilked(){

        return this.timesMilked;

    }

    @Override
    public void milked(){

        this.setTimesMilked(this.timesMilked + 1);

    }

    @Override
    public String toString() {
        return "DairyCow{" +
                "name='" + name + '\'' +
                ", udderCapacity = " + udderCapacity + " liters" +
                ", times milked = " + timesMilked +
                super.toString() +
                '}';
    }

    /**
     * @param dc the object to be compared.
     * @return
     */
    //Compare cows based on their udder capacity
    @Override
    public int compareTo(DairyCow dc) {
        return Double.compare(this.udderCapacity, dc.udderCapacity);
    }
}
