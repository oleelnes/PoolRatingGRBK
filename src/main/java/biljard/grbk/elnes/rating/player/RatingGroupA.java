package biljard.grbk.elnes.rating.player;

import java.time.LocalDate;

public class RatingGroupA extends Rating {


  public RatingGroupA(int rating, LocalDate date) {
    super(rating, date);
  }

  @Override
  public int getRatingChange(boolean win, Rating opponentRating) {
    if (win) return 1;
    else {
      return switch (opponentRating.getGroup()) {
        case A -> -1;
        case B, C, D-> -2;
        case E -> -3;
      };
    }
  }
}
