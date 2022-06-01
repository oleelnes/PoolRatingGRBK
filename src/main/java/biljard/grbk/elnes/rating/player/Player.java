package biljard.grbk.elnes.rating.player;

import biljard.grbk.elnes.rating.rating.PlayerRatingHistory;
import biljard.grbk.elnes.rating.rating.Rating;
import biljard.grbk.elnes.rating.rating.RatingFactory;

import java.time.LocalDate;

public class Player {
  private String firstName;
  private String lastName;
  private Rating rating;
  private int cueScoreID;
  private PlayerGroup group;
  private PlayerRatingHistory ratingHistory;

  /**
   * Constructor for the class Player.
   *
   * @param firstName The player's name.
   * @param lastName  The player's last name.
   * @param rating    The player's rating.
   */
  public Player(String firstName, String lastName, Rating rating, int cueScoreID) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.group = selectGroup(rating.getRating());
    this.rating = RatingFactory.createRatingInstance(this.group, rating.getRating());
    this.cueScoreID = cueScoreID;
    ratingHistory = new PlayerRatingHistory(rating, cueScoreID);
    System.out.println("of type: " );
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

  private void setRating(Rating rating) {
    this.rating = rating;
  }

  private void setGroup(PlayerGroup group) {
    this.group = group;
  }

  public Rating getRating() {
    return rating;
  }

  public PlayerGroup getGroup() {
    return group;
  }

  public void changeRating(boolean win, Rating opponentRating){
    int newRatingNumber = rating.getRating() + rating.getRatingChange(win, opponentRating);
    if (selectGroup(newRatingNumber) != getGroup()) {
      setRating(RatingFactory
              .createRatingInstance(selectGroup(newRatingNumber), newRatingNumber));
      setGroup(selectGroup(newRatingNumber));
    } else {
      rating.setRating(newRatingNumber, LocalDate.now());
    }
    ratingHistory.addHistoryEntry(rating);
  }

}
