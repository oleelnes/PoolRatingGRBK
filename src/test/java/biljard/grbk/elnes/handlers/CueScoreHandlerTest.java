package biljard.grbk.elnes.handlers;

import biljard.grbk.elnes.rating.handlers.CueScoreHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CueScoreHandlerTest {


  @Test
  public void test(){
    CueScoreHandler.getTournamentInformation("16323817");
    List<String> names = CueScoreHandler.getPlayers(CueScoreHandler
        .getMatches(CueScoreHandler.getTournamentInformation("16359658")));
    for (int i = 0; i < names.size(); i++) {
      System.out.println(names.get(i));
    }
  }
}
