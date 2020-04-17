import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class DriverForMultipleBlocksAndTransport {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("testFullPopulationAndTransAndMetro"));
        Scanner input = new Scanner(new File("SIR Model 2/src/Populations"));
        Scanner input2 = new Scanner(new File("MetroAverageTransport"));

        int beta = 2;
        double gamma = 1.4;
        Block[] blocks = new Block[179];
        String[] names = new String[179];
        String[][] transport = new String[41][2];

        //
        for(int i = 0; i < 179; i++){
            names[i] = input.next();
            blocks[i] = new Block(beta, gamma, input.nextInt(), 2, 0);
        }

        for(int i = 0; i < 41; i++){
            input2.next();
            transport[i][0] = input2.next();
            transport[i][1] = input2.next();
        }

        for(int i = 0; i < 179; i++){
            output.print("\t" + names[i] + "\t\t\t");
        }

        output.print("\nTimeStep");

        for(int i = 0; i < 179; i++){
            output.print("\tS\tI\tR\tPop");
        }

        output.print("\n0\t");


        for(int j = 0; j < 179; j++){
            output.print(blocks[j].printOut());
        }

        output.println();

        for(int i = 1; i <= 25; i++){
            output.print(i + "\t");
            for(int j = 0; j < 179; j++){
                double move = Math.ceil(blocks[j].getSusceptible()*.1);

                for(int k = 0; k < 41; k++){
                    if(transport[k][1].equals(names[j])){
                        //System.out.println(move);
                        move += Integer.parseInt(transport[k][0]);
                        //System.out.println(move);
                    }
                }

                blocks[j].setSusceptible((int) (blocks[j].getSusceptible() + move));
                blocks[j].setPopulation((int)(blocks[j].getPopulation() + move));

                blocks[j].nextTimeStep();

                blocks[j].setSusceptible((int) (blocks[j].getSusceptible() - move));
                blocks[j].setPopulation((int)(blocks[j].getPopulation() - move));

                output.print(blocks[j].printOut());

            }
            output.print("\n");
        }

    }
}
