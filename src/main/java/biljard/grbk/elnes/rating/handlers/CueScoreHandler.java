package biljard.grbk.elnes.rating.handlers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class CueScoreHandler {

  public static void getTournamentInformation() {
    //TODO: return JSONObject.
    JSONParser jsonParser = new JSONParser();
    try {
      URL url = new URL("https://api.cuescore.com/tournament/?id=16094986");
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
        System.out.println(obj);
        JSONArray array = new JSONArray();
        array.add(obj);
        System.out.println(array);


        //tournamentArray.forEach(emp -> parse);
        //System.out.println(tournamentArray);
        parseTournament(obj);

      }
    } catch(java.net.MalformedURLException malformedURLException) {
      System.err.println("yuick");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }

  }

  private static void parseTournament(Object tournament) {
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

    //System.out.println(matchesObject);
    //matchesObject.forEach(match -> System.out.println(matchesObject.get("playerA\n"
        //+ matchesObject.get("scoreA\n") + matchesObject.get("scoreB\n") + matchesObject.get("playerB")) ));
    /*for(Iterator iterator = matchesObject.keySet().iterator(); iterator.hasNext();) {
      System.out.println(matchesObject.get("playerA\n"
          + matchesObject.get("scoreA\n") + matchesObject.get("scoreB\n") + matchesObject.get("playerB")));
      iterator.next();
    }*/
  }

}
