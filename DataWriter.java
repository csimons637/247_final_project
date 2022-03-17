import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.print.attribute.standard.JobStateReasons;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author csimons637
 */
public class DataWriter extends DataConstants {
    
    public static void saveUsers() {
        Users users = Ussers.getInstance();
        ArrayList<User> userList = users.getAllUsers();
        JSONArray jsonUsres = new JSONArray();

        try (FileWriter file = new FileWriter(USER_FILE)) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();

        return userDetails;
    }

    // Repeat above for flights, hotels, etc.
}
