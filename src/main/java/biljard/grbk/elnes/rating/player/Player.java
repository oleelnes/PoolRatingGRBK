package biljard.grbk.elnes.rating.player;

import biljard.grbk.elnes.rating.rating.Rating;
import biljard.grbk.elnes.rating.rating.RatingFactory;

public class Player {
  private String firstName;
  private String lastName;
  private Rating rating;
  private String cuescoreID;
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
    this.group = selectGroup(rating.getRating());
    this.rating = RatingFactory.createRatingInstance(this.group, rating.getRating());
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

  public Rating getRating() {
    return rating;
  }

  public PlayerGroup getGroup() {
    return group;
  }

  public void changeRating(){

  }

}
