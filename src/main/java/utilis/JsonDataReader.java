package utilis;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    String filepath = System.getProperty("user.dir")+"/src/test/resources/TestJsonFiles/Login-and-Users-Data.json";

    public int countrycode;
    public int [] role;

    public void JsonReader () throws JSONException, FileNotFoundException, IOException, ParseException {

        JSONParser parser = new JSONParser();

        FileReader filereader = new FileReader(filepath);

        Object obj = parser.parse(filereader);
        JSONObject person = (JSONObject) obj ;

            countrycode = (int) person.get("country_code_id");
            role = (int[]) person.get("roles_ids");
    }

       }