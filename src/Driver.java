
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Driver {

    private static ArrayList<Person> personArrayList = new ArrayList<>();
    private static int size = 0;
    private static Scanner readIn = new Scanner(System.in);
    private static Random randomInt = new Random();


    public static void main(String[] args){
        int counter = 0;

        System.out.println("Welcome to the SIR Modeler, please enter size.");
        size = readIn.nextInt();

        for(int i =0; i < size*size; i++){
            personArrayList.add(new Person(true, false, false,(i)));
        }

        randomInfect();

        printModel();

    }

    private static void randomInfect(){
        int change = randomInt.nextInt(personArrayList.size());
        personArrayList.get(change).setInfected();
    }

    private static void printModel(){
        int counter = 0;

        for(int i = 0; i < size+2; i++){
            System.out.print("* ");
        }

        System.out.println();

        for(int i =0; i < size; i++){
            System.out.print("* ");
            for(int j = 0; j < size; j++){
                personArrayList.add(new Person(true, false, false,(i*size) + j));
                counter++;
                personArrayList.get(counter-1).printState();
                System.out.print(" ");
            }
            System.out.println("*");
        }

        for(int i = 0; i < size+2; i++){
            System.out.print("* ");
        }

        System.out.println();
    }
}
