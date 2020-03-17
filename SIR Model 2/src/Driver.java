public class Driver{
    public static void main(String[]args){
       Block temp = new Block(1, .1, 100000, 2, 0);
       int counter = 0;
       System.out.println("Time Step " + counter);
       temp.printOut();
       counter++;
       while(temp.hasNextTimeStep()){
           System.out.println("Time Step " + counter);
           temp.nextTimeStep();
           System.out.println();
           counter++;
       }
    }
}
