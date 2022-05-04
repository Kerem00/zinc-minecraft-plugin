//   This file is part of Zinc.

//   This program is free software: you can redistribute it and/or modify
//   it under the terms of the GNU General Public License as published by
//   the Free Software Foundation, either version 3 of the License, or
//   (at your option) any later version.

//   This program is distributed in the hope that it will be useful,
//   but WITHOUT ANY WARRANTY; without even the implied warranty of
//   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//   GNU General Public License for more details.

//   You should have received a copy of the GNU General Public License
//   along with this program.  If not, see <https://www.gnu.org/licenses/>.

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

        return switch ((String) ((JSONObject) db.get(name)).get("chatcolor"))
        {
            case "red" -> ChatColor.RED;
            case "gold" -> ChatColor.GOLD;
            case "aqua" -> ChatColor.AQUA;
            default -> ChatColor.GRAY;
        };
    }

    public static void set_cc(String name, String color)
    {
        JSONObject db = get_db();

        ((JSONObject) db.get(name)).replace("chatcolor", color);

        set_db(db);
    }
}
