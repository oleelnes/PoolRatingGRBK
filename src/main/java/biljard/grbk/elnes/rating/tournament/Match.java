package biljard.grbk.elnes.rating.tournament;

import biljard.grbk.elnes.rating.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Match {
  private Player player1;
  private Player player2;
  private int player1Score;
  private int player2Score;
  private MatchStatus status;

  public Match(Player player1, Player player2, boolean handicap) {
    this.player1 = player1;
    this.player2 = player2;
    this.player1Score = 0;
    this.player2Score = 0;
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

  private void setHandicap(){
   //todo
  }

  private List<Integer> getScore(){
    List<Integer> scores = new ArrayList<>();
    scores.add(player1Score);
    scores.add(player2Score);
    return scores;
  }

  public void endMatch(Player winner) {

  }

}
