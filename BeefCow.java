public class BeefCow extends Animal implements Comparable<BeefCow>{

    //Pedigree is a number which refers to a certain type of ancestry. The higher the number, the better the pedigree.
    private int pedigree;

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

            //If pedigrees are equal then sort by weight
        } else if (Double.compare(this.getWeight(), bc.getWeight()) != 0) {
            return Double.compare(this.getWeight(), bc.getWeight());

            //If weights are equal then sort by age
        }else{

            return Integer.compare(this.getAge(), bc.getAge());

        }
    }
}
