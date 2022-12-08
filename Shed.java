import java.util.ArrayList;
import java.util.Collection;

//There will only be 2 sheds on a farm: a dairy cow shed and a goat shed. These two sheds keep the dairy cows and goats separated so that their milk don't get mixed in the milk tanks.
//Other animals are also put in these two sheds along with the dairy cows and goats
public abstract class Shed{

    public int shedId;

    public static int idCount = 1;

    private Collection<Animal> animals;

    public Shed() {
        this.shedId = idCount;
        idCount++;
    }

    public Shed(Collection<Animal> animals) {
        this.animals = animals;
        this.shedId = idCount;
        idCount++;
    }

    public Collection<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Collection<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "shedId = " + shedId +
                ", animals=" + animals +
                '}';
    }
}
