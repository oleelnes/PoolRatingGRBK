package biljard.grbk.elnes.rating;

import biljard.grbk.elnes.rating.player.Player;
import biljard.grbk.elnes.rating.rating.Handicap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HandicapTest {
  Player playerRating120;
  Player playerRating100;
  Player playerRating80;
  Player playerRating40;
  Player playerRating20;
  List<Integer> handicap;

  @BeforeEach
  public void beforeEach(){
    playerRating120 = new Player("Highest rated", "Player", 120, 120120);
    playerRating100 = new Player("Second Higest Rated", "Player", 100, 100100);
    playerRating80 = new Player("Medium Rated", "Player", 80, 180180);
    playerRating40 = new Player("Second Lowest Rated", "Player", 40, 140140);
    playerRating20 = new Player("Lowest Rated", "Player", 20, 920920);
    List<Integer> handicap = new ArrayList<>();
  }

  @Test
  public void match100vs80(){
    handicap = Handicap.calculateHandicap(playerRating100, playerRating80);
    int rating1 = playerRating100.getRatingNumber();
    int rating2 = playerRating80.getRatingNumber();
    System.out.println("player 1 (" + rating1 + ") " + handicap.get(0) + " (" + handicap.get(2) + ") "
        + handicap.get(1) + " player 2 (" + rating2 +")");
    List<Integer> handicapActual = new ArrayList<>();
    Collections.addAll(handicapActual, 0, 2, 7);
    assertEquals(handicapActual, handicap);
  }


}
