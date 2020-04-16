import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Driver{
    public static void main(String[]args) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("test"));

        Block temp = new Block(2, 1.4, 702455, 2, 0);
       int counter = 0;
       output.print("Time Step\tSusceptible\tInfected\tResistant\tPopulation\n" + counter + "\t");
       output.print(temp.printOut() + "\n");
       counter++;
       while(temp.hasNextTimeStep() && temp.getInfected() != 1){
           output.print(counter + "\t");
           temp.nextTimeStep();
           output.print(temp.printOut() + "\n");
           //System.out.println();
           counter++;
       }
    }
}
