package biljard.grbk.elnes.rating.player;

import java.time.LocalDate;

public class RatingGroupD extends Rating {

  public RatingGroupD(int rating, LocalDate date) {
    super(rating, date);
  }

  @Override
  public int getRatingChange(boolean win, Rating opponentRating) {
    if (win) {
      return switch (opponentRating.getGroup()) {
        case A -> 3;
        case B, C, D -> 2;
        case E -> 1;
      };
    } else {
      return switch (opponentRating.getGroup()) {
        case A, B -> -1;
        case C, D, E -> -2;
      };
    }
  }
}
