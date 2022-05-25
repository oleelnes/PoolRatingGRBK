package biljard.grbk.elnes.rating.player;

import java.time.LocalDate;

public class RatingGroupB extends Rating {


  public RatingGroupB(int rating, LocalDate date) {
    super(rating, date);
  }

  @Override
  public int getRatingChange(boolean win, Rating opponentRating) {
    if (win){
      return switch (opponentRating.getGroup()) {
        case A, B -> 2;
        case C, D, E -> 1;
      };
    }
    else {
      return switch (opponentRating.getGroup()) {
        case A, B -> -1;
        case C, D, E -> -2;
      };
    }
  }

}
