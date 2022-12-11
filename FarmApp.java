
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileWriter;

public class FarmApp {

    //Enum with all the different pedigrees
    enum pedigrees {
        AUROCHS,
        LIMIA,
        PODOLICA,
        PAJUNA,
        MARONESA,
        MOUFLON;

        //Method to get the value of the constants
        public int getPedigree() {

            switch (this) {
                case AUROCHS:
                    return 1;

                case LIMIA:
                    return 2;

                case PODOLICA:
                    return 3;

                case PAJUNA:
                    return 4;

                case MARONESA:
                    return 5;

                case MOUFLON:
                    return 6;

                default:
                    return 0;
            }
        }
    }

    public static void app(Farm farm1, ArrayList<Shed> sheds){

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
        System.out.println("13.Install milking machine");
        System.out.println("14.Milk an animal");
        System.out.println("15.Milk all animals on farm");
        System.out.println("16.Save details of farm");
        System.out.println("17.See pedigree reference list");
        System.out.println("0.Exit");
        System.out.println("****************************");

        System.out.println("Select an option: ");
        int option = keyboard.nextInt();

        if (option == 1) {

            System.out.println(farm1);
            app(farm1, sheds);

        } else if (option == 2) {

            animalDetails(farm1, sheds);

        } else if (option == 3) {

            addAnimal(farm1, sheds);

        } else if (option == 4) {

            editAnimal(farm1, sheds);

        } else if (option == 5) {

            removeAnimal(farm1, sheds);

        }  else if (option == 6) {

            reportDead(farm1, sheds);

        } else if (option == 7) {

            for (int i = 0; i < sheds.size(); i++){
                sheds.get(i).getTank().emptyTank();
            }

            System.out.println("All milk has been collected from the tanks");
            app(farm1, sheds);

        } else if (option == 8) {

            orderAnimals(farm1, sheds);

        } else if (option == 9) {

            shedDetails(farm1, sheds);

        } else if (option == 10) {

            addShed(farm1, sheds);

        } else if (option == 11) {

            editShed(farm1, sheds);

        } else if(option == 12){

            removeShed(farm1, sheds);

        } else if(option == 13){

            System.out.println("Enter the id of the shed to install the machine to: ");
            option = keyboard.nextInt();

            MilkingMachine m = new MilkingMachine();

            sheds.get(option - 1).installMilkingMachine(m);

            System.out.println("Milking machine has been installed");

            app(farm1, sheds);

        } else if(option == 14){

            milkAnimal(farm1, sheds);

        } else if (option == 15) {

                milkAnimals(farm1, sheds);

        }else if(option == 16){

                saveShedDetails(farm1, sheds);

        }else if(option == 17){

            pedigreeDetails(farm1,sheds);

        }

        else if (option == 0) {

            System.out.println("Exiting....");
            System.exit(0);

        }
        else{

            System.out.println("Invalid Input!");
            app(farm1, sheds);

        }

    }

    public static void animalDetails(Farm farm1,ArrayList<Shed> sheds) {

        Scanner keyboard = new Scanner(System.in);

            System.out.println("Enter the id of the animal: ");
            int option = keyboard.nextInt();

            //Create new arrayList which will hold the animals from the shed for easier access
            ArrayList<Animal> animals = new ArrayList<>();

            //Loop through sheds
            for (int i = 0; i < farm1.getSheds().size(); i++) {

                //Loop through animals
                for (int j = 0; j < farm1.getSheds().get(i).getAnimals().size(); j++) {

                    animals = (ArrayList<Animal>) sheds.get(i).getAnimals();

                    //When the animal with the selected id is found, print their details
                    if (animals.get(j).getId() == option) {

                        System.out.println(animals.get(j));
                        app(farm1, sheds);
                    }
                }

            }

        System.out.println("An animal does not exist with this id!");
        app(farm1, sheds);

    }

    public static void addAnimal(Farm farm1, ArrayList<Shed> sheds){

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter id of shed to add an animal to:");
        int type = keyboard.nextInt();

        //Check if a valid shed id was entered and catch exception if invalid
        try{

            sheds.get(type - 1);

        }catch (ArrayIndexOutOfBoundsException ex){

            System.out.println("A shed does not exist with this id!");
            addAnimal(farm1, sheds);

        }

        System.out.println("****************************");
        System.out.println("Select a type of animal to add:");
        System.out.println("1.Goat");
        System.out.println("2.Sheep");
        System.out.println("3.Dairy cow");
        System.out.println("4.Beef Cow");
        System.out.println("****************************");
        int option = keyboard.nextInt();

        //While option is invalid
        while(option < 1 || option > 4){

            System.out.println("Invalid Input!");
            System.out.println();
            System.out.println("****************************");
            System.out.println("Select a type of animal to add:");
            System.out.println("1.Goat");
            System.out.println("2.Sheep");
            System.out.println("3.Dairy cow");
            System.out.println("4.Beef Cow");
            System.out.println("****************************");
            option = keyboard.nextInt();
        }

        System.out.println("Enter the weight of the animal: ");
        double weight = keyboard.nextDouble();

        System.out.println("Enter the age of the animal: ");
        int age = keyboard.nextInt();

        //If a goat shed was selected and a goat was picked then create a new goat and add it to the shed
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

            System.out.println("Cannot add the selected animal to the shed");
            System.out.println();
            app(farm1, sheds);
        }

        System.out.println("Animal has been added to the farm");
        app(farm1, sheds);

    }

    public static void editAnimal(Farm farm1, ArrayList<Shed> sheds) {

        int animalId = 0;
        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        ArrayList<Animal> animals = new ArrayList<>();

        //Prompt user to enter id of animal
        System.out.println("Enter the id of the animal you want edit: ");
        int id = keyboard.nextInt();

            for (int i = 0; i < farm1.getSheds().size(); i++) {

                //Loop through animals to find selected animal
                for (int j = 0; j < farm1.getSheds().get(i).getAnimals().size(); j++) {

                    animals = (ArrayList<Animal>) sheds.get(i).getAnimals();

                    if (animals.get(j).getId() == id) {

                        animals = (ArrayList<Animal>) sheds.get(i).getAnimals();

                        System.out.println("****************************");
                        System.out.println("Select what you want to edit:");
                        System.out.println("1.Name");
                        System.out.println("2.Age");
                        System.out.println("3.Weight");
                        System.out.println("4.Pedigree");
                        System.out.println("5.Milk Produced");
                        System.out.println("****************************");
                        option = keyboard.nextInt();

                        if(option == 1){

                            //If it is not a dairy cow then it does not have a name
                            if (!(animals.get(j) instanceof DairyCow)) {

                                System.out.println("This animal doesn't have a name");
                                app(farm1, sheds);

                            }
                            //If it is a dairy cow then the user is prompted to enter its new name
                            else {

                                System.out.println("Enter the new name: ");
                                String name = keyboard.next();

                                ((DairyCow) animals.get(j)).setName(name);

                            }

                        } else if (option == 2) {

                            System.out.println("Please enter the new age: ");
                            option = keyboard.nextInt();

                            animals.get(j).setAge(option);

                        } else if (option == 3) {

                            System.out.println("Please enter the new weight: ");
                            double weight = keyboard.nextInt();

                            animals.get(j).setWeight(weight);

                        } else if (option == 4) {

                            //If the animal is a dairy cow or goat then it doesn't have a pedigree
                            if (animals.get(j) instanceof DairyCow || animals.get(j) instanceof Goat) {

                                System.out.println("This animal doesn't have a pedigree");
                                app(farm1, sheds);

                            } else {

                                System.out.println("Enter the new pedigree: ");
                                option = keyboard.nextInt();

                                ((BeefCow) animals.get(j)).setPedigree(option);

                            }
                        } else if (option == 5) {

                            if (animals.get(id - 1) instanceof DairyCow) {

                                System.out.println("Enter the new amount of milk that will be produced: ");
                                option = keyboard.nextInt();

                                ((DairyCow) animals.get(j)).setUdderCapacity(option);

                            } else if (animals.get(j) instanceof Goat) {

                                System.out.println("Enter the new amount of milk that will be produced: ");
                                option = keyboard.nextInt();

                                ((Goat) animals.get(j)).setMilkProduced(option);

                            }
                            else{

                                System.out.println("This animal doesn't produce milk");
                                app(farm1, sheds);
                            }
                        }

                        sheds.get(i).setAnimals(animals);
                        System.out.println("The animal's details have been updated");
                        app(farm1, sheds);


                    }
                }
            }

            System.out.println("An animal doesn't exist with this id");
    }

    public static void removeAnimal(Farm farm1, ArrayList<Shed> sheds) {

        int type = 0;
        int option = 0;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the id of the animal you want to remove: ");
        option = keyboard.nextInt();

        ArrayList<Animal> animals = new ArrayList<>();

        //Loop through sheds
        for (int i = 0; i < farm1.getSheds().size(); i++) {

            //Loop through animals to find selected animal
            for (int j = 0; j < farm1.getSheds().get(i).getAnimals().size(); j++) {

                animals = (ArrayList<Animal>) sheds.get(i).getAnimals();

                //Once the animal is found, remove it and return to the menu
                if (animals.get(j).getId() == option) {

                    ((ArrayList<Animal>) sheds.get(i).getAnimals()).remove(j);
                    System.out.println("Animal has been removed");
                    app(farm1, sheds);
                }
            }

        }

        //If the animal is not found then display an error to the user
        System.out.println("An animal does not exist with this id!");
        removeAnimal(farm1, sheds);

    }

    public static void milkAnimal(Farm farm1, ArrayList<Shed> sheds){

        int option = 0;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the id of the animal you want to milk:");
        option = keyboard.nextInt();

        ArrayList<Animal> animals = new ArrayList<>();

        try {
            //Loop through sheds
            for (int i = 0; i < farm1.getSheds().size(); i++) {

                //Loop through animals to find selected animal
                for (int j = 0; j < farm1.getSheds().get(i).getAnimals().size(); j++) {

                    animals = (ArrayList<Animal>) sheds.get(i).getAnimals();

                    if (animals.get(j).getId() == option) {

                        //Animal is cast to a milkable so that it can be milked because its original type is an arrayList of animals
                        if (((Milkable) animals.get(j)).NumTimesMilked() < 5) {
                            sheds.get(i).milkAnimal((Milkable) animals.get(j));
                            System.out.println("Animal has been milked");
                        }
                        else{
                            System.out.println("The animal cannot be milked any more today");
                        }
                        app(farm1, sheds);
                    }
                }

            }

            //Catch exception that occurs when the animal is not a milkable
        }catch(ClassCastException ex){

            System.out.println("This animal cannot be milked!");
            app(farm1, sheds);

            //Catch exception that occurs when the milking machines aren't installed
        }catch(NullPointerException ex1){
            System.out.println("Milking machines are not installed!");
            app(farm1, sheds);

            //Catch exception thrown from milkAnimal() method in MilkingMachine class
        }catch (IllegalStateException ex2){

            System.out.println("Milking machines are not installed");
            app(farm1, sheds);

        }

    }

    public static void milkAnimals(Farm farm1, ArrayList<Shed> sheds) throws IllegalStateException{

        for (int i = 0; i < sheds.size(); i++){

            sheds.get(i).milkAnimal(sheds.get(i).getAnimals());

        }

        System.out.println("All animals milked");
        app(farm1, sheds);

    }

    public static void reportDead(Farm farm1, ArrayList<Shed> sheds){

        int option = 0;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the id of the animal that has died: ");
        option = keyboard.nextInt();

        ArrayList<Animal> animals = new ArrayList<>();

        //Loop through sheds
        for (int i = 0; i < farm1.getSheds().size(); i++) {

            //Loop through animals to find selected animal
            for (int j = 0; j < farm1.getSheds().get(i).getAnimals().size(); j++) {

                animals = (ArrayList<Animal>) sheds.get(i).getAnimals();

                if (animals.get(j).getId() == option) {

                    ((ArrayList<Animal>) sheds.get(i).getAnimals()).remove(j);
                    System.out.println("The animal has been identified as dead and has been removed from the farm");
                    app(farm1, sheds);
                }
            }

        }

        System.out.println("An animal does not exist with this id!");
        removeAnimal(farm1, sheds);

    }

    public static void orderAnimals(Farm farm1, ArrayList<Shed> sheds) {

        Scanner keyboard = new Scanner(System.in);
        int option = 0;

        System.out.println("Enter the id of the shed containing the herd you want to order: ");
        int id = keyboard.nextInt();

            System.out.println("****************************");
            System.out.println("Select values to order by:");
            System.out.println("1.Milk produced, pedigree, weight and age");
            System.out.println("2.Name, pedigree, weight and age");
            System.out.println("3.Times milked, pedigree, weight and age");
            System.out.println("****************************");
            option = keyboard.nextInt();

                //Two arrayLists to separate the milkables from the non-milkables
                ArrayList<Milkable> milkables = new ArrayList<>();
                ArrayList<Animal> other = new ArrayList<>();

        try {
                //ArrayList to hold the animals in the shed
                ArrayList<Animal> animals = (ArrayList<Animal>) sheds.get(id - 1).getAnimals();

                //Loop through animals in shed to separate them into the two arrayLists
                for (int i = 0; i < sheds.get(id - 1).getAnimals().size(); i++) {

                    if (animals.get(i) instanceof Milkable) {

                        milkables.add((Milkable) animals.get(i));

                    } else {

                        other.add(animals.get(i));

                    }
                }

                    if (option == 1) {

                        //Sort the milkables in reverse order so that they go from most milk to the least milk
                        Collections.sort((ArrayList) milkables, Collections.reverseOrder());
                        Collections.sort((ArrayList) other, Collections.reverseOrder());

                    } else if (option == 2) {

                        DairyCowNameComparator nameComparator = new DairyCowNameComparator();
                        Collections.sort((ArrayList) milkables, nameComparator);
                        Collections.sort((ArrayList) other, Collections.reverseOrder());

                    } else if(option == 3){

                        //Sort the milkables in order of times milked, from least times to most
                        TimesMilkedComparator tmComparator = new TimesMilkedComparator();
                        Collections.sort((ArrayList) milkables, tmComparator);
                        Collections.sort((ArrayList) other, Collections.reverseOrder());
                     }
                    else{

                        System.out.println("Invalid Input!");
                        System.out.println();
                        orderAnimals(farm1, sheds);

                    }

                    //Catch exception that occurs when you cant sort selected animals by the values
                }catch (ClassCastException ex){

                    System.out.println("Can't sort this shed by these values!");
                    System.out.println();
                    orderAnimals(farm1, sheds);

                    //Catch exception that occurs when an invalid shed id is selected
                }catch (ArrayIndexOutOfBoundsException ex){
                    System.out.println("Invalid selection made!");
                    System.out.println();
                    orderAnimals(farm1, sheds);
                }

                    System.out.println(milkables);
                    System.out.println(other);

                app(farm1, sheds);

            }

        public static void shedDetails(Farm farm1, ArrayList<Shed> sheds){

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
            app(farm1, sheds);

        }

        public static void addShed(Farm farm1, ArrayList<Shed> sheds){

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

            System.out.println("Shed added to farm");
            app(farm1, sheds);

        }

        public static void editShed(Farm farm1, ArrayList<Shed> sheds){

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

            //While option is invalid, prompt the user to enter another option
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

            //Set the new tank capacity as entered by the user
            sheds.get(id - 1).getTank().setCustomCapacity(option);
            System.out.println("Capacity Updated");

            app(farm1, sheds);

        }

        public static void removeShed(Farm farm1, ArrayList<Shed> sheds){

            int option = 0;
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Enter the id of the shed you want to delete: ");
            option = keyboard.nextInt();

            while (option < 1 || option > sheds.size()) {

                System.out.println("Invalid Input");
                System.out.println();
                System.out.println("Enter the id of the shed you want to delete: ");
                option = keyboard.nextInt();

            }

            //The index of the shed will be the id minus one
            sheds.remove(option - 1);
            System.out.println("Shed deleted");

            app(farm1, sheds);

        }

        public static void saveShedDetails(Farm farm1, ArrayList<Shed> sheds) {

            try {
                //Create a file to store the details
                File farm = new File("newFarm.txt");
                //Initialise a file writer so that I can write to the file
                FileWriter writer = new FileWriter("newFarm.txt");
                //Write the details of the farm to the file
                writer.write(String.valueOf(farm1));
                //Close the FileWriter stream
                writer.close();

            }catch (IOException ex){

                System.out.println("Action failed to perform");

            }
            finally{
                System.out.println("Details have been saved");
                app(farm1, sheds);
            }

        }

        public static void pedigreeDetails(Farm farm1, ArrayList<Shed> sheds){

        Scanner keyboard = new Scanner(System.in);

            System.out.println("****************************");
            System.out.println("Ancestors:");
            System.out.println(pedigrees.AUROCHS.getPedigree() +  " - " + pedigrees.AUROCHS);
            System.out.println(pedigrees.LIMIA.getPedigree() +  " - " + pedigrees.LIMIA);
            System.out.println(pedigrees.PODOLICA.getPedigree() +  " - " + pedigrees.PODOLICA);
            System.out.println(pedigrees.PAJUNA.getPedigree() +  " - " + pedigrees.PAJUNA);
            System.out.println(pedigrees.MARONESA.getPedigree() +  " - " + pedigrees.MARONESA);
            System.out.println(pedigrees.MOUFLON.getPedigree() +  " - " + pedigrees.MOUFLON);
            System.out.println("****************************");
            System.out.println("Enter 0 to return to the menu: ");
            int option = keyboard.nextInt();

            while(option != 0){
                System.out.println("Invalid Input!");
                System.out.println();
                System.out.println("Enter 0 to return to the menu: ");
                option = keyboard.nextInt();
            }

            app(farm1, sheds);

        }

    }

