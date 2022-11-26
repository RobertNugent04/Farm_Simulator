public class Sheep extends Animal {

    private String pedigree;

    private int age;

    public Sheep() {

    }

    public Sheep(double weight, String pedigree, int age) {
        super(weight);
        this.pedigree = pedigree;
        this.age = age;
    }

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
