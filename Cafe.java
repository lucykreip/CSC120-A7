
public class Cafe extends Building {
    private int nCoffeeOunces; 
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups;

    /*
     * constructs a Cafe, initializes nCoffeeOunces, nSugarPackets, nCreams, nCups to beginning inventory numbers
     * @param name Assigns a String name to the cafe
     * @param address Assigns a String address to the cafe
     * @param nFloors Assigns an int number of floors to the cafe
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 50;
        this.nSugarPackets = 50;
        this.nCreams = 50;
        this.nCups = 50;
        System.out.println("You have built a cafe: ☕");
    }

    /*
     * constructs the default Cafe
     */

    public Cafe(){
        this.name = "Compass Cafe";
        this.address = "4 Nielson Drive";
        this.nFloors = 1;
        this.nCoffeeOunces = 25;
        this.nSugarPackets = 25;
        this.nCreams = 25;
        this.nCups = 25;
        System.out.println("You have built the default Compass Cafe ☕");
    }

    /*
     * reduces number of each parameter by the associated value when a coffee is sold, as well as cup by 1
     * @param nCoffeeOunces Amount of coffee bought
     * @param nSugarPackets Amount of sugar packets used
     * @param nCreams Amount of cream splashes used
     */
    public void sellCoffee(int nCoffeeOunces, int nSugarPackets, int nCreams){
        this.nCoffeeOunces -= nCoffeeOunces;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        if (this.nCoffeeOunces < 5 || this.nSugarPackets < 5 || this.nCreams < 5 || this.nCups < 5){
            this.restock(50, 50, 50, 50);
        }
    }

    /*
     * Overloaded method to sell one black coffee
     */
    public void sellCoffee(){
        this.nCoffeeOunces -= 12;
        this.nSugarPackets -= 0; 
        this.nCreams -= 0;
        this.nCups -= 1;
    }

    /*
     * restocks the parameters to entered values
     * @param nCoffeeOunces Amount of coffee to restock to
     * @param nSugarPackets Amount of sugar to restock to
     * @param nCreams Amount of cream to restock to
     * @param nCups Amount of cups to restock to
     */

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    public void showOptions(){
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + sellCoffee() \n + restock()");
    }    

    public void goToFloor(int floorNum) {
        throw new RuntimeException(this.name + " upper floors are not accessible to the public.");
    }

    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Lu's Cafe", "1 Chapin Way", 1);
        myCafe.sellCoffee(12, 5, 10);
        System.out.println(myCafe.nCoffeeOunces);
        System.out.println(myCafe.nSugarPackets);
        System.out.println(myCafe.nCreams);
        System.out.println(myCafe.nCups);
        myCafe.sellCoffee(40, 5, 10);
        System.out.println(myCafe.nCoffeeOunces);
        System.out.println(myCafe.nSugarPackets);
        System.out.println(myCafe.nCreams);
        System.out.println(myCafe.nCups);
        System.out.println(myCafe);
        myCafe.showOptions();
        myCafe.goToFloor(2);

    
    }
    
}