import java.util.ArrayList;

public class Farm {

    public int farmId;

    public static int idCount = 1;

    private String owner;

    private ArrayList<Shed> sheds;

    public Farm() {
    }

    public Farm(String owner, ArrayList<Shed> sheds) {
        this.owner = owner;
        this.sheds = sheds;
        this.farmId = idCount;
        idCount++;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<Shed> getSheds() {
        return sheds;
    }

    public void setSheds(ArrayList<Shed> sheds) {
        this.sheds = sheds;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "owner='" + owner + '\'' +
                ", sheds=" + sheds +
                '}';
    }
}
