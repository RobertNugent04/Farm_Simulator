import java.util.ArrayList;

public class Farm {


    public static int farmId;
    public static int idCount = 1;

    private String owner;

    private Object shed;

    private ArrayList<Animal> animals;

    public Farm() {
    }

    public Farm(String owner, Object shed, ArrayList<Animal> animals) {
        this.owner = owner;
        this.shed = shed;
        this.animals = animals;
        this.farmId = idCount;
        idCount++;
    }

    public static int getFarmId() {
        return farmId;
    }

    public static void setFarmId(int heaterId) {
        Farm.farmId = heaterId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Object getShed() {
        return shed;
    }

    public void setShed(Object shed) {
        this.shed = shed;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "id=" + farmId +
                "owner='" + owner + '\'' +
                ", shed=" + shed +
                ", animals=" + animals +
                '}';
    }

}
