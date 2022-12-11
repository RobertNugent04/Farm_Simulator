import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FarmTest {

    @Test
    void getFarmId() {

        System.out.println("Test farm getter for id");
        Farm f = new Farm();
        int expResult = 1;
        double actResult = f.getFarmId();
        assertEquals(expResult, actResult);

        System.out.println("Test farm getter for id of second farm");
        Farm f2 = new Farm();
        expResult = 2;
        actResult = f2.getFarmId();
        assertEquals(expResult, actResult);

    }

    @Test
    void getOwner() {

        System.out.println("Test farm getter for owner name");
        Farm f = new Farm("Robert");
        String expResult = "Robert";
        String actResult = f.getOwner();
        assertEquals(expResult, actResult);

    }

    @Test
    void setOwner() {

        System.out.println("Test farm setter for owner name");
        Farm f = new Farm("Robert");
        f.setOwner("Daisy");
        String expResult = "Daisy";
        String actResult = f.getOwner();
        assertEquals(expResult, actResult);

    }
}