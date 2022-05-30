package biljard.grbk.elnes.rating.rating;

import biljard.grbk.elnes.rating.player.Player;

import java.time.LocalDate;

public abstract class Rating {
  private int rating;
  private LocalDate date;
  private LocalDate initialDate;

  /**
   * Constructor for the class Rating.
   *
   * @param rating  The rating.
   * @param date    The date
   */
  public Rating(int rating, LocalDate date) {
    this.rating = rating;
    this.date = date;
    this.initialDate = date;
  }



  /**
   * Method that changes the player's rating.
   *
   * @param win       Whether the player won.
   * @param opponentRating  The opponentRating.
   */
  public void changeRating(boolean win, Rating opponentRating) {
    setRating(getRating() + getRatingChange(win, opponentRating), LocalDate.now());
    //group = selectGroup(getRating());
    date = LocalDate.now();
  }


  public int getRating() {
    return rating;
  }

  public void setRating(int rating, LocalDate date) {
    this.rating = rating;
    this.date = date;
  }

  public LocalDate getDate() {
    return date;
  }

  public LocalDate getInitialDate() {
    return initialDate;
  }


  /**
   * Method that returns the change in rating as a result of data fed.
   *
   * @param win              Whether the player won.
   * @param opponentRating   The opponent.
   * @return                 The change in rating as a result of data fed.
   */
  public abstract int getRatingChange(boolean win, Rating opponentRating);

  public abstract String getType();

  public abstract Player.PlayerGroup getGroup();


}
