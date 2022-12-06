public abstract class Animal{

    //Only dairy cows and goats are getting ids, therefore ids are not inherited from the animal class

    //I am assuming that weight is the only common field between all the animals
    private int id;

    public static int idCount = 1;

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

    @Override
    public String toString() {
        return  " id = " + id +
                ", age = " + age +
                ", weight=" + weight + "kg";
    }

}
