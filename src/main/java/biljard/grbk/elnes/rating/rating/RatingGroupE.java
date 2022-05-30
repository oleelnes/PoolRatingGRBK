package biljard.grbk.elnes.rating.rating;

import biljard.grbk.elnes.rating.player.Player;

import java.time.LocalDate;

public class RatingGroupE extends Rating {
  private Player.PlayerGroup group;


  public RatingGroupE(int rating, LocalDate date) {
    super(rating, date);
    group = Player.PlayerGroup.E;
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

  @Override
  public String getType() {
    return "Group E";
  }

  @Override
  public Player.PlayerGroup getGroup() {
    return group;
  }
}
