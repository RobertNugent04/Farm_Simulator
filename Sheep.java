public class Sheep extends Animal {

    private int pedigree;

    private int age;

    public Sheep() {

    }

    public Sheep(int age, double weight, int pedigree) {
        super(age, weight);
        this.pedigree = pedigree;
        this.age = age;
    }

    public int getPedigree() {
        return pedigree;
    }

    public void setPedigree(int pedigree) {
        this.pedigree = pedigree;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                super.toString() +
                ", pedigree=" + pedigree +
                '}';
    }
}
