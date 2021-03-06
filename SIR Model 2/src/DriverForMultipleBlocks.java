import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class DriverForMultipleBlocks {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("testFullPopulation"));
        Scanner input = new Scanner(new File("SIR Model 2/src/Populations"));

        int beta = 2;
        double gamma = 1.4;
        Block[] blocks = new Block[179];
        String[] names = new String[179];

        for(int i = 0; i < 179; i++){
            names[i] = input.next();
            blocks[i] = new Block(beta, gamma, input.nextInt(), 2, 0);
        }

        for(int i = 0; i < 179; i++){
            output.print("\t" + names[i] + "\t\t\t");
        }

        output.print("\nTimeStep");

        for(int i = 0; i < 179; i++){
            output.print("\tS\tI\tR\tPop");
        }

        output.println();
        for(int i = 0; i <= 25; i++){
            output.print(i + "\t");
            for(int j = 0; j < 179; j++){
                blocks[j].nextTimeStep();
                output.print(blocks[j].printOut());
            }
            output.print("\n");
        }

    }
}
