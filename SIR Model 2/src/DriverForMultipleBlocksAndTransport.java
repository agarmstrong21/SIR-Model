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

        double beta = 1.75;
        double gamma = .5;
        Block[] blocks = new Block[179];
        String[] names = new String[180];
        String[][] transport = new String[41][2];

        //
        for(int i = 0; i < 179; i++){
            names[i] = input.next();
            blocks[i] = new Block(beta, gamma, input.nextInt(), 2, 0);
        }

        names[179] = "Overall";

        for(int i = 0; i < 41; i++){
            input2.next();
            transport[i][0] = input2.next();
            transport[i][1] = input2.next();
        }

        for(int i = 0; i < 180; i++){
            output.print("\t" + names[i] + "\t"+names[i]+"\t"+names[i]+"\t" + names[i]);
        }

        output.print("\nTimeStep");

        for(int i = 0; i < 180; i++){
            output.print("\tS\tI\tR\tPop");
        }

        output.print("\n0\t");


        int overallS = 0;
        int overallI = 0;
        int overallR = 0;

        for(int j = 0; j < 179; j++){
            output.print(blocks[j].printOut());
            overallS += blocks[j].getSusceptible();
            overallI += blocks[j].getInfected();
            overallR += blocks[j].getResistant();
        }

        output.print(overallS + "\t" + overallI + "\t" + overallR + "\t" + (overallS+overallI+overallR)+ "\t");
        output.print("\n");
        overallS = overallI = overallR = 0;


        for(int i = 1; i <= 25; i++){
            output.print(i + "\t");
            for(int j = 0; j < 179; j++){
                double move = Math.ceil(blocks[j].getSusceptible()*.1) ;//* .6667;


                for(int k = 0; k < 41; k++){
                    if(transport[k][1].equals(names[j])){
                        //System.out.println(move);
                        move += (Integer.parseInt(transport[k][0]));
                        //System.out.println(move);
                    }
                }
                move = move * .1;

                //move = move * .66667;
//                double tempMove = move;
//                double infectedMove = blocks[j].getInfected()/blocks[j].getPopulation();
//                infectedMove = Math.ceil(infectedMove * tempMove);
//                move = move - infectedMove;

                blocks[j].setSusceptible((int) (blocks[j].getSusceptible() + (move)));
                //blocks[j].setInfected((int) (blocks[j].getInfected() + (infectedMove)));
                blocks[j].setPopulation((int)(blocks[j].getPopulation() + move));

                blocks[j].nextTimeStep();

                blocks[j].setSusceptible((int) (blocks[j].getSusceptible() - (move)));
                //blocks[j].setInfected((int) (blocks[j].getInfected() - (infectedMove)));
                blocks[j].setPopulation((int)(blocks[j].getPopulation() - move));

                output.print(blocks[j].printOut());

                overallS += blocks[j].getSusceptible();
                overallI += blocks[j].getInfected();
                overallR += blocks[j].getResistant();

            }
            output.print(overallS + "\t" + overallI + "\t" + overallR + "\t" + (overallS+overallI+overallR)+ "\t");
            output.print("\n");
            overallS = overallI = overallR = 0;
        }

    }
}
