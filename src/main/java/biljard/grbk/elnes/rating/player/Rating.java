package biljard.grbk.elnes.rating.player;

import java.time.LocalDate;

public abstract class Rating {
  private int rating;
  private LocalDate date;
  private PlayerGroup group;


  public Rating(int rating, LocalDate date) {
    this.rating = rating;
    this.date = date;
    this.group = selectGroup(getRating());
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

  /**
   * Method that returns the rating group a player belongs to depending
   * on their rating.
   *
   * @param ratingNumber  The player's rating number.
   * @return              The group with which the player belongs.
   */
  public PlayerGroup selectGroup(int ratingNumber){
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
   * @param opponentRating  The opponentRating.
   */
  public void changeRating(boolean win, Rating opponentRating) {
    setRating(getRating() + getRatingChange(win, opponentRating));
    group = selectGroup(getRating());
  }

  /**
   * Method that returns the change in rating as a result of data fed.
   *
   * @param win       Whether the player won.
   * @param opponentRating  The opponent.
   * @return          The change in rating as a result of data fed.
   */
  public abstract int getRatingChange(boolean win, Rating opponentRating);

  public PlayerGroup getGroup(){
    return group;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}
