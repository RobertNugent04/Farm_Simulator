public abstract class Animal {

    private double weight;

    private String colour;

    public Animal() {
    }

    public Animal(double weight, String colour) {
        this.weight = weight;
        this.colour = colour;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "weight=" + weight +
                ", colour='" + colour + '\'' +
                '}';
    }

}
