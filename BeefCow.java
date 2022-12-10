public class BeefCow extends Animal implements Comparable<BeefCow>{

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

    /**
     * @param bc the object to be compared.
     * @return
     */
    @Override
    public int compareTo(BeefCow bc) {

        //If pedigrees aren't equal then sort by pedigree
        if (Integer.compare(this.pedigree, bc.pedigree) != 0) {
            return Integer.compare(this.pedigree, bc.pedigree);

        } else if (Double.compare(this.getWeight(), bc.getWeight()) != 0) {
            return Double.compare(this.getWeight(), bc.getWeight());

        }else{

            return Integer.compare(this.getAge(), bc.getAge());

        }
    }
}
