package biljard.grbk.elnes.rating.player;

import java.time.LocalDate;

public class RatingFactory {

  public static Rating createRatingInstance(Player.PlayerGroup group, int ratingNumber) {
    return switch (group) {
      case A -> new RatingGroupA(ratingNumber, LocalDate.now());
      case B -> new RatingGroupB(ratingNumber, LocalDate.now());
      case C -> new RatingGroupC(ratingNumber, LocalDate.now());
      case D -> new RatingGroupD(ratingNumber, LocalDate.now());
      case E -> new RatingGroupE(ratingNumber, LocalDate.now());
    };
  }

}
