package biljard.grbk.elnes.rating.player;

public class PlayerGroupC extends Player {

  /**
   * Constructor for the class Player.
   *
   * @param firstName The player's name.
   * @param lastName  The player's last name.
   * @param rating    The player's rating.
   */
  public PlayerGroupC(String firstName, String lastName, Rating rating) {
    super(firstName, lastName, rating);
  }

  @Override
  public int getRatingChange(boolean win, Player opponent) {
    if (win) {
      return switch (opponent.getGroup()) {
        case A, B -> 2;
        case C, D, E -> 1;
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
