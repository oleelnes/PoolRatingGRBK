package biljard.grbk.elnes.rating.rating;

import biljard.grbk.elnes.rating.player.Player;

import java.time.LocalDate;

public class RatingGroupB extends Rating {
  private Player.PlayerGroup group;


  public RatingGroupB(int rating, LocalDate date) {
    super(rating, date);
    group = Player.PlayerGroup.B;
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

  @Override
  public String getType() {
    return "Group B";
  }

  @Override
  public Player.PlayerGroup getGroup() {
    return group;
  }

}
