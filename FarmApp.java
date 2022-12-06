import java.util.ArrayList;
import java.util.Scanner;

public class FarmApp {

    public static void app(Farm farm1, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows) {

        int type = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("****************************");
        System.out.println("1.Print farm details");
        System.out.println("2.See details of an animal");
        System.out.println("3.Edit an animal");
        System.out.println("4.Remove an animal");
        System.out.println("5.Milk all animals on farm");
        System.out.println("6.Report dead animal");
        System.out.println("7.Milk Collection");
        System.out.println("8.Print ordered list of animals");
        System.out.println("0.Exit");
        System.out.println("****************************");

        System.out.println("Select an option: ");
        int option = keyboard.nextInt();

        if (option == 1) {

            System.out.println(farm1);
            app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 2) {

            animalDetails(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 3) {

            editAnimal(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 4) {

            removeAnimal(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 5) {

            shed1.milkAnimal(animals1);
            shed2.milkAnimal(animals2);
            System.out.println("All animals milked");
            app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 6) {

            System.out.println("Enter the id of the animal that has died: ");
            option = keyboard.nextInt();

            if (option > -1 && option < animals1.size()) {

                animals1.remove(option);
                System.out.println("The animal has been identified as dead and has been removed from the farm");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option > animals1.size() && option < animals2.size()) {

                animals2.remove(option);
                System.out.println("The animal has been identified as dead and has been removed from the farm");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else {
                System.out.println("An animal does not exist with this id");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
            }

        } else if (option == 7) {

            shed1.getTank().emptyTank();
            shed2.getTank().emptyTank();
            System.out.println("All milk has been collected from tanks");
            app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 8) {

            orderAnimals(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (option == 0) {

            System.out.println("Exiting....");
            System.exit(0);

        }

    }

    public static void animalDetails(Farm farm1, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows) {

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
                    app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
                }

            }

            System.out.println("A goat/sheep cow does not exist with this id");
            app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
        } else if (type == 2) {

            for (int i = 0; i < animals2.size(); i++) {

                if (animals2.get(i).getId() == option) {
                    System.out.println(animals2.get(i));
                    app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
                }
            }
            System.out.println("A dairy cow/beef cow does not exist with this id");
            app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }


    }

    public static void editAnimal(Farm farm1, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows){

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

        if (type == 1){

            if (option == 1){

                System.out.println("This animal doesn't have a name");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 2) {

                System.out.println("Please enter the new age: ");
                option = keyboard.nextInt();

                for (int i = 0; i < goats.size(); i++){

                    if (goats.get(i).getId() == id){
                        goats.get(i).setAge(option);
                    }
                }
                System.out.println("The animal's age has been updated");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 3) {

                System.out.println("Please enter the new weight: ");
                double weight = keyboard.nextInt();;

                for (int i = 0; i < goats.size(); i++){

                    if (goats.get(i).getId() == id){
                        goats.get(i).setWeight(weight);
                    }
                }
                System.out.println("The animal's weight has been updated");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            }else if (option == 4){

                System.out.println("This animal doesn't have a pedigree");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 5) {

                System.out.println("Enter the new amount of milk that will be produced: ");
                option = keyboard.nextInt();

                for (int i = 0; i < goats.size(); i++){

                    if (goats.get(i).getId() == id){
                        goats.get(i).setMilkProduced(option);
                    }
                }
                System.out.println("The amount of milk produced by the animal has been updated");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
            }

        } else if (type == 2) {

            if (option == 1){

                System.out.println("This animal doesn't have a name");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 2) {

                System.out.println("Please enter the new age: ");
                option = keyboard.nextInt();

                for (int i = 0; i < sheep.size(); i++){

                    if (sheep.get(i).getId() == id){
                        sheep.get(i).setAge(option);
                    }
                }
                System.out.println("The animal's age has been updated");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 3) {

                System.out.println("Please enter the new weight: ");
                double weight = keyboard.nextInt();;

                for (int i = 0; i < sheep.size(); i++){

                    if (sheep.get(i).getId() == id){
                        sheep.get(i).setWeight(weight);
                    }
                }
                System.out.println("The animal's weight has been updated");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            }else if (option == 4){

                System.out.println("Please enter the new pedigree: ");
                option = keyboard.nextInt();;

                for (int i = 0; i < sheep.size(); i++){

                    if (sheep.get(i).getId() == id){
                        sheep.get(i).setPedigree(option);
                    }
                }
                System.out.println("The animal's pedigree has been updated");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 5) {

                System.out.println("This animal doesn't produce milk");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
            }

        } else if (type == 3) {

            if (option == 1){

                System.out.println("Please enter the new name: ");
                String name = keyboard.nextLine();

                for (int i = 0; i< dairycows.size(); i++){

                    if (dairycows.get(i).getId() == id){

                        dairycows.get(i).setName(name);

                    }

                }
                System.out.println("The animal's name has been updated");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 2) {

                System.out.println("Please enter the new age: ");
                option = keyboard.nextInt();

                for (int i = 0; i < dairycows.size(); i++){

                    if (dairycows.get(i).getId() == id){
                        dairycows.get(i).setAge(option);
                    }
                }
                System.out.println("The animal's age has been updated");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 3) {

                System.out.println("Please enter the new weight: ");
                double weight = keyboard.nextInt();;

                for (int i = 0; i < dairycows.size(); i++){

                    if (dairycows.get(i).getId() == id){
                        dairycows.get(i).setWeight(weight);
                    }
                }
                System.out.println("The animal's weight has been updated");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            }else if (option == 4){

                System.out.println("This animal doesn't have a pedigree");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 5) {

                System.out.println("Enter the new amount of milk that will be produced: ");
                option = keyboard.nextInt();

                for (int i = 0; i < dairycows.size(); i++){

                    if (dairycows.get(i).getId() == id){
                        dairycows.get(i).setUdderCapacity(option);
                    }
                }
                System.out.println("The amount of milk produced by the animal has been updated");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
            }

        }else if (type == 4){

            if (option == 1){

                System.out.println("This animal doesn't have a name");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 2) {

                System.out.println("Please enter the new age: ");
                option = keyboard.nextInt();

                for (int i = 0; i < beefcows.size(); i++){

                    if (beefcows.get(i).getId() == id){
                        beefcows.get(i).setAge(option);
                    }
                }
                System.out.println("The animal's age has been updated");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 3) {

                System.out.println("Please enter the new weight: ");
                double weight = keyboard.nextInt();;

                for (int i = 0; i < beefcows.size(); i++){

                    if (beefcows.get(i).getId() == id){
                        beefcows.get(i).setWeight(weight);
                    }
                }
                System.out.println("The animal's weight has been updated");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            }else if (option == 4){

                System.out.println("Please enter the new pedigree: ");
                option = keyboard.nextInt();;

                for (int i = 0; i < beefcows.size(); i++){

                    if (beefcows.get(i).getId() == id){
                        beefcows.get(i).setPedigree(option);
                    }
                }
                System.out.println("The animal's pedigree has been updated");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

            } else if (option == 5) {

                System.out.println("This animal doesn't produce milk");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
            }

        }


    }

    public static void removeAnimal(Farm farm1, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows){

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
            app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        } else if (type == 2 && option < 0 || option > animals1.size()) {

            animals2.remove(option);
            System.out.println("Animal removed");
            app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);
        } else {

            System.out.println("An animal does not exist with this id");
            app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }

    }

    public static void orderAnimals(Farm farm1, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows, ArrayList<Sheep> sheep, ArrayList<BeefCow> beefcows) {

        Scanner keyboard = new Scanner(System.in);
        int best = 0;
        int value = 0;
        boolean biggestFound = false;

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

                for (int j = 0; j < goats.size(); j++) {
                    value = 0;
                    for (int i = 0; i < goats.size(); i++) {

                        if (biggestFound == false) {

                            if (goats.get(i).getMilkProduced() > goats.get(best).getMilkProduced()) {
                                value = i;
                                best = i;

                            }
                            //If checking the last animal then just find the goat that produces the least milk
                        }

                         else {

                            if (goats.get(i).getMilkProduced() < goats.get(best).getMilkProduced() && goats.get(i).getMilkProduced() > value) {
                                //The previous cow that passed through
                                value = i;

                            }
                        }
                    }
                    //Set the next biggest cow
                    best = value;
                    //After first time through the loop, the cow that produces the best milk has been found
                    biggestFound = true;
                    System.out.println(goats.get(best));

                }
                for (int s = 0; s < sheep.size(); s++) {

                    System.out.println(sheep.get(s));

                }
            } else if (option == 2) {

                for (int j = 0; j < sheep.size(); j++) {
                    value = 0;
                    for (int i = 0; i < sheep.size(); i++) {

                        if (biggestFound == false) {

                            //Pedigree with the largest number is considered the best
                            if (sheep.get(i).getPedigree() > sheep.get(best).getPedigree()) {
                                value = i;
                                best = i;

                            }
                        } else {

                            if (sheep.get(i).getPedigree() < sheep.get(best).getPedigree() && sheep.get(i).getPedigree() > value) {
                                //The previous cow that passed through
                                value = i;

                            }
                        }
                    }
                    //Set the next biggest cow
                    best = value;
                    //After first time through the loop, the cow that has the best pedigree has been found
                    biggestFound = true;
                    System.out.println(sheep.get(best));

                }

                for (int g = 0; g < goats.size(); g++)

                    System.out.println(goats.get(g));

            } else if (option == 3) {

                for (int j = 0; j < animals1.size(); j++) {
                    value = 0;
                    for (int i = 0; i < animals1.size(); i++) {

                        if (biggestFound == false) {

                            //Weight ordered from heaviest to lightest
                            if (animals1.get(i).getWeight() > animals1.get(best).getWeight()) {
                                value = i;
                                best = i;

                            }
                        } else {

                            if (animals1.get(i).getWeight() < animals1.get(best).getWeight() && animals1.get(i).getWeight() > value) {
                                //The previous cow that passed through
                                value = i;

                            }
                        }
                    }
                    //Set the next biggest cow
                    best = value;
                    biggestFound = true;
                    System.out.println(animals1.get(best));

                }

            } else if (option == 4) {

                for (int j = 0; j < animals1.size(); j++) {
                    value = 0;
                    for (int i = 0; i < animals1.size(); i++) {

                        if (biggestFound == false) {

                            //Age ordered from oldest to youngest
                            if (animals1.get(i).getAge() > animals1.get(best).getAge()) {
                                value = i;
                                best = i;

                            }
                        } else {

                            if (animals1.get(i).getAge() < animals1.get(best).getAge() && animals1.get(i).getAge() > value) {
                                //The previous cow that passed through
                                value = i;

                            }
                        }
                    }
                    //Set the next biggest cow
                    best = value;
                    biggestFound = true;
                    System.out.println(animals1.get(best));

                }

            }
        }


            else if (option == 2) {

                System.out.println("****************************");
                System.out.println("Select a value to order by:");
                System.out.println("1.Milk produced");
                System.out.println("2.Pedigree");
                System.out.println("3.Weight");
                System.out.println("4.Age");
                System.out.println("****************************");
                option = keyboard.nextInt();

                if (option == 1) {

                    for (int j = 0; j < dairycows.size(); j++) {
                        value = 0;
                        for (int i = 0; i < dairycows.size(); i++) {

                            if (biggestFound == false) {

                                if (dairycows.get(i).getUdderCapacity() > dairycows.get(best).getUdderCapacity()) {
                                    value = i;
                                    best = i;

                                }
                            } else {

                                if (dairycows.get(i).getUdderCapacity() < dairycows.get(best).getUdderCapacity() && dairycows.get(i).getUdderCapacity() > value) {
                                    //The previous cow that passed through
                                    value = i;

                                }
                            }
                        }
                        //Set the next biggest cow
                        best = value;
                        //After first time through the loop, the cow that produces the best milk has been found
                        biggestFound = true;
                        System.out.println(dairycows.get(best));
                    }
                    for (int b = 0; b < beefcows.size(); b++) {

                        System.out.println(beefcows.get(b));

                    }
                } else if (option == 2) {

                    for (int j = 0; j < beefcows.size(); j++) {
                        value = 0;
                        for (int i = 0; i < beefcows.size(); i++) {

                            if (biggestFound == false) {

                                //Pedigree with the largest number is considered the best
                                if (beefcows.get(i).getPedigree() > beefcows.get(best).getPedigree()) {
                                    value = i;
                                    best = i;

                                }
                            } else {

                                if (beefcows.get(i).getPedigree() < beefcows.get(best).getPedigree() && beefcows.get(i).getPedigree() > value) {
                                    //The previous cow that passed through
                                    value = i;

                                }
                            }
                        }
                        //Set the next biggest cow
                        best = value;
                        //After first time through the loop, the cow that has the best pedigree has been found
                        biggestFound = true;
                        System.out.println(sheep.get(best));

                    }

                    for (int g = 0; g < dairycows.size(); g++)

                        System.out.println(dairycows.get(g));

                } else if (option == 3) {

                    for (int j = 0; j < animals2.size(); j++) {
                        value = 0;
                        for (int i = 0; i < animals2.size(); i++) {

                            if (biggestFound == false) {

                                //Weight ordered from heaviest to lightest
                                if (animals2.get(i).getWeight() > animals2.get(best).getWeight()) {
                                    value = i;
                                    best = i;

                                }
                            } else {

                                if (animals2.get(i).getWeight() < animals2.get(best).getWeight() && animals2.get(i).getWeight() > value) {
                                    //The previous cow that passed through
                                    value = i;

                                }
                            }
                        }
                        //Set the next biggest cow
                        best = value;
                        biggestFound = true;
                        System.out.println(animals2.get(best));

                    }

                } else if (option == 4) {

                    for (int j = 0; j < animals2.size(); j++) {
                        value = 0;
                        for (int i = 0; i < animals2.size(); i++) {

                            if (biggestFound == false) {

                                //Age ordered from oldest to youngest
                                if (animals2.get(i).getAge() > animals2.get(best).getAge()) {
                                    value = i;
                                    best = i;

                                }
                            } else {

                                if (animals2.get(i).getAge() < animals2.get(best).getAge() && animals2.get(i).getAge() > value) {
                                    //The previous cow that passed through
                                    value = i;

                                }
                            }
                        }
                        //Set the next biggest cow
                        best = value;
                        biggestFound = true;
                        System.out.println(animals2.get(best));

                    }

                }

        }

            app(farm1, shed1, shed2, animals1, animals2, goats, dairycows, sheep, beefcows);

        }

    }
