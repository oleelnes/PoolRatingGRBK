package biljard.grbk.elnes.rating.rating;

import biljard.grbk.elnes.rating.player.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Handicap {

  public static List<Integer> calculateHandicap(Player player1, Player player2) {
    List<Integer> handicapP1Strongest = new ArrayList<>();
    List<Integer> handicapP2Strongest = new ArrayList<>();

    int rating1 = player1.getRatingNumber();
    int rating2 = player2.getRatingNumber();
    int highestRating = rating1;
    int lowestRating = rating2;
    if(rating1 < rating2)  {
      highestRating = rating2;
      lowestRating = rating1;
    }

    if (highestRating >= 95) {
      handicapP1Strongest = handicapClassA(highestRating, lowestRating);
    } else if (highestRating > 70){

    } else if(highestRating > 50) {

    } else {

    }

    if (rating2 > rating1) {
      Collections.addAll(handicapP2Strongest, handicapP1Strongest.get(1), handicapP1Strongest.get(0), handicapP1Strongest.get(2));
      return handicapP2Strongest;
    } else {
      return handicapP1Strongest;
    }
  }

  private static List<Integer> handicapClassD(int highestRating, int lowestRating){
    List<Integer> handicap = new ArrayList<>();
    return handicap;
  }

  private static List<Integer> handicapClassC(int highestRating, int lowestRating){
    List<Integer> handicap = new ArrayList<>();
    return handicap;
  }

  private static List<Integer> handicapClassB(int highestRating, int lowestRating){
    List<Integer> handicap = new ArrayList<>();
    return handicap;
  }

  private static List<Integer> handicapClassA(int highestRating, int lowestRating){
    List<Integer> handicap = new ArrayList<>();
    int ratingDifference = highestRating - lowestRating;
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
