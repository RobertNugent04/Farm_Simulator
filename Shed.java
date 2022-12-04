import java.util.ArrayList;
import java.util.Collection;

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

    @Override
    public String toString() {
        return "shedId=" + shedId +
                "animals=" + animals +
                '}';
    }
}
