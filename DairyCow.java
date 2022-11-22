import java.util.Random;

public class DairyCow extends Animal{

    Random rand = new Random();

    public static int dairyId;
    public static int idCount = 1;

    private String name;

    private int udderCapacity;

    public DairyCow() {
    }

    public DairyCow(String name) {
        this.name = name;
        this.udderCapacity = rand.nextInt(40 - 20) + 20;
        this.dairyId = idCount;
        idCount++;
    }

    public String getName() {
        return name;
    }

    public int getUdderCapacity() {
        return udderCapacity;
    }

    @Override
    public String toString() {
        return "DairyCow{" +
                "name='" + name + '\'' +
                ", udderCapacity=" + udderCapacity +
                '}';
    }
}
