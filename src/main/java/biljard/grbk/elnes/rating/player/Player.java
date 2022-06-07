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
   * @param firstName       The player's name.
   * @param lastName        The player's last name.
   * @param ratingNumber    The player's rating.
   */
  public Player(String firstName, String lastName, int ratingNumber, int cueScoreID) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.group = selectGroup(ratingNumber);
    this.rating = RatingFactory.createRatingInstance(this.group, ratingNumber);
    this.cueScoreID = cueScoreID;
    ratingHistory = new PlayerRatingHistory(rating, cueScoreID);
    //System.out.println("of type: " );
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
   * This method changes the rating of the player. It also changes the player's group
   * if the changed rating requires that.
   *
   * @param win             Whether the player won the match.
   * @param opponentRating  The rating of the opponent.
   */
  public void changeRating(boolean win, Rating opponentRating){
    int newRatingNumber = rating.getRating() + rating.getRatingChange(win, opponentRating);
    //inputs old rating as an entry in ratingHistory (if-statement might be redundant here, but I'll leave it for now)
    if (newRatingNumber != rating.getRating()) ratingHistory.addHistoryEntry(rating);
    if (selectGroup(newRatingNumber) != getGroup()) {
      setRating(RatingFactory
          .createRatingInstance(selectGroup(newRatingNumber), newRatingNumber));
      setGroup(selectGroup(newRatingNumber));
    } else {
      rating.setRating(newRatingNumber, LocalDate.now());
    }
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

  public int getRatingNumber(){
    return rating.getRating();
  }

  public int getCueScoreID() {
    return cueScoreID;
  }

  public PlayerGroup getGroup() {
    return group;
  }

}
