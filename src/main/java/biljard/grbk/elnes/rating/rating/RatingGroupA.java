package biljard.grbk.elnes.rating.rating;

import biljard.grbk.elnes.rating.player.Player;

import java.time.LocalDate;

public class RatingGroupA extends Rating {
  private Player.PlayerGroup group;


  public RatingGroupA(int rating, LocalDate date) {
    super(rating, date);
    group = Player.PlayerGroup.A;
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

  @Override
  public String getType() {
    return "Group A";
  }

  @Override
  public Player.PlayerGroup getGroup() {
    return group;
  }
}
