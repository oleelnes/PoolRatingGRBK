package biljard.grbk.elnes.rating.player;

import java.time.LocalDate;

public class RatingGroupC extends Rating {


  public RatingGroupC(int rating, LocalDate date) {
    super(rating, date);
  }

  @Override
  public int getRatingChange(boolean win, Rating opponentRating) {
    if (win) {
      return switch (opponentRating.getGroup()) {
        case A, B -> 2;
        case C, D, E -> 1;
      };
    }
    else {
      return switch (opponentRating.getGroup()) {
        case A -> -1;
        case B, C, D, E -> -2;
      };

    }
  }
}
