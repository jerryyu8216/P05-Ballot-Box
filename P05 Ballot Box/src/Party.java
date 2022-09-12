//////////////// P05 Ballot Box //////////////////////////
//
// Title: Party
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
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Party {
  // private instance variable that contains the name of the party
  private String name;
  // private instance variable that contains all of the candidates of the party
  private ArrayList<Candidate> candidates;

  /**
   * Public constructor method that creates a new party object and initializes the name of the party
   * and the ArrayList that contains all the candidates from this party
   * 
   * @param name   - a string representing the candidate's name
   * @param office - a string representing the candidate's office
   * @throws IllegalArgumentException if the office inputed does not exist
   */
  public Party(String name) {
    // initializes the name of the party
    this.name = name;
    // initializes the ArrayList that will hold all of the candidates of this party
    candidates = new ArrayList<Candidate>();
  }

  /**
   * Public method that returns the name of the candidate
   * 
   * @return the name of the party object
   */
  public String getName() {
    return name;
  }

  /**
   * Public method that returns the size of the candidate list
   * 
   * @return the size of the candidate list
   */
  public int getSize() {
    return candidates.size();
  }

  /**
   * Public method that gets the candidate that is running for the inputed office from the party
   * that calls this method
   * 
   * @param office - a string representing the office the method is searching for
   * @throws NoSuchElementException if there is no candidate in this party for the specified office
   * @return the candidate of this party that is running for the inputed office
   */
  public Candidate getCandidate(String office) {
    // checks if the party has a candidate for the specified office
    if (search(candidates, office) != -1) {
      // returns the candidate of the specified office
      return candidates.get(search(candidates, office));
    }
    // throws a NoSuchElementException if there is no candidate in this party for the specified
    // office
    else {
      throw new NoSuchElementException("Error: Candidate was not found for office inputted");
    }
  }

  /**
   * Private helper method that iterates through the candidates ArrayList to find a candidate
   * running for the specified office
   * 
   * @param Candidates - an ArrayList containing all the candidates of the party
   * @param office     - a string representing the candidate's office
   * @return if a candidate is found for the specific office then the index of the candidate is
   *         returned, if no candidate is found then -1 is returned
   */
  private int search(ArrayList<Candidate> Candidates, String office) {
    // iterates through the Candidates array
    for (int i = 0; i < Candidates.size(); i++) {
      // checks if the office of the candidate is equal to the provided office
      if (Candidates.get(i).getOffice() == office) {
        // returns the index of the candidate if the candidate of the provided office is found
        return i;
      }
    }
    // returns -1 if a candidate of the provided office is not found
    return -1;
  }

  /**
   * Public method that adds the candidate to the ArrayList candidates only if there is no other
   * candidate in the party that is running for the same office
   * 
   * @param c - a candidate that the method attempts to add to the ArrayList candidates
   * @throws IllegalArgumentException if candidate is running for the same office as another
   *                                  candidate in this party
   */
  public void addCandidate(Candidate c) {
    // calls the private method search to see if there is another candidate in the party running for
    // the same office
    if (search(candidates, c.getOffice()) == -1 && c != null) {
      // adds the candidate to the ArrayList if there is no other candidate in the party running for
      // the same office
      candidates.add(c);
    }
    // throws IllegalArgumentExcpetion if there is another candidate running for the same office in
    // this party
    else {
      throw new IllegalArgumentException(
          "Error: Candidate running for same office as another candidate in this party");
    }
  }
}
