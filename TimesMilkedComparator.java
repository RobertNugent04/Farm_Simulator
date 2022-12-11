import java.util.Comparator;

//Class to compare milkables based on the number of times they have been milked
public class TimesMilkedComparator implements Comparator<Milkable> {
    /**
     * @param m1 the first object to be compared.
     * @param m2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Milkable m1, Milkable m2) {
        return Integer.compare(m1.NumTimesMilked(),m2.NumTimesMilked());
    }
}
