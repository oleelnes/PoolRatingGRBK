package biljard.grbk.elnes.rating.player;

public class PlayerGroupB extends Player {


  public PlayerGroupB(String firstName, String lastName, Rating rating,
                      PlayerRatingHistory playerRatingHistory) {
    super(firstName, lastName, rating, playerRatingHistory);
  }

  @Override
  public int getRatingChange(boolean win, Player opponent) {
    if (win){
      return switch (opponent.getGroup()) {
        case A, B, C -> 2;
        case D, E -> 1;
      };
    }
    else {
      return switch (opponent.getGroup()) {
        case A -> -1;
        case B, C, D, E -> -2;
      };
    }
  }
}
