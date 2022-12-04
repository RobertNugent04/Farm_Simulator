import java.util.Random;

public class DairyCow extends Animal implements Milkable {

    //String array filled with random names to be given to the cows
    static String[] names = new String[]{"Mary", "Maxine", "Ivy", "Elena", "Fiona"};

    //Dairy cows have separate ids from goats
    private int dairyId;
    public static int idCount = 1;

    private String name;

    private int udderCapacity;

    private int timesMilked;

    public DairyCow(double weight) {
        Random rand = new Random();
        //Picks a random name from the array
        this.name = names[rand.nextInt(names.length)];
        this.udderCapacity = rand.nextInt(40 - 20) + 20;
        this.timesMilked = 0;
        this.dairyId = idCount;
        idCount++;

    }

    public DairyCow(String name, double weight) {
        super(weight);
        Random rand = new Random();
        this.name = name;
        this.udderCapacity = rand.nextInt(40 - 20) + 20;
        this.timesMilked = 0;
        this.dairyId = idCount;
        idCount++;

    }

    public int getDairyId() {
        return dairyId;
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

    @Override
    public double milkProduced(){

        return this.udderCapacity;

    }

    @Override
    public int timesMilked(){

        return this.timesMilked;

    }

    @Override
    public void milked(){

        this.setTimesMilked(this.timesMilked++);

    }

    @Override
    public String toString() {
        return "DairyCow{" +
                "name='" + name + '\'' +
                ", udderCapacity=" + udderCapacity +
                super.toString() +
                '}';
    }
}
