package biljard.grbk.elnes.rating.player;

import java.time.LocalDate;

public class RatingGroupD extends Rating {
  private Player.PlayerGroup group;


  public RatingGroupD(int rating, LocalDate date) {
    super(rating, date);
    group = Player.PlayerGroup.D;
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

  @Override
  public String getType() {
    return "Group D";
  }

  @Override
  public Player.PlayerGroup getGroup() {
    return group;
  }
}
