import java.util.Objects;

public class Sheep extends Animal implements Comparable<Sheep> {

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
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPedigree(), getAge());
    }

    @Override
    public String toString() {
        return "Sheep{" +
                super.toString() +
                ", pedigree=" + pedigree +
                '}';
    }

    /**
     * @param s the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Sheep s) {
        //If pedigrees aren't equal then compare pedigrees
        if (Integer.compare(this.pedigree, s.pedigree) != 0) {
            return Integer.compare(this.pedigree, s.pedigree);

            //If pedigrees are equal then compare weights
        } else if (Double.compare(this.getWeight(), s.getWeight()) != 0) {
            return Double.compare(this.getWeight(), s.getWeight());

        }else{
            //If weights are equal then compare ages
            return Integer.compare(this.getAge(), s.getAge());

        }
    }
}
