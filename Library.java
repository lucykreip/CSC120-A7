
import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /*
    * constructs a Library
    * @param name Assigns a String name to the library
    * @param address Assigns a String address to the library
    * @param nFloors Assigns an int number of floors to the library
    */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
  }

  /*
   * public boolean to check if the library has an elevator
   * @return hasElevetor boolean determining 
   */
  public boolean hasElevator(){
    return hasElevator;
  }

  /*
     * adds the given title to the library collection
     * @param title The title that is to be added
     */

  public void addTitle(String title){
    if(! collection.containsKey(title)){
      collection.put(title, true);
    }
    else{
      throw new RuntimeException(title + " is already in this Library!");
    }
  }

  /*
     * removes the given title to the library collection
     * @param title The title that is to be removed
     * @return Returns the title that was just removed
     */
  public String removeTitle(String title){
    if (! collection.containsKey(title)){
      throw new RuntimeException(title + " is not in this Library!");
    }
    else{
      collection.remove(title);
    }
    return title;
  }

  /*
     * checks out a book by changing the hashtable value of the given title to be false if it was true
     * @param title The title that is to be checked out
     */

  public void checkOut(String title){
    if (this.isAvailable(title) || this.containsTitle(title)){
      collection.replace(title, true, false);
    }
    else{
      throw new RuntimeException("Can't check this out!");
    }

  }

  /*
     * returns a book by changing the hashtable value at the given title to be true if it was false 
     * @param title The title that is to be returned
     */

  public void returnBook(String title){
    collection.replace(title, false, true);
  } 

  /*
     * checks the collection for a certain title
     * @param title The title that is serached for within the collection
     * @return returns if the key is found in the collection (true/false)
     */

  public boolean containsTitle(String title){
    return collection.containsKey(title);
  } 

  /*
     * returns true if title is currently availible, and false if not
     * @param title The title that's availibility is to be checked
     * @return true if the title is availible, flase if not. 
     */
  public boolean isAvailable(String title){
    if (collection.getOrDefault(title, false) == true){
      return true;
    }
    else{
      return false;
    }
  } 

  /*
     * prints out the collection of titles and their true/false value
     */
  public void printCollection(){
    System.out.println("Our Collection:");
    System.out.println(collection.toString());
    
  } 

  /*
   * prints out the method options that can be called for Library classes
   */
  public void showOptions(){
    super.showOptions();
    System.out.println(" + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + containsTitle() \n + isAvailable() \n + printCollection()");
  }

  /*
   * brings user directly to the floor indicated if the library has an elevator
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
    Library myLibrary = new Library("Lucy's Library", "15 Maple St", 5, true);
    myLibrary.addTitle("All about Geese");
    myLibrary.addTitle("All bout Java");
    myLibrary.addTitle("Pride and Prejudice");
    System.out.println(myLibrary.containsTitle("Random"));
    System.out.println(myLibrary.isAvailable("All about Geese"));
    myLibrary.checkOut("All about Geese");
    myLibrary.printCollection();
    myLibrary.showOptions();
    myLibrary.enter();
    myLibrary.goToFloor(5);
  
  }
  
}