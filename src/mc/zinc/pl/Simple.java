package mc.zinc.pl;

import org.bukkit.ChatColor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Simple
{
    private static JSONObject get_db()
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
        return db;
    }

    private static void set_db(JSONObject db)
    {
        try
        {
            FileWriter writer = new FileWriter("plugins/Zinc/users.json");
            writer.write(db.toJSONString());
            writer.close();
        }
        catch (IOException e) { System.out.println("[Warning] Can't write to users.json."); }
    }

    public static void createNew(String name)
    {
        JSONObject db = get_db();

        JSONObject info = new JSONObject();
        info.put("chatcolor", "default");
        info.put("is_vip", false);

        db.put(name, info);

        set_db(db);
    }

    public static boolean is_vip(String name)
    {
        JSONObject db = get_db();

        return (boolean) ((JSONObject) db.get(name)).get("is_vip");
    }

    public static void set_vip(String name, boolean val)
    {
        JSONObject db = get_db();

        ((JSONObject) db.get(name)).replace("is_vip", val);

        set_db(db);
    }

    public static ChatColor get_cc(String name)
    {
        JSONObject db = get_db();

	// todo: switch statement
        if (((JSONObject) db.get(name)).get("chatcolor").equals("red"))
            return ChatColor.RED;
        else if (((JSONObject) db.get(name)).get("chatcolor").equals("gold"))
            return ChatColor.GOLD;
        else if (((JSONObject) db.get(name)).get("chatcolor").equals("aqua"))
            return ChatColor.AQUA;
        else
            return ChatColor.GRAY;
    }

    public static void set_cc(String name, String color)
    {
        JSONObject db = get_db();

        ((JSONObject) db.get(name)).replace("chatcolor", color);

        set_db(db);
    }
}
