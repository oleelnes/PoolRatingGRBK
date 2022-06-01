package biljard.grbk.elnes.rating.rating;

import biljard.grbk.elnes.rating.player.Player;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerRatingHistory {
  private int cueScoreID;
  private List<Rating> ratingHistory;

  public PlayerRatingHistory(Rating rating, int cueScoreID) {
    ratingHistory = new ArrayList<>();
    this.cueScoreID = cueScoreID;
    addHistoryEntry(rating);
  }

  public void addHistoryEntry(Rating rating){
    ratingHistory.add(rating);
  }

  public List<Rating> getRatingHistory(){
    return ratingHistory;
  }

  public int getCueScoreID(){
    return cueScoreID;
  }

}
