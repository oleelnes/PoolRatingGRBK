package biljard.grbk.elnes.rating.player;

import java.time.LocalDate;

public class RatingGroupC extends Rating {
  private Player.PlayerGroup group;


  public RatingGroupC(int rating, LocalDate date) {
    super(rating, date);
    group = Player.PlayerGroup.C;
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

  @Override
  public String getType() {
    return "Group C";
  }

  @Override
  public Player.PlayerGroup getGroup() {
    return group;
  }
}
