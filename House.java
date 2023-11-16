  
import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;
 
  /*
    * constructs a Cafe
    * @param name Assigns a String name to the house
    * @param address Assigns a String address to the house
    * @param nFloors Assigns an int number of floors to the house
    */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    this.residents = new ArrayList<String>();
    System.out.println("You have built a house: 🏠");
  }

  /*
   * constructs an under construction house. Has an address and an n amount of floors, but ammenities need to be added 
   * @param address Assigns a String address to the house
   * @param nFloors Assigns an int number of floors to the house
   */
  public House(String name, String address, int nFloors) {
    this.name = name + " !UNDER CONSTRUCTION!";
    this.address = address;
    this.nFloors = nFloors;
    this.hasDiningRoom = false;
    this.hasElevator = false;
    this.residents = new ArrayList<String>();
    System.out.println("You have built a house: 🏠");
  }
  /*
     * checks the given value for if the house has a dining room
     * @return boolean value for whether or not the house has a dining room
     */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /*
     * checks the given value for if the house has an elevator
     * @return boolean value for whether or not the house has an elevator
     */
  public boolean hasElevator(){
    return this.hasElevator;
  }

  /*
     * provides the number of residents in the house
     * @return the length of the residents list in the house
     */
  public int nResidents(){
    return residents.size();
  }

  /*
     * adds the resident to the house if they move in
     * @param name Added to the residents ArrayList
     */
  public void moveIn(String name){
    if (! residents.contains(name)){
      residents.add(name);
    }
    else{
      throw new RuntimeException(name + " already lives here!");
    }
  }

  /*
   * moves in a quad room all at once
   * @param person1 the first person in the quad
   * @param person2 the second person in the quad
   * @param person3 the third person in the quad
   * @param person4 the fourth perosn in the quad
   */
  public void moveIn(String person1, String person2, String person3, String person4){
    residents.add(person1);
    residents.add(person2);
    residents.add(person3);
    residents.add(person4);
  }

  /*
     * removes given resident from the house then they move out, unless they do not live in the house currently
     * @param name Person to be removed from the residents ArrayList
     * @return The name of the resident who moved out
     */
  public String moveOut(String name){
    if (! isResident(name)){
      throw new RuntimeException(name + " does not live here.");
    }
    else{
      residents.remove(name);
    }
    return name;
  }

  /*
   * removes a quad room of people from the house
   * @param person1 the first person in the quad
   * @param person2 the second person in the quad
   * @param person3 the third person in the quad
   * @param person4 the fourth person in the quad
   * @return the names of the full family that moved out
   */
  public String moveOut(String person1, String person2, String person3, String person4){
    residents.remove(person1);
    residents.remove(person2);
    residents.remove(person3);
    residents.remove(person4);
    return "The quad of " + person1 + ", " + person2 + ", " + person3 + ", and " + person4 + " has moved out";
  }

  /*
     * checks if a person is a resident
     * @param person String to be checked in the residents ArrayList for
     * @return boolean Whether or not the person is a resident
     */
  public boolean isResident(String person){
    boolean isRes = true;
    if (residents.contains(person)){
      isRes = true;
    }
    else{
      isRes = false;
    }
    return isRes;
  }

  /*
   * prints method options that can be called for the House class
   */
  public void showOptions(){
    super.showOptions();
    System.out.println(" + moveIn() \n + moveOut() \n + isResident()");
  }

  /*
   * brings user directly to the floor indicated if the house has an elevator
   * @param floorNum int of the number of floors 
   */
  public void goToFloor(int floorNum) {
    if (hasElevator == true){
      super.goToFloor(floorNum);
    }
    else{
      throw new RuntimeException(this.name + " does not have an elevator! You must use the goUp() and goDown() methods to traverse floors.");
    }
  }

  public static void main(String[] args) {
    House myHouse = new House("Lucy's House", "15 Maple St.", 4, true, false);
    System.out.println(myHouse);
    System.out.println(myHouse.hasDiningRoom());
    myHouse.moveIn("Lucy");
    System.out.println(myHouse.nResidents());
    System.out.println(myHouse.isResident("Lucy"));
    myHouse.showOptions();
    House fixer = new House("house", "1 Mandelle Road", 4);
    System.out.println(fixer);


    
  }

}