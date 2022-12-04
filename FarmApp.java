import java.util.ArrayList;
import java.util.Scanner;

public class FarmApp {

    public static void app(Farm farm1, DairyCowShed shed1, GoatShed shed2, ArrayList<Animal> animals1, ArrayList<Animal> animals2){

        Scanner keyboard = new Scanner(System.in);

        System.out.println("****************************");
        System.out.println("1.Print farm details");
        System.out.println("2.See details of an animal");
        System.out.println("3.Edit an animal");
        System.out.println("4.Delete an animal");
        System.out.println("5.Milk all animals on farm");
        System.out.println("6.Exit");
        System.out.println("****************************");

        System.out.println("Select an option: ");
        int option = keyboard.nextInt();

        if(option == 1){

            System.out.println(farm1);
            app(farm1, shed1, shed2, animals1, animals2);

        }
        else if (option == 2) {

            System.out.println("****************************");
            System.out.println("Select the type of animal:");
            System.out.println("1 - Dairy Cow");
            System.out.println("2 - Goat");
            System.out.println("****************************");
            System.out.println("Option: ");
            option = keyboard.nextInt();

            if (option == 1){

                System.out.println("Enter the id of the animal: ");
                option = keyboard.nextInt();

                for (int i = 0; i < shed1.getAnimals().size(); i++){

                //if animal id is equal to option then print the animal

                }

            }

        }

        else if (option == 5) {

            shed1.milkAnimal(shed1.getAnimals());
            shed2.milkAnimal(shed2.getAnimals());

        }

        else if (option == 6){

            System.out.println("Exiting....");
            System.exit(0);

        }

    }

}
