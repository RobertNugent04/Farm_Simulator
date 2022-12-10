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


                //ArrayList to hold all the goats
                ArrayList<Goat> goats = new ArrayList<>();
                ArrayList<Sheep> sheep = new ArrayList();
                ArrayList<DairyCow> dairycows = new ArrayList<>();
                ArrayList<BeefCow> beefcows = new ArrayList();
                //Create arrayList of animals which will be put in the goat shed
                ArrayList<Animal> animals1 = new ArrayList<>();
                //Create arrayList of animals which will be put in the goat shed
                ArrayList<Animal> animals2 = new ArrayList<>();

                Farm farm1 = null;
                Goat g1 = null;
                Sheep s1 = null;
                DairyCow dc1 = null;
                BeefCow bc1 = null;
                GoatShed goatShed = new GoatShed();
                DairyCowShed dcShed = new DairyCowShed();
                MilkTank mt2 = null;

                String ObjectType = "";

                while (sc.hasNext()) {

                    try {

                        ObjectType = sc.next();

                        if (ObjectType.equals("Farm")) {
                            farm1 = new Farm(sc.next());

                        }else if (ObjectType.equals("Goat")) {
                                //Make goats with values from file
                                g1 = new Goat(sc.nextInt(), sc.nextDouble());
                                goats.add(g1);
                                animals1.add(g1);

                        } else if (ObjectType.equals("Sheep")) {

                            s1 = new Sheep(sc.nextInt(), sc.nextInt(), sc.nextInt());
                            sheep.add(s1);
                            animals1.add(s1);

                        } else if (ObjectType.equals("DairyCow")) {
                            dc1 = new DairyCow(sc.nextInt(), sc.nextDouble());
                            dairycows.add(dc1);
                            animals2.add(dc1);

                        } else if (ObjectType.equals("NamedDairyCow")) {
                            dc1 = new DairyCow(sc.next(), sc.nextInt(), sc.nextDouble());
                            dairycows.add(dc1);
                            animals2.add(dc1);

                        } else if (ObjectType.equals("BeefCow")) {
                            bc1 = new BeefCow(sc.nextInt(), sc.nextDouble(), sc.nextInt());
                            beefcows.add(bc1);
                            animals2.add(bc1);

                        }else if (ObjectType.equals("CowTank")){
                            mt2 = new MilkTank(sc.nextInt());
                            dcShed.setTank(mt2);
                        }

                    } catch (InputMismatchException ex) {
                        System.out.println("Mismatch");
                        sc.next();   //move cursor on to next token in file
                    }
                }

                goatShed.setAnimals(animals1);

                MilkTank mt1 = new MilkTank();

                goatShed.setTank(mt1);

                dcShed.setAnimals(animals2);

                ArrayList<Shed> sheds = new ArrayList<>();
                sheds.add(goatShed);
                sheds.add(dcShed);

                farm1.setSheds(sheds);

                FarmApp.app(farm1, sheds, dcShed, goatShed, animals1, animals2, goats, dairycows, sheep, beefcows);

                done = true;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }


}



