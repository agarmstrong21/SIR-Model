public class Person {

    private boolean susceptible = true;
    private boolean infected = false;
    private boolean resistant = false;
    private final int placement;

    public Person(boolean susceptible, boolean infected, boolean resistant, int placement){
        this.susceptible = susceptible;
        this.infected = infected;
        this.resistant = resistant;
        this.placement = placement;
    }

    public boolean isSusceptible() {
        return susceptible;
    }

    public void setSusceptible() {
        this.susceptible = true;
        this.infected = false;
        this.resistant = false;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected() {
        this.infected = true;
        this.susceptible = false;
        this.resistant = false;
    }

    public boolean isResistant() {
        return resistant;
    }

    public void setResistant() {
        this.resistant = true;
        this.susceptible = false;
        this.infected = false;
    }

    public int getPlacement() {
        return placement;
    }

    public void printState(){
        if(susceptible){
            System.out.print("s");
        }else if(infected){
            System.out.print("i");
        }else if(resistant){
            System.out.print("r");
        }else{
            System.out.print("No state");
        }

    }
}
