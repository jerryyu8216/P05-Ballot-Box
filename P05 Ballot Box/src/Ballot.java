//////////////// P05 Ballot Box //////////////////////////
//
// Title: Ballot
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

public class Ballot {
  // private class variable that contains all parties present on the ballot
  private static ArrayList<Party> parties = new ArrayList<Party>();
  // private class variable that helps assign each ballot a unique id
  private static int counter;
  // private instance variable that holds the votes of the ballot
  private Candidate[] votes;
  // private instance variable that represents the ballot's unique id
  private int ID;

  /**
   * Public method that adds the provided party to the class variable parties if it is not already
   * on the ballot
   * 
   * @param p - a party that needs to be added to the ballot
   */
  public static void addParty(Party p) {
    // checks to see if the given party is already in the ArrayList parties
    if (!(parties.contains(p))) {
      // if not then it adds it to the ArrayList
      parties.add(p);
    }
  }

  /**
   * Public method that creates a new ArrayList and adds all the candidates running for the provided
   * office into the ArrayList
   * 
   * @param office - the candidates running for this office will be added to the new ArrayList
   * @return the newly created ArrayList that contains all of the candidates running for the
   *         provided office
   */
  public static ArrayList<Candidate> getCandidates(String office) {
    // initializes the new ArrayList that will contain the candidates running for the same office
    ArrayList<Candidate> race = new ArrayList<Candidate>();
    // iterates through the party array to find candidates from each party running for the inputed
    // office
    for (int i = 0; i < parties.size();) {
      try {
        // if the party has a candidate running for the inputed office then the candidate is added
        race.add((parties.get(i).getCandidate(office)));
        i++;
        // catches a NoSuchElementException for parties that don't have candidates for the specified
        // office and continues to iterate through the ArrayList
      } catch (NoSuchElementException e) {
        i++;
      }
    }
    // returns the ArrayList containing all of the candidates running for the same office
    return race;
  }

  /**
   * Public constructor method that creates a new ballot object and initializes the Candidate array
   * with null values and assigns the ballot with a unique ID
   * 
   */
  public Ballot() {
    // initializes the votes array with the same size as the OFFICE array in candidates
    votes = new Candidate[Candidate.OFFICE.length];
    // fills each value of the votes array with a null value
    for (int i = 0; i < votes.length; i++) {
      votes[i] = null;
    }
    // assigns the ballot a unique ID
    ID = counter;
    counter++;
  }

  /**
   * Public method gets the candidate from a specified office that the ballot voted for
   * 
   * @param office - the office the ballot is attempting to find the vote for
   * @return the candidate of the specified office the ballot voted for or null if no vote was cast
   *         for the specific office
   */
  public Candidate getVote(String office) {
    // calls the private method findVote to find the index of the candidate within the votes array
    if (findVote(office) != -1) {
      // returns the candidate
      return votes[findVote(office)];
    }
    // if there is no vote for this office then null is returned
    else {
      return null;
    }
  }

  /**
   * Private helper method that attempts to find the index of the candidate the ballot voted for,
   * for a specific office
   * 
   * @param office - the office the ballot is attempting to find the vote for
   * @return the index of the candidate within the votes array
   */
  private int findVote(String office) {
    // iterates through the votes array
    for (int i = 0; i < votes.length; i++) {
      // checks to see if there is a vote for a candidate for the specified office
      if (votes[i] != null && votes[i].getOffice().equals(office)) {
        // returns the index if a candidate is found
        return i;
      }
    }
    // returns -1 otherwise
    return -1;
  }

  /**
   * Returns true if the argument is equal to this Ballot, false otherwise
   * 
   * @param o the object to compare to this Ballot
   * @return true if the Ballots have the same ID, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (o == (Ballot) o && ID == ((Ballot) o).getID()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Private helper method that gets the ID of the ballot
   * 
   * @return the ID of the ballot
   */
  private int getID() {
    return ID;
  }

  /**
   * Public method that adds a candidate to the votes array
   * 
   * @param c - the candidate the ballot is voting for
   */
  public void vote(Candidate c) {
    // iterates through the OFFICE array in the Candidate class
    for (int i = 0; i < votes.length; i++) {
      // checks if the candidate is running for a valid office
      if (c.getOffice() == Candidate.OFFICE[i]) {
        // adds the candidate into array at the same index that the office was found at in OFFICE
        votes[i] = c;
      }
    }
  }
}
