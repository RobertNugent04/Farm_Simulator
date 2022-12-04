public class Sheep extends Animal {

    private int pedigree;

    private int age;

    public Sheep() {

    }

    public Sheep(double weight, int pedigree, int age) {
        super(weight);
        this.pedigree = pedigree;
        this.age = age;
    }

    public int getPedigree() {
        return pedigree;
    }

    public void setPedigree(int pedigree) {
        this.pedigree = pedigree;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                super.toString() +
                ", pedigree=" + pedigree +
                ", age=" + age +
                '}';
    }
}
