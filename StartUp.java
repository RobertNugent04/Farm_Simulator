import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StartUp {

    public static void main(String[] args) throws FileNotFoundException {

        boolean done = false;

        try (Scanner sc = new Scanner(new File("StartUp.txt"))) {
            while (done == false) {

                while (sc.hasNext()) {

                    try {

                        Farm farm1 = new Farm(sc.nextLine());

                        //Make goats with values from file
                        Goat g1 = new Goat(sc.nextDouble());
                        Goat g2 = new Goat(sc.nextDouble());
                        Goat g3 = new Goat(sc.nextDouble());
                        Goat g4 = new Goat(sc.nextDouble());

                        //ArrayList with all the goats
                        ArrayList<Goat> goats = new ArrayList<>();
                        goats.add(g1);
                        goats.add(g2);
                        goats.add(g3);
                        goats.add(g4);

                        //Make sheep with values from file
                        Sheep s1 = new Sheep(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        Sheep s2 = new Sheep(sc.nextInt(), sc.nextInt(), sc.nextInt());

                        //Create arrayList of animals which will be put in the dairy cow shed
                        ArrayList<Animal> animals1 = new ArrayList<>();
                        animals1.add(g1);
                        animals1.add(g2);
                        animals1.add(g3);
                        animals1.add(g4);
                        animals1.add(s1);
                        animals1.add(s2);

                        MilkingMachine mm1 = new MilkingMachine();

                        MilkTank mt1 = new MilkTank();

                        mm1.setMilkTank(mt1);

                        //Make dairy cows with values from file
                        DairyCow dc1 = new DairyCow(sc.nextDouble());
                        DairyCow dc2 = new DairyCow(sc.nextDouble());
                        DairyCow dc3 = new DairyCow(sc.nextDouble());

                        //Move scanner forward
                        sc.nextLine();

                        DairyCow dc4 = new DairyCow(sc.next(), sc.nextDouble());

                        //ArrayList with all the cows
                        ArrayList<DairyCow> dairycows = new ArrayList<>();
                        dairycows.add(dc1);
                        dairycows.add(dc2);
                        dairycows.add(dc3);
                        dairycows.add(dc4);

                        //Make beef cows with values from file
                        BeefCow bc1 = new BeefCow(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        BeefCow bc2 = new BeefCow(sc.nextInt(), sc.nextInt(), sc.nextInt());

                        //Create arrayList of animals which will be put in the goat shed
                        ArrayList<Animal> animals2 = new ArrayList<>();
                        animals2.add(dc1);
                        animals2.add(dc2);
                        animals2.add(dc3);
                        animals2.add(dc4);
                        animals2.add(bc1);
                        animals2.add(bc2);

                        MilkingMachine mm2 = new MilkingMachine();

                        MilkTank mt2 = new MilkTank(sc.nextInt());

                        mm2.setMilkTank(mt2);

                        GoatShed goatShed = new GoatShed(animals2, mm2, mt2);
                        DairyCowShed dcShed = new DairyCowShed(animals1, mm1, mt1);

                        ArrayList<Shed> sheds = new ArrayList<>();
                        sheds.add(dcShed);
                        sheds.add(goatShed);

                        farm1.setSheds(sheds);

                        FarmApp.app(farm1, dcShed, goatShed, animals1, animals2, goats, dairycows);

                    } catch (InputMismatchException ex) {
                        System.out.println("Mismatch");
                        sc.next();   //move cursor on to next token in file
                    }
                }
                done = true;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }


}



