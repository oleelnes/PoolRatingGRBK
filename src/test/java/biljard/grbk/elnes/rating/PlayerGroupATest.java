package biljard.grbk.elnes.rating;


import biljard.grbk.elnes.rating.player.Player;
import biljard.grbk.elnes.rating.rating.Rating;
import biljard.grbk.elnes.rating.rating.RatingFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerGroupATest {
  Player player;
  Player player2;

  @BeforeEach
  public void beforeEach(){
    player = new Player("Ole Kristian", "Elnæs", 100, 121212);
    player2 = new Player("Arne", "Bjarne", 77, 120931);
    //rating = new Rating(100, LocalDate.of(2022, 05, 25));
    //playerGB = new PlayerGroupB("Ole Kristian", "Elnæs", rating);

    //player2 = new PlayerGroupB("Dum", "Dummesen",
      //  new Rating(98, LocalDate.of(2021, 12, 20)));
  }

  @Test
  public void player1WinTest(){
    System.out.println(player.getRatingNumber());
    player.changeRating(true, player2.getRating());
    System.out.println(player.getRatingNumber());
  }

  @Test
  public void winAgainstBPlayerTest(){
    //assertEquals(2, playerGB.getRatingChange(true, player2));
  }

  @Test
  public void lossAgainstBPlayerTest(){
   // playerGB.changeRating(false, player2);
    //assertEquals(98, playerGB.getRating());


  }

  @Test
  public void fallDownIntoGroupCTest(){
   // for (int i = 0; i < 6; i++) {
     // playerGB.changeRating(false, player2);
   // }
   // System.out.println("rating: " + playerGB.getRating());
   // assertEquals(Player.PlayerGroup.C, playerGB.getGroup());
  }
}
