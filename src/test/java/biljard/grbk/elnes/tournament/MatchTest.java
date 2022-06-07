package biljard.grbk.elnes.tournament;

import biljard.grbk.elnes.rating.player.Player;
import biljard.grbk.elnes.rating.tournament.Match;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {
  Match match;
  Player player1;
  Player player2;

  @BeforeEach
  public void beforeEach(){
    player1 = new Player("Ole", "Elnæs", 100, 121212);
    player2 = new Player("Arne", "Bjarne", 77, 121008);
    match = new Match(player1, player2, 7, false);
  }

  @Test
  public void getScoreTest(){
    System.out.println(match.getScore());
  }




}
