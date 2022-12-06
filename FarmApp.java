import java.util.ArrayList;
import java.util.Scanner;

public class FarmApp {

    public static void app(Farm farm1, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows){

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

        if(option == 1){

            System.out.println(farm1);
            app(farm1, shed1, shed2, animals1, animals2, goats, dairycows);

        }
        else if (option == 2) {

            animalDetails(farm1, shed1, shed2, animals1, animals2, goats, dairycows);

                }

        else if(option == 3){



        }

        else if(option == 4){

            System.out.println("****************************");
            System.out.println("Select a type of animal:");
            System.out.println("1.Goat/Sheep");
            System.out.println("2.Dairy cow/Beef cow");
            System.out.println("****************************");
            type = keyboard.nextInt();

            while (type < 1 || type > 2){

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

            if (type == 1 && option > -1 || option < animals1.size()){

               animals1.remove(option);
               System.out.println("Animal removed");
               app(farm1, shed1, shed2, animals1, animals2, goats, dairycows);

            }
            else if (type == 2 && option < 0 || option > animals1.size()){

                animals2.remove(option);
                System.out.println("Animal removed");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows);
            }

            else{

                System.out.println("An animal does not exist with this id");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows);

            }

        }

        else if (option == 5) {

            shed1.milkAnimal(animals1);
            shed2.milkAnimal(animals2);
            System.out.println("All animals milked");
            app(farm1, shed1, shed2, animals1, animals2, goats, dairycows);

        } else if (option == 6) {

            System.out.println("Enter the id of the animal that has died: ");
            option = keyboard.nextInt();

            if (option > -1 && option < animals1.size()){

                animals1.remove(option);
                System.out.println("The animal has been identified as dead and has been removed from the farm");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows);

            } else if (option > animals1.size() && option < animals2.size()) {

                animals2.remove(option);
                System.out.println("The animal has been identified as dead and has been removed from the farm");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows);

            }
            else{
                System.out.println("An animal does not exist with this id");
                app(farm1, shed1, shed2, animals1, animals2, goats, dairycows);
            }

        } else if(option == 7){

            shed1.getTank().emptyTank();
            shed2.getTank().emptyTank();
            System.out.println("All milk has been collected from tanks");
            app(farm1, shed1, shed2, animals1, animals2, goats, dairycows);

        } else if (option == 8) {

            orderAnimals(farm1, shed1, shed2, animals1, animals2, goats, dairycows);

        } else if (option == 0){

            System.out.println("Exiting....");
            System.exit(0);

        }

    }

    public static void animalDetails(Farm farm1, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows){

        Scanner keyboard = new Scanner(System.in);

        System.out.println("****************************");
        System.out.println("Select a type of animal:");
        System.out.println("1.Goat/Sheep");
        System.out.println("2.Dairy cow/Beef cow");
        System.out.println("****************************");
        int type = keyboard.nextInt();

        while (type < 1 || type > 2){

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

                if(animals1.get(i).getId() == option) {
                    System.out.println(animals1.get(i));
                    app(farm1, shed1, shed2, animals1, animals2, goats, dairycows);
                }

            }

            System.out.println("A goat/sheep cow does not exist with this id");
            app(farm1, shed1, shed2, animals1, animals2, goats, dairycows);
        }

        else if(type == 2){

            for (int i = 0; i < animals2.size(); i++) {

                if (animals2.get(i).getId() == option) {
                    System.out.println(animals2.get(i));
                    app(farm1, shed1, shed2, animals1, animals2, goats, dairycows);
                }
            }
            System.out.println("A dairy cow/beef cow does not exist with this id");
            app(farm1, shed1, shed2, animals1, animals2, goats, dairycows);

        }


    }

    public static void orderAnimals(Farm farm1, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2, ArrayList<Goat> goats, ArrayList<DairyCow> dairycows){

        Scanner keyboard = new Scanner(System.in);
        int mostMilk = 0;
        int milk = 0;
        boolean biggestFound = false;

        System.out.println("****************************");
        System.out.println("Select a the herd to order:");
        System.out.println("1.Goat/Sheep");
        System.out.println("2.Dairy cow/Beef cow");
        System.out.println("****************************");
        int option = keyboard.nextInt();

        if (option == 1){

            System.out.println("****************************");
            System.out.println("Select a value to order by:");
            System.out.println("1.Milk produced");
            System.out.println("****************************");
            option = keyboard.nextInt();

            if (option == 1){

                for (int j = 0; j < goats.size(); j++){
                    milk = 0;
                    for (int i = 0; i < goats.size(); i++) {

                        if (biggestFound == false) {

                            if (goats.get(i).getMilkProduced() > goats.get(mostMilk).getMilkProduced()) {
                                milk = i;
                                mostMilk = i;

                            }
                        }

                        else{

                            if (goats.get(i).getMilkProduced() < goats.get(mostMilk).getMilkProduced() && goats.get(i).getMilkProduced() > milk) {
                                //The previous cow that passed through
                                milk = i;

                            }
                        }
                    }
                    //Set the next biggest cow
                    mostMilk = milk;
                    //After first time through the loop, the cow that produces the most milk has been found
                    biggestFound = true;
                    System.out.println(goats.get(mostMilk));

                }
            }

        }

        else if (option == 2){

            System.out.println("****************************");
            System.out.println("Select a value to order by:");
            System.out.println("1.Milk produced");
            System.out.println("****************************");
            option = keyboard.nextInt();

            if (option == 1){

                for (int j = 0; j < dairycows.size(); j++){
                    milk = 0;
                    for (int i = 0; i < dairycows.size(); i++) {

                        if (biggestFound == false) {

                            if (dairycows.get(i).getUdderCapacity() > dairycows.get(mostMilk).getUdderCapacity()) {
                                milk = i;
                                mostMilk = i;

                            }
                        }

                        else{

                            if (dairycows.get(i).getUdderCapacity() < dairycows.get(mostMilk).getUdderCapacity() && dairycows.get(i).getUdderCapacity() > milk) {
                                //The previous cow that passed through
                                milk = i;

                            }
                        }
                    }
                    //Set the next biggest cow
                    mostMilk = milk;
                    //After first time through the loop, the cow that produces the most milk has been found
                    biggestFound = true;
                    System.out.println(dairycows.get(mostMilk));

                }
            }
        }

        app(farm1, shed1, shed2, animals1, animals2, goats, dairycows);

    }

}
