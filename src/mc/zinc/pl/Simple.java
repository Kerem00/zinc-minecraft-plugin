package mc.zinc.pl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Simple
{
    public static void createNew(String name)
    {
        JSONObject db = new JSONObject();
        try
        {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("plugins/Zinc/users.json");
            db = (JSONObject) parser.parse(reader);
            reader.close();
        }
        catch (IOException | ParseException e) { System.out.println("[Warning] users.json not found."); }

        JSONObject info = new JSONObject();
        info.put("chatcolor", "default");
        info.put("is_vip", false);

        db.put(name, info);

        try
        {
            FileWriter writer = new FileWriter("plugins/Zinc/users.json");
            writer.write(db.toJSONString());
            writer.close();
        }
        catch (IOException e) { System.out.println("[Warning] can't write to users.json."); }
    }

    public static boolean is_vip(String name)
    {
        JSONObject db = new JSONObject();
        try
        {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("plugins/Zinc/users.json");
            db = (JSONObject) parser.parse(reader);
            reader.close();
        }
        catch (IOException | ParseException e) { System.out.println("[Warning] users.json not found."); }

        return (boolean) ((JSONObject) db.get(name)).get("is_vip");
    }
}
