package biljard.grbk.elnes.rating.player;

public abstract class Player {
  private String firstName;
  private String lastName;
  private Rating rating;
  private PlayerGroup group;

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
    this.group = selectGroup(rating.getRating());
  }

  /**
   * The different player groups a player can inhabit, depending on their
   * rating.
   */
  public enum PlayerGroup {
    A,
    B,
    C,
    D,
    E;
  }
  private PlayerGroup selectGroup(int ratingNumber){
    if (ratingNumber < 40) return PlayerGroup.E;
    else if (ratingNumber < 60) return PlayerGroup.D;
    else if (ratingNumber < 90) return PlayerGroup.C;
    else if (ratingNumber < 115) return PlayerGroup.B;
    return PlayerGroup.A;
  }

  /**
   * Method that changes the player's rating.
   *
   * @param win       Whether the player won.
   * @param opponent  The opponent.
   */
  public void changeRating(boolean win, Player opponent) {
    rating.setRating(rating.getRating() + getRatingChange(win, opponent));
    group = selectGroup(rating.getRating());
  }

  /**
   * Method that returns the change in rating as a result of data fed.
   *
   * @param win       Whether the player won.
   * @param opponent  The opponent.
   * @return          The change in rating as a result of data fed.
   */
  public abstract int getRatingChange(boolean win, Player opponent);

  public PlayerGroup getGroup(){
    return group;
  }

  public int getRating() {
    return rating.getRating();
  }


}
