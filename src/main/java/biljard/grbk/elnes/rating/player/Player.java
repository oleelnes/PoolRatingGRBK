package biljard.grbk.elnes.rating.player;

public abstract class Player {
  private String firstName;
  private String lastName;
  private Rating rating;
  private PlayerRatingHistory ratingHistory;
  private Type group;

  public Player(String firstName, String lastName, Rating rating,
                PlayerRatingHistory playerRatingHistory) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.rating = rating;
    this.ratingHistory = playerRatingHistory;
    this.group = selectGroup(rating.getRating());
  }

  public enum Type {
    A,
    B,
    C,
    D,
    E;
  }
  public Type getGroup(){
    return group;
  }

  private Type selectGroup(int ratingNumber){
    if (ratingNumber < 40) return Type.E;
    else if (ratingNumber < 60) return Type.D;
    else if (ratingNumber < 90) return Type.C;
    else if (ratingNumber < 115) return Type.B;
    return Type.A;
  }

  public abstract int getRatingChange(boolean win, Player opponent);

  public int getRating() {
    return rating.getRating();
  }


}
