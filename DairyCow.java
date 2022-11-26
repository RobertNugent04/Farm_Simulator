import java.util.Random;

public class DairyCow extends Animal implements Milking{

    Random rand = new Random();

    String[] names = new String[]{"Mary, Maxine, Ivy, Elena, Fiona"};

    public static int dairyId;
    public static int idCount = 1;

    private String name;

    private int udderCapacity;

    private int timesMilked;

    public DairyCow() {

        this.name = names[rand.nextInt(names.length)];
        this.udderCapacity = rand.nextInt(40 - 20) + 20;
        this.timesMilked = 0;
        this.dairyId = idCount;
        idCount++;

    }

    public DairyCow(String name) {

        this.name = name;
        this.udderCapacity = rand.nextInt(40 - 20) + 20;
        this.timesMilked = 0;
        this.dairyId = idCount;
        idCount++;

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

    public void setRand(Random rand) {
        this.rand = rand;
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
    public String toString() {
        return "DairyCow{" +
                "name='" + name + '\'' +
                ", udderCapacity=" + udderCapacity +
                '}';
    }
}
