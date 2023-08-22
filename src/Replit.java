import java.util.*;
import org.json.*;

// Input document: ""
// Starting cursor position: 0
// Operation: {"op": "insert", "chars": "Hello, human!"}
// Output document: "Hello, human!"
// Ending cursor position: 13

// Input document: "What is up?"
// Starting cursor position: 7
// Operation: {"op": "delete", "count": 3}
// Output document: "What is?"
// Ending cursor position: 7
// Watch out: delete operations are applied forward while keeping the cursor in place. Crazy, we know.

// Input document: "Nice!"
// Starting cursor position: 0
// Operation (1): {"op": "skip", "count": 4}
// Operation (2): {"op": "insert", "chars": " day"}
// Output document: "Nice day!"
// Ending cursor position: 8
// As you can see, this last example applies two transformations in a row.

//function isValid(stale, latest, otjson) {
//  // this is the part you will write!
//}
//
//isValid(
//  'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
//  'Repl.it uses operational transformations.',
//  '[{"op": "skip", "count": 40}, {"op": "delete", "count": 47}]'
//); // true
//
//isValid(
//  'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
//  'Repl.it uses operational transformations.',
//  '[{"op": "skip", "count": 45}, {"op": "delete", "count": 47}]'
//); // false, delete past end
//
//isValid(
//  'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
//  'Repl.it uses operational transformations.',
//  '[{"op": "skip", "count": 40}, {"op": "delete", "count": 47}, {"op": "skip", "count": 2}]'
//); // false, skip past end
//
//isValid(
//  'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
//  'We use operational transformations to keep everyone in a multiplayer repl in sync.',
//  '[{"op": "delete", "count": 7}, {"op": "insert", "chars": "We"}, {"op": "skip", "count": 4}, {"op": "delete", "count": 1}]'
//); // true
//
//isValid(
//  'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
//  'We can use operational transformations to keep everyone in a multiplayer repl in sync.',
//  '[{"op": "delete", "count": 7}, {"op": "insert", "chars": "We"}, {"op": "skip", "count": 4}, {"op": "delete", "count": 1}]'
//); // false
//
//isValid(
//  'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
//  'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
//  '[]'
//); // true

public class Replit {
    public static void main(String[] args) {
        String stale = "Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.";
        String latest = "Repl.it uses operational transformations.";

        // some mock inputs
        JSONArray otjson = new JSONArray();
        JSONObject joInsert = new JSONObject();
        JSONObject joDelete = new JSONObject();
        JSONObject joSkip = new JSONObject();

        // {"op": "skip", "count": 40}
        joSkip.put("op", "skip");
        joSkip.put("count", 45);

        // {"op": "insert", "chars": " day"}
        joInsert.put("op", "insert");
        joInsert.put("chars", "day");

        // {"op": "delete", "count": 47}
        joDelete.put("op", "delete");
        joDelete.put("count", 47);


        // Scenario 1:
        // 'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
        //  'Repl.it uses operational transformations.',
        //  '[{"op": "skip", "count": 40}, {"op": "delete", "count": 47}]'
        //  return true
        otjson.put(joSkip);
        otjson.put(joDelete);
        // System.out.println("check input json object:" + otjson);

        // Scenario 2:
        // 'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
        //  'Repl.it uses operational transformations.',
        //  '[{"op": "skip", "count": 45}, {"op": "delete", "count": 47}]'
        //  return false, delete past end
        otjson.put(joSkip);
        otjson.put(joDelete);
        // System.out.println("check input json object:" + otjson);

        System.out.println(isValid(stale, latest, otjson));
    }

//    String stale, String latest, JSObject otjson
    public static String isValid(String stale, String latest, JSONArray otjson) {
        // go through otjson
        int length = otjson.length();
        int startIndex = 0;
        String tempString = stale;

        for(int i = 0; i < length; i ++) {
            if(otjson.getJSONObject(i).getString("op").equals("skip")) {
                int skipCount = otjson.getJSONObject(i).getInt("count");
                startIndex = skip(tempString, startIndex, skipCount);

                if(startIndex == -1) {
                    return "false, skip past end";
                }
            } else if(otjson.getJSONObject(i).getString("op").equals("insert")) {
                String insertContent = otjson.getJSONObject(i).getString("chars");
                tempString = insert(tempString, startIndex, insertContent);

                startIndex = tempString.length() - 1;
            } else if(otjson.getJSONObject(i).getString("op").equals("delete")) {
                int deleteCount = otjson.getJSONObject(i).getInt("count");
                tempString = delete(tempString, startIndex, deleteCount);

                if( tempString == null) {
                    return "false, delete past end";
                }

                startIndex = tempString.length() - 1;
            }
        }

        if(!tempString.equals(latest)) {
            return "false";
        }

        return "true";
    }

    // insert text function
    public static String insert(String stale, int insertIndex, String insertContent) {
        if(insertIndex > stale.length()) {
            return stale + insertContent;
        }

        return stale.substring(0, insertIndex) + insertContent + stale.substring(insertIndex);
    }

    // delete text function
    public static String delete(String stale, int startIndex, int deleteCount) {
        if(startIndex > stale.length() || (startIndex + deleteCount > stale.length())) {
            return null;
        }

        return stale.substring(0, startIndex) + stale.substring(startIndex + deleteCount);
    }

    // skip function: move cursor to a new position
    // return cursor current position, or return null
    public static int skip(String stale, int startIndex, int skipCount) {
        if(startIndex > stale.length() || skipCount > stale.length() || (startIndex + skipCount > stale.length())) {
            return -1;
        }

        return startIndex + skipCount;
    }
}



