import static org.junit.jupiter.api.Assertions.*;

class DairyCowTest {

    @org.junit.jupiter.api.Test
    void getName() {

        System.out.println("Test dairy cow getter for name");
        String name = "Daisy";
        DairyCow dc = new DairyCow(name, 12, 700);
        String expResult = "Daisy";
        String actResult = dc.getName();
        assertEquals(expResult, actResult);

    }

    @org.junit.jupiter.api.Test
    void setUdderCapacity() {

        System.out.println("Test dairy cow setter for udder capacity");
        int capacity = 5000;
        DairyCow dc = new DairyCow("Daisy", 12, 700);
        dc.setUdderCapacity(capacity);
        int expResult = 5000;
        int actResult = dc.getUdderCapacity();
        assertEquals(expResult, actResult);

    }

    @org.junit.jupiter.api.Test
    void equals() {

        System.out.println("Test equals method when cows are different");
        String name = "Daisy";
        DairyCow dc = new DairyCow(name, 12, 700);
        DairyCow dc2 = new DairyCow("Ivy", 15, 800);
        boolean expResult = false;
        boolean actResult = dc.equals(dc2);
        assertEquals(expResult, actResult);

        System.out.println("Test equals method when cows are equal");
        dc2.setUdderCapacity(dc.getUdderCapacity());
        dc2.setName(name);
        expResult = true;
        actResult = dc.equals(dc2);
        assertEquals(expResult, actResult);
    }
}