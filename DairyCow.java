import java.util.Random;

public class DairyCow extends Animal implements Milking{

    Random rand = new Random();

    String[] names = new String[]{"Mary, Maxine, Ivy, Elena, Fiona"};

    public static int dairyId;
    public static int idCount = 1;

    private String name;

    private int udderCapacity;

    public DairyCow() {

        this.name = names[rand.nextInt(names.length)];
        this.udderCapacity = rand.nextInt(40 - 20) + 20;
        this.dairyId = idCount;
        idCount++;

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
    public double milkProduced(){

        return this.udderCapacity;

    }

    @Override
    public String toString() {
        return "DairyCow{" +
                "name='" + name + '\'' +
                ", udderCapacity=" + udderCapacity +
                '}';
    }
}
