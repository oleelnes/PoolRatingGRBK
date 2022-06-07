package biljard.grbk.elnes.rating.tournament;

import biljard.grbk.elnes.rating.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 */
public class Match {
  private Player player1;
  private Player player2;
  private int player1Score;
  private int player2Score;
  private int distance;
  private MatchStatus status;

  public Match(Player player1, Player player2, int distance, boolean handicap) {
    this.player1 = player1;
    this.player2 = player2;
    this.player1Score = 0;
    this.player2Score = 0;
    this.distance = distance;
    if (player1 == null || player2 == null) this.status = MatchStatus.NOT_READY;
    else {
      this.status = MatchStatus.READY;
      if (handicap) setHandicap();
    }
  }

  enum MatchStatus {
    NOT_READY,
    READY,
    ONGOING,
    FINISHED
  }

  public void endMatch(Player winner) {

  }

  public void updateMatch(int player1Score, int player2Score, boolean autoEnd) {
    this.player1Score = player1Score;
    this.player2Score = player1Score;
    if (autoEnd) {
      if (player1Score >= distance) endMatch(player1);
      else if (player2Score >= distance) endMatch(player2);
    }
  }

  private void setHandicap(){
   //todo: need a method somewhere that figures out what the handicap should be!
    // ---> probably in rating classes.
  }

  public List<Integer> getScore(){
    List<Integer> scores = new ArrayList<>();
    scores.add(player1Score);
    scores.add(player2Score);
    return scores;
  }

  public int getDistance(){
    return distance;
  }

}
