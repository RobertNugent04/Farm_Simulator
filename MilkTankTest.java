import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MilkTankTest {

    @Test
    void getCustomCapacity() {

        System.out.println("Test milk tank getter for capacity when a no-argument constructor is used");
        MilkTank mt = new MilkTank();
        int expResult = 2000;
        double actResult = mt.getCustomCapacity();
        assertEquals(expResult, actResult);

        System.out.println("Test milk tank getter for capacity when it is declared in parameter");
        MilkTank mt2 = new MilkTank(4000);
        expResult = 4000;
        actResult = mt2.getCustomCapacity();
        assertEquals(expResult, actResult);

    }

    @Test
    void emptyTank() {

        System.out.println("Test milk tank emptyTank() method");
        MilkTank mt = new MilkTank();
        mt.setAmountInTank(1000);
        mt.emptyTank();
        int expResult = 0;
        double actResult = mt.getAmountInTank();
        assertEquals(expResult, actResult);

    }

    @Test
    void addToTank() {

        System.out.println("Test milk tank addToTank() method");
        MilkTank mt = new MilkTank();
        mt.addToTank(1500);
        int expResult = 1500;
        double actResult = mt.getAmountInTank();
        assertEquals(expResult, actResult);

    }

    @Test
    void getFromTank() {

        System.out.println("Test milk tank getFromTank() method");
        MilkTank mt = new MilkTank(5000);
        mt.setAmountInTank(4000);
        mt.getFromTank(500);
        int expResult = 3500;
        double actResult = mt.getAmountInTank();
        assertEquals(expResult, actResult);

    }
}