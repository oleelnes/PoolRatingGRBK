package biljard.grbk.elnes.rating.player;

public abstract class Player {
  private String firstName;
  private String lastName;
  private Rating rating;
  private String cuescoreID;

  /**
   * Constructor for the class Player.
   *
   * @param firstName The player's name.
   * @param lastName  The player's last name.
   * @param rating    The player's rating.
   */
  public Player(String firstName, String lastName, Rating rating) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.rating = rating;
  }

  public Rating getRating() {
    return rating;
  }


}
