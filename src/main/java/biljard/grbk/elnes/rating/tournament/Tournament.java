package biljard.grbk.elnes.rating.tournament;

import biljard.grbk.elnes.rating.handlers.CueScoreHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class Tournament {
  private JSONArray tournamentMatches;
  private Object tournamentInformation;
  private List<String> playerNames;


  public Tournament(String tournamentID) {
    this.tournamentInformation = CueScoreHandler.getTournamentInformation("16323817");
    if(tournamentInformation != null) {
      this.tournamentMatches = CueScoreHandler.getMatches(tournamentInformation);
      this.playerNames = CueScoreHandler.getPlayers(tournamentMatches);
      System.out.println(playerNames);
    } else{
      System.err.println("woopsies!");
    }

  }
}
