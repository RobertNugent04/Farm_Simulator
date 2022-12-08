import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class FarmApp {

    public static void app(Farm farm1, ArrayList<Shed> sheds, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows) {

        int type = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("****************************");
        System.out.println("1.Print farm details");
        System.out.println("2.See details of an animal");
        System.out.println("3.Add an animal");
        System.out.println("4.Edit an animal");
        System.out.println("5.Remove an animal");
        System.out.println("6.Report dead animal");
        System.out.println("7.Milk Collection");
        System.out.println("8.Print ordered list of animals");
        System.out.println("9.See details of a shed");
        System.out.println("10.Add a shed");
        System.out.println("11.Edit a shed");
        System.out.println("12.Delete a shed");
        System.out.println("13.Install milking machines");
        System.out.println("14.Milk an animal");
        System.out.println("15.Milk all animals on farm");
        System.out.println("0.Exit");
        System.out.println("****************************");

        System.out.println("Select an option: ");
        int option = keyboard.nextInt();

        if (option == 1) {

            System.out.println(farm1);
            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 2) {

            animalDetails(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 3) {

            addAnimal(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 4) {

            editAnimal(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 5) {

            removeAnimal(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }  else if (option == 6) {

            reportDead(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 7) {

            for (int i = 0; i < sheds.size(); i++){
                sheds.get(i).getTank().emptyTank();
            }

            System.out.println("All milk has been collected from the tanks");
            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 8) {

            orderAnimals(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 9) {

            shedDetails(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 10) {

            addShed(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 11) {

            editShed(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }else if(option == 12){

            removeShed(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }else if(option == 13){

            MilkingMachine m1 = new MilkingMachine();
            MilkingMachine m2 = new MilkingMachine();

            shed1.installMilkingMachine(m1);
            shed2.installMilkingMachine(m2);
            System.out.println("Milking machines have been installed");

            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }else if(option == 14){

            milkAnimal(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }
        else if (option == 15) {

                milkAnimals(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }
        else if (option == 0) {

            System.out.println("Exiting....");
            System.exit(0);

        }

    }

    public static void animalDetails(Farm farm1,ArrayList<Shed> sheds, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("****************************");
        System.out.println("Select a type of animal:");
        System.out.println("1.Goat/Sheep");
        System.out.println("2.Dairy cow/Beef cow");
        System.out.println("****************************");
        int type = keyboard.nextInt();

        while (type < 1 || type > 2) {

            System.out.println("Invalid type");
            System.out.println();
            System.out.println("****************************");
            System.out.println("Select a type of animal:");
            System.out.println("1.Goat/Sheep");
            System.out.println("2.Dairy cow/Beef cow");
            System.out.println("****************************");
            type = keyboard.nextInt();

        }

        System.out.println("Enter the id of the animal: ");
        int option = keyboard.nextInt();

        if (type == 1) {

            for (int i = 0; i < animals1.size(); i++) {

                if (animals1.get(i).getId() == option) {
                    System.out.println(animals1.get(i));
                    app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
                }

            }

            System.out.println("A goat/sheep cow does not exist with this id");
            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
        } else if (type == 2) {

            for (int i = 0; i < animals2.size(); i++) {

                if (animals2.get(i).getId() == option) {
                    System.out.println(animals2.get(i));
                    app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
                }
            }
            System.out.println("A dairy cow/beef cow does not exist with this id");
            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }


    }

    public static void addAnimal(Farm farm1, ArrayList<Shed> sheds, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows){

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter id of shed to add an animal to:");
        int type = keyboard.nextInt();

        System.out.println("****************************");
        System.out.println("Select a type of animal to add:");
        System.out.println("1.Goat");
        System.out.println("2.Sheep");
        System.out.println("3.Dairy cow");
        System.out.println("4.Beef Cow");
        System.out.println("****************************");
        int option = keyboard.nextInt();

        System.out.println("Enter the weight of the animal: ");
        double weight = keyboard.nextDouble();

        System.out.println("Enter the age of the animal: ");
        int age = keyboard.nextInt();

        if (sheds.get(type - 1) instanceof GoatShed && option == 1){

            Goat animal = new Goat(age, weight);

            farm1.getSheds().get(type - 1).getAnimals().add(animal);

        }else if(sheds.get(type - 1) instanceof GoatShed && option == 2){

            System.out.println("Enter the pedigree of the animal: ");
            option = keyboard.nextInt();

            Sheep animal = new Sheep(age, weight, option);

            farm1.getSheds().get(type - 1).getAnimals().add(animal);
        }

        else if(sheds.get(type - 1) instanceof DairyCowShed && option == 3){

            System.out.println("Enter the name of the animal: ");
            String name = keyboard.next();

            DairyCow animal = new DairyCow(name, age, weight);

            farm1.getSheds().get(type - 1).getAnimals().add(animal);

        } else if (sheds.get(type - 1) instanceof DairyCowShed && option == 4) {

            System.out.println("Enter the pedigree of the animal: ");
            option = keyboard.nextInt();

            BeefCow animal = new BeefCow(age, weight, option);

            farm1.getSheds().get(type - 1).getAnimals().add(animal);
        }
        else{

            System.out.println("Invalid Input");

        }

        System.out.println("Animal has been added to the farm");
        app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

    }

    public static void editAnimal(Farm farm1, ArrayList<Shed> sheds, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows) {

        int type = 0;
        Scanner keyboard = new Scanner(System.in);
        int option = 0;

        System.out.println("****************************");
        System.out.println("Select an animal to edit:");
        System.out.println("1.Goat");
        System.out.println("2.Sheep");
        System.out.println("3.Dairy Cow");
        System.out.println("4.Beef cow");
        System.out.println("****************************");
        type = keyboard.nextInt();

        System.out.println("****************************");
        System.out.println("Select what you want to edit:");
        System.out.println("1.Name");
        System.out.println("2.Age");
        System.out.println("3.Weight");
        System.out.println("4.Pedigree");
        System.out.println("5.Milk Produced");
        System.out.println("****************************");
        option = keyboard.nextInt();

        System.out.println("Enter the id of the animal you would like to edit: ");
        int id = keyboard.nextInt();

        if (type == 1) {

            if (option == 1) {

                System.out.println("This animal doesn't have a name");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 2) {

                System.out.println("Please enter the new age: ");
                option = keyboard.nextInt();

                for (int i = 0; i < goats.size(); i++) {

                    if (goats.get(i).getId() == id) {
                        goats.get(i).setAge(option);
                    }
                }
                System.out.println("The animal's age has been updated");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 3) {

                System.out.println("Please enter the new weight: ");
                double weight = keyboard.nextInt();
                ;

                for (int i = 0; i < goats.size(); i++) {

                    if (goats.get(i).getId() == id) {
                        goats.get(i).setWeight(weight);
                    }
                }
                System.out.println("The animal's weight has been updated");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 4) {

                System.out.println("This animal doesn't have a pedigree");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 5) {

                System.out.println("Enter the new amount of milk that will be produced: ");
                option = keyboard.nextInt();

                for (int i = 0; i < goats.size(); i++) {

                    if (goats.get(i).getId() == id) {
                        goats.get(i).setMilkProduced(option);
                    }
                }
                System.out.println("The amount of milk produced by the animal has been updated");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
            }

        } else if (type == 2) {

            if (option == 1) {

                System.out.println("This animal doesn't have a name");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 2) {

                System.out.println("Please enter the new age: ");
                option = keyboard.nextInt();

                for (int i = 0; i < sheep.size(); i++) {

                    if (sheep.get(i).getId() == id) {
                        sheep.get(i).setAge(option);
                    }
                }
                System.out.println("The animal's age has been updated");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 3) {

                System.out.println("Please enter the new weight: ");
                double weight = keyboard.nextInt();
                ;

                for (int i = 0; i < sheep.size(); i++) {

                    if (sheep.get(i).getId() == id) {
                        sheep.get(i).setWeight(weight);
                    }
                }
                System.out.println("The animal's weight has been updated");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 4) {

                System.out.println("Please enter the new pedigree: ");
                option = keyboard.nextInt();
                ;

                for (int i = 0; i < sheep.size(); i++) {

                    if (sheep.get(i).getId() == id) {
                        sheep.get(i).setPedigree(option);
                    }
                }
                System.out.println("The animal's pedigree has been updated");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 5) {

                System.out.println("This animal doesn't produce milk");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
            }

        } else if (type == 3) {

            if (option == 1) {

                System.out.println("Please enter the new name: ");
                String name = keyboard.nextLine();

                for (int i = 0; i < dairycows.size(); i++) {

                    if (dairycows.get(i).getId() == id) {

                        dairycows.get(i).setName(name);

                    }

                }
                System.out.println("The animal's name has been updated");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 2) {

                System.out.println("Please enter the new age: ");
                option = keyboard.nextInt();

                for (int i = 0; i < dairycows.size(); i++) {

                    if (dairycows.get(i).getId() == id) {
                        dairycows.get(i).setAge(option);
                    }
                }
                System.out.println("The animal's age has been updated");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 3) {

                System.out.println("Please enter the new weight: ");
                double weight = keyboard.nextInt();
                ;

                for (int i = 0; i < dairycows.size(); i++) {

                    if (dairycows.get(i).getId() == id) {
                        dairycows.get(i).setWeight(weight);
                    }
                }
                System.out.println("The animal's weight has been updated");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 4) {

                System.out.println("This animal doesn't have a pedigree");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 5) {

                System.out.println("Enter the new amount of milk that will be produced: ");
                option = keyboard.nextInt();

                for (int i = 0; i < dairycows.size(); i++) {

                    if (dairycows.get(i).getId() == id) {
                        dairycows.get(i).setUdderCapacity(option);
                    }
                }
                System.out.println("The amount of milk produced by the animal has been updated");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
            }

        } else if (type == 4) {

            if (option == 1) {

                System.out.println("This animal doesn't have a name");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 2) {

                System.out.println("Please enter the new age: ");
                option = keyboard.nextInt();

                for (int i = 0; i < beefcows.size(); i++) {

                    if (beefcows.get(i).getId() == id) {
                        beefcows.get(i).setAge(option);
                    }
                }
                System.out.println("The animal's age has been updated");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 3) {

                System.out.println("Please enter the new weight: ");
                double weight = keyboard.nextInt();
                ;

                for (int i = 0; i < beefcows.size(); i++) {

                    if (beefcows.get(i).getId() == id) {
                        beefcows.get(i).setWeight(weight);
                    }
                }
                System.out.println("The animal's weight has been updated");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 4) {

                System.out.println("Please enter the new pedigree: ");
                option = keyboard.nextInt();
                ;

                for (int i = 0; i < beefcows.size(); i++) {

                    if (beefcows.get(i).getId() == id) {
                        beefcows.get(i).setPedigree(option);
                    }
                }
                System.out.println("The animal's pedigree has been updated");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 5) {

                System.out.println("This animal doesn't produce milk");
                app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
            }

        }


    }

    public static void removeAnimal(Farm farm1, ArrayList<Shed> sheds, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows) {

        int type = 0;
        int option = 0;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("****************************");
        System.out.println("Select a type of animal:");
        System.out.println("1.Goat/Sheep");
        System.out.println("2.Dairy cow/Beef cow");
        System.out.println("****************************");
        type = keyboard.nextInt();

        while (type < 1 || type > 2) {

            System.out.println("Invalid type");
            System.out.println();
            System.out.println("****************************");
            System.out.println("Select a type of animal:");
            System.out.println("1.Goat/Sheep");
            System.out.println("2.Dairy cow/Beef cow");
            System.out.println("****************************");
            type = keyboard.nextInt();

        }

        System.out.println("Enter the id of the animal: ");
        option = keyboard.nextInt();

        if (type == 1 && option > -1 || option < animals1.size()) {

            animals1.remove(option);
            System.out.println("Animal removed");
            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (type == 2 && option < 0 || option > animals1.size()) {

            animals2.remove(option);
            System.out.println("Animal removed");
            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
        } else {

            System.out.println("An animal does not exist with this id");
            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }

    }

    public static void milkAnimal(Farm farm1, ArrayList<Shed> sheds, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows){

        int option = 0;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the id of the animal you want to milk:");
        option = keyboard.nextInt();

        try {
            if (option < animals1.size() && option > -1) {


                shed1.milkAnimal((Milkable) animals1.get(option));
                System.out.println("The animal has been milked");

            } else if (option < animals2.size() && option > animals1.size()) {

                shed2.milkAnimal((Milkable) animals2.get(option));
                System.out.println("The animal has been milked");

            }else{

                System.out.println("An animal with this id doesn't exist");

            }

            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }catch(ClassCastException ex){

            System.out.println("This animal cannot be milked!");
            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }catch(NullPointerException ex){
            System.out.println("Milking machines are not installed!");
            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
        }

    }

    public static void milkAnimals(Farm farm1, ArrayList<Shed> sheds, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows) throws IllegalStateException{

        shed1.milkAnimal(animals1);
        shed2.milkAnimal(animals2);
        System.out.println("All animals milked");
        app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

    }

    public static void reportDead(Farm farm1, ArrayList<Shed> sheds, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows){

        int option = 0;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the id of the animal that has died: ");
        option = keyboard.nextInt();

        if (option > -1 && option < animals1.size()) {

            animals1.remove(option);
            System.out.println("The animal has been identified as dead and has been removed from the farm");
            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option > animals1.size() && option < animals2.size()) {

            animals2.remove(option);
            System.out.println("The animal has been identified as dead and has been removed from the farm");
            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else {
            System.out.println("An animal does not exist with this id");
            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
        }

    }

    public static void orderAnimals(Farm farm1, ArrayList<Shed> sheds, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows) {

        Scanner keyboard = new Scanner(System.in);
        int best = 0;
        int value = 0;
        int size = 0;

        System.out.println("****************************");
        System.out.println("Select the herd to order:");
        System.out.println("1.Goats and Sheep");
        System.out.println("2.Dairy cows and Beef cows");
        System.out.println("****************************");
        int option = keyboard.nextInt();

        if (option == 1) {

            System.out.println("****************************");
            System.out.println("Select a value to order by:");
            System.out.println("1.Milk produced");
            System.out.println("2.Pedigree");
            System.out.println("3.Weight");
            System.out.println("4.Age");
            System.out.println("****************************");
            option = keyboard.nextInt();

            if (option == 1) {

                //Create copy of ArrayList
                ArrayList<Goat> g = goats;
                //Store original size of arrayList
                size = g.size();

                for (int j = 0; j < size; j++) {
                    best = 0;
                    for (int i = 0; i < g.size(); i++) {

                        //Find the goat with the most milk
                        if (g.get(i).getMilkProduced() > g.get(best).getMilkProduced()) {
                            best = i;
                        }

                    }

                    System.out.println(g.get(best));
                    //Remove the goat with the most milk so that it is not printed again on the next lop
                    g.remove(best);

                }
                //Print the sheep in the herd. The order doesn't matter because they do not produce milk
                for (int s = 0; s < sheep.size(); s++) {

                    System.out.println(sheep.get(s));

                }
            } else if (option == 2) {

                ArrayList<Sheep> s = sheep;
                size = s.size();

                for (int j = 0; j < size; j++) {
                    best = 0;
                    for (int i = 0; i < s.size(); i++) {


                        if (s.get(i).getPedigree() > s.get(best).getPedigree()) {
                            best = i;
                        }

                    }

                    System.out.println(s.get(best));
                    s.remove(best);

                }
                for (int z = 0; z < goats.size(); z++) {

                    System.out.println(goats.get(z));

                }
            }
        else if (option == 3) {

            ArrayList<Animal> animals = animals1;
            size = animals.size();

                for (int j = 0; j < size; j++) {
                    best = 0;
                    for (int i = 0; i < animals1.size(); i++) {


                            //Weight ordered from heaviest to lightest
                            if (animals.get(i).getWeight() > animals.get(best).getWeight()) {
                                best = i;

                            }
                    }
                    System.out.println(animals.get(best));
                    animals.remove(best);

                }

            } else if (option == 4) {

                ArrayList<Animal> animals = animals1;
                size = animals.size();

                for (int j = 0; j < size; j++) {
                    best = 0;
                    for (int i = 0; i < animals.size(); i++) {

                        //Age ordered from oldest to youngest
                        if (animals.get(i).getAge() > animals.get(best).getAge()) {
                            best = i;


                        }
                    }
                    System.out.println(animals.get(best));
                    animals.remove(best);

                }
            }} else if (option == 2) {

                System.out.println("****************************");
                System.out.println("Select a value to order by:");
                System.out.println("1.Milk produced");
                System.out.println("2.Pedigree");
                System.out.println("3.Weight");
                System.out.println("4.Age");
                System.out.println("****************************");
                option = keyboard.nextInt();

                if (option == 1) {

                    ArrayList<DairyCow> dc = dairycows;
                    size = dc.size();

                    for (int j = 0; j < size; j++) {
                        best = 0;
                        for (int i = 0; i < dc.size(); i++) {

                                if (dc.get(i).getUdderCapacity() > dc.get(best).getUdderCapacity()) {
                                    best = i;

                                }
                        }
                        System.out.println(dc.get(best));
                        dc.remove(best);
                    }

                    for (int b = 0; b < beefcows.size(); b++) {

                        System.out.println(beefcows.get(b));

                    }
                } else if (option == 2) {

                    ArrayList<BeefCow> bc = beefcows;
                    size = bc.size();

                    for (int j = 0; j < size; j++) {
                        best = 0;
                        for (int i = 0; i < bc.size(); i++) {

                                //Pedigree with the largest number is considered the best
                                if (bc.get(i).getPedigree() > bc.get(best).getPedigree()) {
                                    best = i;

                                }
                        }
                        System.out.println(sheep.get(best));
                        sheep.remove(best);

                    }

                    for (int g = 0; g < dairycows.size(); g++)

                        System.out.println(dairycows.get(g));

                } else if (option == 3) {

                    ArrayList<Animal> animals = animals2;
                    size = animals.size();

                    for (int j = 0; j < size; j++) {
                        best = 0;
                        for (int i = 0; i < animals2.size(); i++) {

                                //Weight ordered from heaviest to lightest
                                if (animals.get(i).getWeight() > animals.get(best).getWeight()) {
                                    best = i;
                                }
                        }

                        System.out.println(animals.get(best));
                        animals.remove(best);

                    }

                } else if (option == 4) {

                    ArrayList<Animal> animals = animals2;
                    size = animals.size();

                    for (int j = 0; j < size; j++) {
                        best = 0;
                        for (int i = 0; i < animals.size(); i++) {

                                //Age ordered from oldest to youngest
                                if (animals.get(i).getAge() > animals.get(best).getAge()) {
                                    best = i;


                            }
                        }
                        System.out.println(animals.get(best));
                        animals.remove(best);

                    }

                }

            }

            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }

        public static void shedDetails(Farm farm1, ArrayList<Shed> sheds, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows){

            int option = 0;
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Enter the id of the shed: ");
            option = keyboard.nextInt();

            while (option < 1 || option > sheds.size()) {

                System.out.println("Invalid Input");
                System.out.println();
                System.out.println("****************************");
                System.out.println("Select a shed:");
                System.out.println("1.Goat shed");
                System.out.println("2.Dairy cow shed");
                System.out.println("****************************");
                option = keyboard.nextInt();

            }

            System.out.println(sheds.get(option - 1));
            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }

        public static void addShed(Farm farm1, ArrayList<Shed> sheds, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows){

            Scanner keyboard = new Scanner(System.in);

            System.out.println("****************************");
            System.out.println("Select the type of shed:");
            System.out.println("1.Goat shed");
            System.out.println("2.Dairy cow shed");
            System.out.println("****************************");
            int option = keyboard.nextInt();

            System.out.println("Enter the capacity of the shed's milk tank: ");
            int capacity = keyboard.nextInt();

            MilkTank m = new MilkTank(capacity);

            if (option == 1){
                GoatShed gs = new GoatShed();
                gs.setTank(m);
                farm1.getSheds().add(gs);
            } else if (option == 2) {
                DairyCowShed ds = new DairyCowShed();
                ds.setTank(m);
                farm1.getSheds().add(ds);
            }

            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }

        public static void editShed(Farm farm1, ArrayList<Shed> sheds, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows){

            int option = 0;
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Enter the id of the shed");
            int id = keyboard.nextInt();

            while (option < 1 || option > sheds.size()) {

                System.out.println("Invalid Input");
                System.out.println();
                System.out.println("Enter the id of the shed");
                id = keyboard.nextInt();

            }

            System.out.println("****************************");
            System.out.println("Select what you want to edit:");
            System.out.println("1.Tank Capacity");
            System.out.println("****************************");
            option = keyboard.nextInt();

            while(option != 1){

                System.out.println("Invalid option!");
                System.out.println();
                System.out.println("****************************");
                System.out.println("Select what you want to edit:");
                System.out.println("1.Tank Capacity");
                System.out.println("****************************");
                option = keyboard.nextInt();

            }

            System.out.println("Enter the new tank capacity: ");
            option = keyboard.nextInt();

            while(option > 0){

                System.out.println("Invalid option!");
                System.out.println();
                System.out.println("Enter the new tank capacity: ");
                option = keyboard.nextInt();

            }

            sheds.get(id - 1).getTank().setCustomCapacity(option);
            System.out.println("Capacity Updated");

            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }

        public static void removeShed(Farm farm1, ArrayList<Shed> sheds, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows){

            int option = 0;
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Enter the id of the shed: ");
            option = keyboard.nextInt();

            while (option < 1 || option > sheds.size()) {

                System.out.println("Invalid Input");
                System.out.println();
                System.out.println("****************************");
                System.out.println("Select a shed to delete:");
                System.out.println("1.Goat shed");
                System.out.println("2.Dairy cow shed");
                System.out.println("****************************");
                option = keyboard.nextInt();

            }

            sheds.remove(option - 1);
            System.out.println("Shed deleted");

            app(farm1, sheds, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }

    }

