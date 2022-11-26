public class BeefCow extends Animal{

    private String pedigree;

    private int age;

    public BeefCow() {
    }

    public BeefCow(double weight, String pedigree) {
        super(weight);
        this.pedigree = pedigree;
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
