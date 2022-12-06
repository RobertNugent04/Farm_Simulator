public class BeefCow extends Animal{

    private int pedigree;

    private int age;

    public BeefCow() {
    }

    public BeefCow(int age, double weight, int pedigree) {
        super(age, weight);
        this.pedigree = pedigree;
    }

    public int getPedigree() {
        return pedigree;
    }

    public void setPedigree(int pedigree) {
        this.pedigree = pedigree;
    }

    @Override
    public String toString() {
        return "BeefCow{" +
                super.toString() +
                ", pedigree=" + pedigree +
                '}';
    }
}
