//////////////// P05 Ballot Box //////////////////////////
//
// Title: BallotBox
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

public class BallotBox {
  // private instance variable that contains all of the ballots cast
  private ArrayList<Ballot> ballots;

  /**
   * Public constructor method that creates a new BallotBox object and initializes the ballots
   * ArrayList
   * 
   */
  public BallotBox() {
    // initializes the ArrayList ballots
    ballots = new ArrayList<Ballot>();
  }

  /**
   * Public method that returns the number of ballots cast
   * 
   * @return the number of ballots cast
   */
  public int getNumBallots() {
    return ballots.size();
  }

  /**
   * Public method that counts up all votes cast for each candidate and returns the candidate with
   * the most votes for the specified office
   * 
   * @param office - the office that the method is counting votes for
   * @return the candidate with the most votes or null if no votes are cast or null if there are no
   *         candidates
   */
  public Candidate getWinner(String office) {
    // creates an int array to keep track of each candidates votes
    int[] voteTally = new int[Ballot.getCandidates(office).size()];
    // checks if the list of candidates is empty
    if (Ballot.getCandidates(office).isEmpty() == true) {
      // if there are no candidates then null is returned
      return null;
    } else {
      // adds the number of votes for each candidate into the voteTally array
      for (int i = 0; i < voteTally.length; i++) {
        voteTally[i] = count(Ballot.getCandidates(office).get(i), office);
      }
      // checks if there were votes cast
      if (voteTally[compare(voteTally)] != 0) {
        // if there were then it returns the Candidate that got the most votes
        return Ballot.getCandidates(office).get(compare(voteTally));
      }
      // returns null if there were no votes cast
      else {
        return null;
      }
    }
  }

  /**
   * Private helper method that counts the number of votes a specific candidate got
   * 
   * @param c      - the candidate the method is counting votes for
   * @param office - the office the candidate is running for
   * @return the number of votes the candidate got
   */
  private int count(Candidate c, String office) {
    // initializes an integer that will count the number of votes
    int voteCounter = 0;
    // iterates through the ballots ArrayList to find how many times the candidate was voted for
    for (int i = 0; i < ballots.size(); i++) {
      // if the candidate is voted for then voteCounter increases by 1
      if (ballots.get(i).getVote(office).toString().equals(c.toString())) {
        voteCounter++;
      }
    }
    // returns the number of votes after the ArrayList has been completely iterated through
    return voteCounter;
  }

  /**
   * Private helper method that compares all the values in an int array and finds the largest value
   * 
   * @param tally - the int array the method is using to search for the largest value
   * @return the index of the largest value in the array
   */
  private int compare(int[] tally) {
    int index = 0;
    for (int i = 0; i < tally.length;) {
      if (tally[i] > tally[index]) {
        index = i;
        i++;
      } else {
        i++;
      }
    }
    return index;
  }

  /**
   * Public method that adds a ballot to the ArrayList of ballots if and only if the ballot is not
   * already in the ArrayList
   * 
   * @param b - the ballot that needs to be added
   */
  public void submit(Ballot b) {
    // calls the private helper method to check if the ballot is already in the ArrayList
    if (check(b)) {
      // if not then it adds the ballot to the ArrayList
      ballots.add(b);
    }
  }

  /**
   * Private helper method that determines if the ballot is already in the ArrayList ballots
   * 
   * @param b - the ballot that is being checked
   * @return false if the ballot is already in the ArrayList and true if not
   */
  private boolean check(Ballot b) {
    // iterates through the ballots array to see if b matches any of the ballots
    for (int i = 0; i < ballots.size(); i++) {
      if (ballots.get(i).equals(b) == true) {
        // returns false if the ballot was already found in the ArrayList
        return false;
      }
    }
    // returns true if the ballot is not inside the ArrayList
    return true;
  }
}
