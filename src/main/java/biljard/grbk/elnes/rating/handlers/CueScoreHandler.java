package biljard.grbk.elnes.rating.handlers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class CueScoreHandler {

  public static Object getTournamentInformation(String id) {
    //TODO: return JSONObject.
    JSONParser jsonParser = new JSONParser();
    try {
      URL url = new URL("https://api.cuescore.com/tournament/?id=" + id);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setRequestMethod("GET");
      conn.connect();
      StringBuilder stringBuilder = new StringBuilder();
      if(conn.getResponseCode() == 200) {
        Scanner scan = new Scanner(url.openStream());
        while(scan.hasNext()) {
          stringBuilder.append(scan.next());
        }
        Object obj = jsonParser.parse(stringBuilder.toString());
        //System.out.println(obj);
        //JSONArray array = new JSONArray();
        //array.add(obj);
        //System.out.println(array);

        printMatches(obj);
        return obj;

      }
    } catch(ParseException | IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static void printMatches(Object tournament) {
    JSONObject tournamentJSON = (JSONObject) tournament;
    JSONArray array = new JSONArray();
    array.addAll((Collection) tournamentJSON.get("matches"));
    for(int i = 0; i < array.size(); i++) {
      JSONObject match = (JSONObject)array.get(i);
      JSONObject playerA = (JSONObject)match.get("playerA");
      JSONObject playerB = (JSONObject)match.get("playerB");
      System.out.println("Match number " + match.get("matchno") + "\n" + match.get("roundName") + "\n" + "Status: "
          + match.get("matchstatus") + "\n" + playerA.get("name") + "\n" + match.get("scoreA")
          + "\n" + match.get("scoreB") + "\n" + playerB.get("name") + "\n");
    }
  }

  public static JSONArray getMatches(Object tournament){
    JSONObject tournamentJSON = (JSONObject) tournament;
    JSONArray array = new JSONArray();
    array.addAll((Collection) tournamentJSON.get("matches"));
    return array;
  }

  public static List<String> getPlayers(JSONArray matches) {
    List<String> players = new ArrayList<>();
    List<Integer> playerIDs = new ArrayList<>();
    for(int i = 0; i < matches.size(); i++) {
      JSONObject match = (JSONObject) matches.get(i);
      JSONObject playerA = (JSONObject) match.get("playerA");
      Object playerAIdObj = playerA.get("playerId");
      int playerAId = Integer.parseInt(playerAIdObj.toString());
      boolean found = false;
      if(playerAId != 1000615) {
        for (int j = 0; j < playerIDs.size(); j++) {
          if (playerAId == playerIDs.get(j)) {
            found = true;
          }
        }
        if (!found) {
          playerIDs.add(playerAId);
          players.add((String)playerA.get("name"));
        }
      }

      JSONObject playerB = (JSONObject) match.get("playerB");
      Object playerBIdObj = playerB.get("playerId");
      int playerBId = Integer.parseInt(playerBIdObj.toString());
      found = false;
      if(playerBId != 1000615) {
        for (int j = 0; j < playerIDs.size(); j++) {
          if (playerAId == playerIDs.get(j)) {
            found = true;
          }
        }
        if (!found) {
          playerIDs.add(playerAId);
          players.add((String)playerA.get("name"));
        }
      }
    }


    return players;
  }

}
