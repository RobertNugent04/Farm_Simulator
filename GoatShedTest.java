import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoatShedTest {

    @Test
    void getShedId() {

        System.out.println("Test goat shed getter for id when first instance is created");
        GoatShed gs = new GoatShed();
        int expResult = 1;
        int actResult = gs.getShedId();
        assertEquals(expResult, actResult);

        System.out.println("Test goat shed getter for id when another instance is created");
        GoatShed gs2 = new GoatShed();
         expResult = 2;
         actResult = gs2.getShedId();
        assertEquals(expResult, actResult);

    }

    @Test
    void installMilkingMachine() {

        System.out.println("Test goat shed method for installing a milk tank");
        GoatShed gs = new GoatShed();
        MilkingMachine m = new MilkingMachine();
        gs.installMilkingMachine(m);
        MilkingMachine expResult = m;
        MilkingMachine actResult = gs.getMachine();
        assertEquals(expResult, actResult);

    }
}