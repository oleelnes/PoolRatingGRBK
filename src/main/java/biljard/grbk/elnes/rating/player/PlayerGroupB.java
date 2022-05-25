package biljard.grbk.elnes.rating.player;

public class PlayerGroupB extends Player {


  public PlayerGroupB(String firstName, String lastName, Rating rating) {
    super(firstName, lastName, rating);
  }

  @Override
  public int getRatingChange(boolean win, Player opponent) {
    if (win){
      return switch (opponent.getGroup()) {
        case A, B -> 2;
        case C, D, E -> 1;
      };
    }
    else {
      return switch (opponent.getGroup()) {
        case A, B -> -1;
        case C, D, E -> -2;
      };
    }
  }
}
