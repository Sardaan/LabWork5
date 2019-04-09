package neznaiyka;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class JSONreader {

    public static ArrayList getJSON() throws IOException {
        int i=0;
        ArrayList<String> info = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String jsonString = scan.nextLine();
        while (!jsonString.contains("}")){

            jsonString = jsonString + scan.nextLine();
        }



        try {
            Object obj = new JSONParser().parse(jsonString);
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject.get("name"));
            if(jsonObject.get("name")!=null) {

                String humanType = (String) jsonObject.get("humanType");
                if (humanType!=null)
                info.add("humanType-" + humanType.replaceAll("[\\s]+", ""));

                String name = (String) jsonObject.get("name");
                info.add("name-" + name.replaceAll("[\\s]+", ""));

                String thinkingType = (String) jsonObject.get("thinkingType");
                if (thinkingType!=null)
                info.add("thinkingType-" + thinkingType.replaceAll("[\\s]+", ""));

                String talent = (String) jsonObject.get("talent");
                if (talent!=null)
                info.add("talent-" + talent.replaceAll("[\\s]+", ""));
            }


            } catch (ParseException e) {
                //e.printStackTrace();
                System.out.println("can not read what you write, make sure its written in json format");
            }



        return info;

    }
}