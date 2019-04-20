package neznaiyka;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class JSONreader {

    /**
     * convert JSONObject to Human
     *
     * @param jsonString
     * @return Human
     * @throws IOException
     */

    public static Human getHumanfromJSON(String jsonString) throws IOException {

        Human h = null;

                    // На случай если не прописаны в json все данные из конструктора
        int pick1 = new Random().nextInt(ThinkingType.values().length);
        ThinkingType thinkingType = ThinkingType.values()[pick1];

        int pick2 = new Random().nextInt(Talent.values().length);
        Talent talent = Talent.values()[pick2];

        int pick3 = new Random().nextInt(WritingType.values().length);
        WritingType writingType = WritingType.values()[pick3];

        int pick4 = new Random().nextInt(ReadingType.values().length);
        ReadingType readingType = ReadingType.values()[pick4];

        Boolean likeToWork = Math.random() < 0.5;


                // Создаем human из json объетка
        try {
            Object obj = new JSONParser().parse(jsonString);
            JSONObject jsonObject = (JSONObject) obj;

            if (jsonObject.get("name") != null) {

                String name = ((String) jsonObject.get("name")).replaceAll("\t","").replaceAll(" ","");

                if (jsonObject.get("thinkingType")!=null)
                    thinkingType = (ThinkingType) jsonObject.get("thinkingType");

                if (jsonObject.get("talent")!=null)
                    talent = (Talent) jsonObject.get("talent");

                if (jsonObject.get("writingType")!=null)
                    writingType = (WritingType) jsonObject.get("writingType");

                if (jsonObject.get("readingType")!=null)
                    readingType = (ReadingType) jsonObject.get("readingType");

                if (jsonObject.get("likeToWork")!=null)
                    likeToWork = (Boolean) jsonObject.get("likeToWork");

                h = new Human(name, thinkingType, talent, writingType, readingType, likeToWork);

            }


        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println("Can not read what you write, make sure it's written in json format");
        }

    return h;
    }

    /**
     * Reads json from console
     *
     * @return jsonString
     */
    public static String getJSON(){

        Scanner scan = new Scanner(System.in);
        String jsonString = scan.nextLine();


        while (!jsonString.contains("}")){

            jsonString = jsonString + scan.nextLine();

        }

        return jsonString;
    }

}