package biljard.grbk.elnes.rating.rating;

import biljard.grbk.elnes.rating.player.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Handicap {


  /**
   * Method that calculates the handicap in a match between two pool players.
   *
   * @param player1   Player 1.
   * @param player2   Player 2.
   * @return          A list with three integers, where first integer is the handicap of player 1, second integer is
   *                  rating of player 2, and the third integer is the distance of the match.
   */
  public static List<Integer> calculateHandicap(Player player1, Player player2) {
    List<Integer> handicapP1Strongest = new ArrayList<>();
    List<Integer> handicapP2Strongest = new ArrayList<>();

    //sets highest and lowest rating numbers.
    int rating1 = player1.getRatingNumber();
    int rating2 = player2.getRatingNumber();
    boolean player1Strongest = true;
    int highestRating = rating1;
    int lowestRating = rating2;
    if(rating1 < rating2)  {
      player1Strongest = false;
      highestRating = rating2;
      lowestRating = rating1;
    }
    int ratingDifference = highestRating - lowestRating;

    //Return an empty list if rating of the highest rated player is below 0 ... something strange has happened.
    if (highestRating < 0) return Collections.emptyList();

    //Delegates calculation to a specific method depending on what the rating of the highest rated player is.
    if (highestRating >= 95) {
      handicapP1Strongest = handicapClassA(ratingDifference);
    } else if (highestRating > 70){
      handicapP1Strongest = handicapClassB(ratingDifference);
    } else if(highestRating > 50) {
      handicapP1Strongest = handicapClassC(ratingDifference);
    } else {
      handicapP1Strongest = handicapClassD(ratingDifference);
    }

    //changes the order of the handicap if player2 has higher rating, then returns a List with the handicap and
    //distance where first integer is player 1's handicap, second is player 2's handicap, and third is distance.
    if (!player1Strongest) {
      Collections.addAll(handicapP2Strongest, handicapP1Strongest.get(1), handicapP1Strongest.get(0), handicapP1Strongest.get(2));
      return handicapP2Strongest;
    } else {
      return handicapP1Strongest;
    }
  }

  private static List<Integer> handicapClassD(int ratingDifference){
    List<Integer> handicap = new ArrayList<>();
    if (ratingDifference >= 0 && ratingDifference < 11) {
      Collections.addAll(handicap, 0, 0, 3);
    } else if (ratingDifference >= 11 && ratingDifference < 27) {
      Collections.addAll(handicap, 0, 1, 3);
    } else if (ratingDifference >= 27 && ratingDifference < 39) {
      Collections.addAll(handicap, 0, 2, 4);
    } else {
      Collections.addAll(handicap, 0, 3, 5);
    }
    return handicap;
  }

  private static List<Integer> handicapClassC(int ratingDifference){
    List<Integer> handicap = new ArrayList<>();
    if (ratingDifference >= 0 && ratingDifference < 7) {
      Collections.addAll(handicap, 0, 0, 4);
    } else if (ratingDifference >= 7 && ratingDifference < 19) {
      Collections.addAll(handicap, 0, 1, 4);
    } else if (ratingDifference >= 19 && ratingDifference < 30) {
      Collections.addAll(handicap, 0, 2, 5);
    } else if (ratingDifference >= 30 && ratingDifference < 40) {
      Collections.addAll(handicap, 0, 2, 4);
    } else if (ratingDifference >= 40 && ratingDifference < 55) {
      Collections.addAll(handicap, 0, 3, 5);
    } else {
      Collections.addAll(handicap, 0, 4, 6);
    }
    return handicap;
  }

  private static List<Integer> handicapClassB(int ratingDifference){
    List<Integer> handicap = new ArrayList<>();
    if (ratingDifference >= 0 && ratingDifference < 7) {
      Collections.addAll(handicap, 0, 0, 5);
    } else if (ratingDifference >= 7 && ratingDifference < 16) {
      Collections.addAll(handicap, 0, 1, 5);
    } else if (ratingDifference >= 16 && ratingDifference < 24) {
      Collections.addAll(handicap, 0, 2, 6);
    } else if (ratingDifference >= 24 && ratingDifference < 33) {
      Collections.addAll(handicap, 0, 2, 5);
    } else if (ratingDifference >= 33 && ratingDifference < 42) {
      Collections.addAll(handicap, 0, 3, 6);
    } else if (ratingDifference >= 42 && ratingDifference < 52) {
      Collections.addAll(handicap, 0, 4, 7);
    } else if (ratingDifference >= 52 && ratingDifference < 75) {
      Collections.addAll(handicap, 0, 4, 6);
    } else {
      Collections.addAll(handicap, 0, 5, 7);
    }
    return handicap;
  }

  private static List<Integer> handicapClassA(int ratingDifference){
    List<Integer> handicap = new ArrayList<>();
    if (ratingDifference >= 0 && ratingDifference < 7) {
      Collections.addAll(handicap, 0, 0, 6);
    } else if (ratingDifference >= 7 && ratingDifference < 14) {
      Collections.addAll(handicap, 0, 1, 6);
    } else if (ratingDifference >= 14 && ratingDifference < 21) {
      Collections.addAll(handicap, 0, 2, 7);
    } else if (ratingDifference >= 21 && ratingDifference < 31) {
      Collections.addAll(handicap, 0, 2, 6);
    } else if (ratingDifference >= 31 && ratingDifference < 41) {
      Collections.addAll(handicap, 0, 3, 7);
    } else if (ratingDifference >= 41 && ratingDifference < 52) {
      Collections.addAll(handicap, 0, 3, 6);
    } else if (ratingDifference >= 52 && ratingDifference < 60) {
      Collections.addAll(handicap, 0, 4, 7);
    } else if (ratingDifference >= 60 && ratingDifference < 67) {
      Collections.addAll(handicap, 0, 5, 8);
    } else if (ratingDifference >= 67 && ratingDifference < 85) {
      Collections.addAll(handicap, 0, 5, 7);
    } else {
      Collections.addAll(handicap,0, 6, 8);
    }
    return handicap;
  }

}
