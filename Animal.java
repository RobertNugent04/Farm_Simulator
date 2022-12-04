public abstract class Animal{

    //Only dairy cows and goats are getting ids, therefore ids are not inherited from the animal class

    //I am assuming that weight is the only common field between all the animals
    private double weight;

    public Animal() {
    }

    public Animal(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "weight=" + weight;
    }

}
