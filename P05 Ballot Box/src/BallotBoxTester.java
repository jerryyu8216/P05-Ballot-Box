//////////////// P05 Ballot Box //////////////////////////
//
// Title: BallotBoxTester
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

public class BallotBoxTester {
  /**
   * Main method to call the test methods
   * 
   * @param args - input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testCandidate: " + testCandidate());
    System.out.println("testPartyConstructor: " + testPartyConstructor());
    System.out.println("testPartyGetCandidate: " + testPartyGetCandidate());
    System.out.println("testPartyGetSize: " + testPartyGetSize());
    System.out.println("testBallot: " + testBallot());
    System.out.println("testBallotGetVote: " + testBallotGetVote());
    System.out.println("testBallotGetCandidates: " + testBallotGetCandidates());
    System.out.println("testBallotBox: " + testBallotBox());
  }

  /**
   * Checks whether the Candidate class creates candidate objects correctly, and if the correct
   * exceptions are thrown when they are needed to
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCandidate() {
    try {
      // creates a new candidate object to test
      Candidate jerry = new Candidate("Jerry", "Vice President");
      // checks that the getName() method is working
      if (!(jerry.getName().equals("Jerry"))) {
        return false;
      }
      // checks that the getOffice() method is working
      if (!(jerry.getOffice().equals("Vice President"))) {
        return false;
      }
      // checks that the toString() method is working
      if (!(jerry.toString().equals("Jerry(Vice President)"))) {
        return false;
      }
      try {
        // creates a new candidate object with an incorrect office
        Candidate tom = new Candidate("Tom", "Treasurer");
        System.out.println(
            "Error: IllegalArgumentException was not thrown when nonexistent office was thrown");
        return false;
      } catch (IllegalArgumentException i) {
        // catch only the expected exception to be thrown -- no problem detected
      }
    } catch (Exception e) {
      System.out.println("Error: Unknown exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * Checks whether the Party constructor method creates party objects correctly
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testPartyConstructor() {
    try {
      // creates a new party object to test
      Party rep = new Party("Republican");
      // checks that the getName() method works properly
      if (!(rep.getName().equals("Republican"))) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Error: Unknown exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * Checks whether the getCandidate() method in the Party class works properly and throws
   * exceptions when its supposed to
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testPartyGetCandidate() {
    try {
      // creates three candidates to test different scenarios
      Candidate Trump = new Candidate("Trump", "President");
      Candidate Pence = new Candidate("Pence", "Vice President");
      Candidate Timothy = new Candidate("Timothy", "President");
      // creates expected string to test the getCandidate() method
      String expected = "Trump(President)";
      // creates a new party object to test
      Party rep = new Party("Republican");
      // adding two candidates with different offices into a party
      rep.addCandidate(Trump);
      rep.addCandidate(Pence);
      // checks that the getCandidate() method works when asked to find an existing candidate
      if (!(rep.getCandidate("President").toString().equals(expected))) {
        return false;
      }
      // checks that the getCandidate() method works when asked to find a non-existent candidate
      try {
        rep.getCandidate("Secretary");
        System.out.println("Error: NoSuchElementException was not thrown");
        return false;
      } catch (NoSuchElementException n) {
        // catch only the expected exception to be thrown -- no problem detected
      }
      // checks that the addCandidate() method works when adding a candidate with the same
      // office as existing candidate
      try {
        rep.addCandidate(Timothy);
        System.out.println("Error: IllegalArgumentException was not thrown");
        return false;
      } catch (IllegalArgumentException i) {
        // catch only the expected exception to be thrown -- no problem detected
      }
    } catch (Exception e) {
      System.out.println("Error: Unknown exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * Checks whether the Party getSize() method works properly
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testPartyGetSize() {
    try {
      // creates two candidates to be added to a party
      Candidate Trump = new Candidate("Trump", "President");
      Candidate Pence = new Candidate("Pence", "Vice President");
      // creates a party object to be tested
      Party rep = new Party("Republican");
      // adds the two candidates to the party
      rep.addCandidate(Trump);
      rep.addCandidate(Pence);
      // checks that the getSize() method works properly
      if (rep.getSize() != 2) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Error: Unknown exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * Checks whether the Ballot constructor method creates ballot objects correctly
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBallot() {
    try {
      // creates two new ballots to test
      Ballot b1 = new Ballot();
      Ballot b2 = new Ballot();
      // checks that the equals() method works and that the ballots are given unique ID's
      if (b1.equals(b2)) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Error: Unknown exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * Checks whether the Ballot getVote() method works properly
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBallotGetVote() {
    try {
      // creates a new ballot object to test
      Ballot b1 = new Ballot();
      // creates two candidates of different parties to be tested
      Candidate Trump = new Candidate("Trump", "President");
      Candidate Biden = new Candidate("Biden", "President");
      // creates two different parties to be tested
      Party rep = new Party("Republican");
      Party dem = new Party("Democrat");
      // adds the candidates to their respective parties
      rep.addCandidate(Trump);
      dem.addCandidate(Biden);
      // adds the parties to the ballot
      Ballot.addParty(rep);
      Ballot.addParty(dem);
      // calls the vote() method to vote for a candidate
      b1.vote(Biden);
      // checks that the getVote() method works
      if (!(b1.getVote("President").equals(Biden))) {
        return false;
      }
      // calls the vote() method for a different candidate
      b1.vote(Trump);
      // checks to see if the previous vote was overwritten or not
      if (!(b1.getVote("President").equals(Trump))) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Error: Unknown exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * Checks whether the Ballot getCandidates method works correctly
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBallotGetCandidates() {
    try {
      // creates two candidates to be tested
      Candidate Trump = new Candidate("Trump", "President");
      Candidate Biden = new Candidate("Biden", "President");
      // creates an expected ArrayList to compare to the getCandidates() method
      ArrayList<Candidate> expected = new ArrayList<Candidate>();
      expected.add(Trump);
      expected.add(Biden);
      // checks that the contents of the getCandidates() method contains the same values as the
      // expected ArrayList
      for (int i = 0; i < expected.size(); i++) {
        if (Ballot.getCandidates("President").contains(expected.get(i))) {
          return false;
        }
      }
    } catch (Exception e) {
      System.out.println("Error: Unknown exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * Checks whether the BallotBox constructor method creates BallotBox objects correctly, and the
   * methods from the BallotBox class work properly
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBallotBox() {
    try {
      // creates a new ballot box to be tested
      BallotBox election = new BallotBox();
      // creates three new ballots to help with testing
      Ballot b1 = new Ballot();
      Ballot b2 = new Ballot();
      Ballot b3 = new Ballot();
      // creates two new candidates to help with testing
      Candidate Trump = new Candidate("Trump", "President");
      Candidate Biden = new Candidate("Biden", "President");
      // creates two new parties to help with testing
      Party rep = new Party("Republican");
      Party dem = new Party("Democrat");
      // adds the candidates to their respective parties
      rep.addCandidate(Trump);
      dem.addCandidate(Biden);
      // adds the parties to the ballot
      Ballot.addParty(rep);
      Ballot.addParty(dem);
      // ballots cast votes
      b1.vote(Trump);
      b2.vote(Biden);
      b3.vote(Trump);
      // checks that the submit() method works properly
      election.submit(b1);
      election.submit(b2);
      election.submit(b3);
      // checks that the getNumBallots() method works properly
      if (election.getNumBallots() != 3) {
        return false;
      }
      // checks that the getWinner() method works properly
      if (!(election.getWinner("President").toString().equals(Trump.toString()))) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Error: Unknown exception was thrown");
      return false;
    }
    return true;
  }
}
