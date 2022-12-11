import java.util.Comparator;

//Class to compare dairy cows based on their names
public class DairyCowNameComparator implements Comparator<DairyCow> {

    /**
     * @param d1 the first object to be compared.
     * @param d2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(DairyCow d1, DairyCow d2) {
            return d1.getName().compareTo(d2.getName());

    }
}
