package biljard.grbk.elnes.rating.player;

public class PlayerGroupE extends Player {
  /**
   * Constructor for the class Player.
   *
   * @param firstName The player's name.
   * @param lastName  The player's last name.
   * @param rating    The player's rating.
   */
  public PlayerGroupE(String firstName, String lastName, Rating rating) {
    super(firstName, lastName, rating);
  }

  @Override
  public int getRatingChange(boolean win, Player opponent) {
    if (win) {
      return switch (opponent.getGroup()) {
        case A -> 3;
        case B, C, D, E -> 2;
      };
    } else {
      return switch (opponent.getGroup()) {
        case A, B, C -> -1;
        case D, E -> -2;
      };
    }
  }
}
