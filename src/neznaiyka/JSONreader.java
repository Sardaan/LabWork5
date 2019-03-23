package neznaiyka;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class JSONreader {

    public static ArrayList getJSON() throws IOException {
        ArrayList<String> info = new ArrayList<>();
        BufferedReader str = new BufferedReader(new InputStreamReader(System.in));
        String jsonString = str.readLine();
        try {
            Object obj = new JSONParser().parse(jsonString);

            JSONObject jsonObject = (JSONObject) obj;



            String humanType = (String) jsonObject.get("humanType");
            info.add("humanType-"+humanType);

            String name = (String) jsonObject.get("name");
            info.add("name-"+name);

            String thinkingType = (String) jsonObject.get("thinkingType");
            info.add("thinkingType-"+thinkingType);

            String talent = (String) jsonObject.get("talent");
            info.add("talent-"+talent);



        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println("can not read what you write, make sure its written in json format");
        }
        return info;

    }
}