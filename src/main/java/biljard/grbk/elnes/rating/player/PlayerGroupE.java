package biljard.grbk.elnes.rating.player;

import java.time.LocalDate;

public class PlayerGroupE extends Rating {


  public PlayerGroupE(int rating, LocalDate date) {
    super(rating, date);
  }

  @Override
  public int getRatingChange(boolean win, Rating opponentRating) {
    if (win) {
      return switch (opponentRating.getGroup()) {
        case A -> 3;
        case B, C, D, E -> 2;
      };
    } else {
      return switch (opponentRating.getGroup()) {
        case A, B, C -> -1;
        case D, E -> -2;
      };
    }
  }
}
