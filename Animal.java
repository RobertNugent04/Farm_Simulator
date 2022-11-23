public abstract class Animal{

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
        return "Animal{" +
                "weight=" + weight +
                '}';
    }

}
