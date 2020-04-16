import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class DriverForMultipleBlocks {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("testMultiple"));
        Scanner input = new Scanner(new File("SIR Model 2/src/TestingAgain"));

        int beta = 2;
        double gamma = 1.4;
        Block[] blocks = new Block[48];
        String[] names = new String[48];



        for(int i = 0; i < 48; i++){
            names[i] = input.next();
            blocks[i] = new Block(beta, gamma, input.nextInt(), 2, 0);
        }
        /*blocks[0] = new Block(beta, gamma, 4779,2,0);
        blocks[1] = new Block(beta, gamma, 3442,2,0);
        blocks[2] = new Block(beta, gamma, 7436,2,0);
        blocks[3] = new Block(beta, gamma, 5008,2,0);
        blocks[4] = new Block(beta, gamma, 4539,2,0);
        blocks[5] = new Block(beta, gamma, 6857,2,0);
        blocks[6] = new Block(beta, gamma, 3376,2,0);
        blocks[7] = new Block(beta, gamma, 3189,2,0);
        blocks[8] = new Block(beta, gamma, 33,2,0);
        blocks[9] = new Block(beta, gamma, 2830,2,0);*/

        for(int i = 0; i < 48; i++){
            output.print("\t" + names[i] + "\t\t\t");
        }
        for(int i = 0; i <= 25; i++){
            output.print(i + "\t");
            for(int j = 0; j < 48; j++){
                blocks[j].nextTimeStep();
                output.print(blocks[j].printOut());
            }
            output.print("\n");
        }










        // OLD CODE
//        Random randint = new Random();
//        Block[] Blocks = new Block[18];
//        Scanner readIn = new Scanner(new File("SIR Model 2/src/TestingAgain"));
//        int[] timeStamps = new int[18];
////        System.out.println(readIn.nextLine());
//
//
//        for(int i = 0; i < 18; i++){
//            readIn.next();
//            Block temp = new Block(.8,.1, readIn.nextInt(), randint.nextInt(10), 0);
//            Blocks[i] = temp;
//
//            int counter = 0;
//            System.out.println("Block: " + i + "\nTime Step " + counter);
//            Blocks[i].printOut();
//            counter++;
//            while(Blocks[i].hasNextTimeStep()){
//                System.out.println("Time Step " + counter);
//                Blocks[i].nextTimeStep();
//                System.out.println();
//                counter++;
//            }
//            timeStamps[i] = counter;
//        }
//
//        for(int i = 0; i < 17; i++){
//            System.out.print(timeStamps[i] + ", ");
//        }
//        System.out.println(timeStamps[17]);
//
//        int avg = 0;
//        for(int i = 0; i < 18; i++){
//            avg+=timeStamps[i];
//        }
//
//        System.out.println("Average: " + avg/18);
//
//        readIn.next();
//        readIn.next();

    }
}
