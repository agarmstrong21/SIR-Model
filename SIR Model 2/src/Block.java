public class Block {
    private double beta = 0.0;
    private double gamma = 0.0;
    private int susceptible = 0;
    private int infected = 0;
    private int resistant = 0;
    private int population = 0;

    // Constructor
    public Block(double b, double g, int s, int i, int r){
        this.beta = b;
        this.gamma = g;
        this.susceptible = s;
        this.infected = i;
        this.resistant = r;
        this.population = susceptible+infected+resistant;
    }

    // Getters
    public double getBeta(){return beta;}
    public double getGamma(){return gamma;}
    public double getSusceptible(){return susceptible;}
    public double getInfected(){return infected;}
    public double getResistant(){return resistant;}

    // Setters
    public void setBeta(double b){this.beta = b;}
    public void setGamma(double g){this.gamma = g;}
    public void setSusceptible(int s){this.susceptible = s;}
    public void setInfected(int i){this.infected = i;}
    public void setResistant(int r){this.resistant = r;}

    public void nextTimeStep(){
        // Setting all previous values
        int prevSusceptible = susceptible;
        int prevInfected = infected;
        int prevResistant = resistant;

        // Calculating X(t+1)
        susceptible = susceptible - (int)Math.ceil(((beta * susceptible * infected)/population));

        // If X(t+1) <= 0, make susceptible 1 for math purposes.
        if(susceptible <= 0){
            susceptible = 1;
        }

        // Calculating Y(t+1)
        infected = infected + (int)(Math.ceil((beta * susceptible * infected)/population) - Math.ceil(gamma * infected));

        // If Y(t+1) <= 0, make infected 1 for math purposes.
        if(infected<= 0){
            infected = 1;
        }

        // Calculating Z(t+1)
        resistant = resistant + (int)Math.ceil(gamma * infected);

        // If there is a population difference between the actual population and the calculated population, then we
        //      assume that the 'lost' population is resistant.
        if((infected+susceptible+resistant) != population){
            resistant += population - (infected+susceptible+resistant);
        }

        // If keeps repeating, take one out of the infected and move to resistant
        if(prevResistant == resistant && prevSusceptible == susceptible && prevInfected == infected){
            infected--;
            resistant++;
        }

        if(susceptible <= 1){
            susceptible = 0;
        }

        // Print out stats
        //printOut();
        //System.out.println("S: " + susceptible + "\tI: " + infected + "\tR: " + resistant + "\tP: " + (infected+susceptible+resistant));
    }

    public String printOut(){
        return susceptible + "\t" + infected + "\t" + resistant + "\t" + population + "\t";
    }

    public boolean hasNextTimeStep(){
        return infected > 0&&susceptible>0;
    }
}
