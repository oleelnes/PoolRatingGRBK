package biljard.grbk.elnes.rating;


import biljard.grbk.elnes.rating.player.Player;
import biljard.grbk.elnes.rating.player.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerGroupATest {
  Player playerGB;
  Rating rating;
  Player player2;

  @BeforeEach
  public void beforeEach(){
    //rating = new Rating(100, LocalDate.of(2022, 05, 25));
    //playerGB = new PlayerGroupB("Ole Kristian", "Elnæs", rating);

    //player2 = new PlayerGroupB("Dum", "Dummesen",
      //  new Rating(98, LocalDate.of(2021, 12, 20)));
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
