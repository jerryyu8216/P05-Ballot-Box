//////////////// P05 Ballot Box //////////////////////////
//
// Title: Candidate
// Course: CS 300 Fall 2020
//
// Author: Jerry Yu
// Email: jcyu4@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
public class Candidate {
  // String array containing all office titles
  protected static final String[] OFFICE =
      new String[] {"President", "Vice President", "Secretary"};
  // private instance variable that contains the name of the candidate
  private String name;
  // private instance variable that contains the office of the candidate
  private String office;

  /**
   * Public constructor method that creates a new candidate object and initializes the name and
   * office of the candidate, this method also checks that the inputed office is a valid office
   * 
   * @param name - a string representing the candidate's name
   * @param office - a string representing the candidate's office
   * @throws IllegalArgumentException if the office inputed does not exist
   */
  public Candidate(String name, String office) {
    // initializes the name of the candidate
    this.name = name;
    // checks if the office exists
    if (check(office) == true) {
      // initializes the office of the candidate
      this.office = office;
    } 
    // throws an IllegalArgumentException if the office does not exist
    else {
      throw new IllegalArgumentException("Error: Office does not exist");
    }
  }
  /**
   * Private method that checks if the given office is within the string array OFFICE
   * 
   * @param office - a string which is then compared to the values of the string array OFFICE
   * @return true if the office is within the array and false otherwise
   */
  private static boolean check(String office) {
    // iterates through the OFFICE array 
    for (int i = 0; i < OFFICE.length; i++) {
      // checks if the office given matches a value in the array OFFICE
      if (OFFICE[i] == office) {
        // returns true if the given office is found
        return true;
      }
    }
    // returns false if the given office is not found
    return false;
  }
  /**
   * Public method that returns the name of the candidate
   * 
   * @return the name of the candidate object
   */
  public String getName() {
    return name;
  }

  /**
   * Public method that returns the office of the candidate
   * 
   * @return the office of the candidate object
   */
  public String getOffice() {
    return office;
  }
  /**
   * Public method that returns as string representation of the object
   * 
   * @return a string representation of the candidate object
   */
  @Override
  public String toString() {
    return name + " (" + office + ")";
  }
}
