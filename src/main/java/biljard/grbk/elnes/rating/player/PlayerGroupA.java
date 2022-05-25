package biljard.grbk.elnes.rating.player;

public class PlayerGroupA extends Player {

  public PlayerGroupA(String firstName, String lastName, Rating rating) {
    super(firstName, lastName, rating);
  }

  @Override
  public int getRatingChange(boolean win, Player opponent) {
    if (win) return 1;
    else {
      return switch (opponent.getGroup()) {
        case A -> -1;
        case B, C, D-> -2;
        case E -> -3;
      };
    }
  }
}
