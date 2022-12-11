import java.util.Objects;

public abstract class Animal{

    //All animals get ids which are inherited from this class
    private int id;

    public static int idCount = 1;

    //All animals have an age and weight
    private int age;

    private double weight;

    public Animal() {
    }

    public Animal(int age, double weight) {
        this.age = age;
        this.weight = weight;
        this.id = idCount;
        idCount++;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    //Two animals will never have the same id so if they do then they are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        //Two animals are equal if they have the same id
        return getId() == animal.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return " id = " + id +
                ", age = " + age +
                ", weight=" + weight + "kg";
    }


}

