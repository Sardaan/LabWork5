package se.ifmo.s264424;

import se.ifmo.s264424.commands.Command;
import se.ifmo.s264424.enums.ReadingType;
import se.ifmo.s264424.enums.Talent;
import se.ifmo.s264424.enums.WritingType;
import se.ifmo.s264424.enums.ThinkingType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.NoSuchElementException;
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

    public static Human getHumanFromJSON(String jsonString) {

        Human h = null;
        ThinkingType thinkingType =null;
        Talent talent = null;
        WritingType writingType =null;
        ReadingType readingType = null;
        boolean likeToWork = Math.random() < 0.5;


                // Создаем human из json объетка
        try {
            Object obj = new JSONParser().parse(jsonString);
            JSONObject jsonObject = (JSONObject) obj;

            if (jsonObject.get("name") != null && !jsonObject.get("name").toString().trim().equals("") ) {

                String name = ((String) jsonObject.get("name")).trim();
                if (!name.contains(",")){
                    if (jsonObject.get("thinkingType")!=null)
                        thinkingType = ThinkingType.getType(jsonObject.get("thinkingType").toString());

                    if (jsonObject.get("talent") != null)
                        talent = Talent.getTalent( jsonObject.get("talent").toString());

                    if (jsonObject.get("writingType") != null)
                        writingType = WritingType.getType(jsonObject.get("writingType").toString());

                    if (jsonObject.get("readingType") != null)
                        readingType = ReadingType.getType(jsonObject.get("readingType").toString());

                    if (jsonObject.get("likeToWork")!=null){
                        if (jsonObject.get("likeToWork").toString().equals("false"))
                            likeToWork = false;
                        if (jsonObject.get("likeToWork").toString().equals("true"))
                            likeToWork = true;
                    }

                            // На случай если не прописаны в json все данные из конструктора либо прописаны неверно
                    if (thinkingType==null){
                        int pick1 = new Random().nextInt(ThinkingType.values().length);
                        thinkingType = ThinkingType.values()[pick1];
                    }
                    if (talent==null) {
                        int pick2 = new Random().nextInt(Talent.values().length);
                        talent = Talent.values()[pick2];
                    }
                    if (writingType==null){
                        int pick3 = new Random().nextInt(WritingType.values().length);
                        writingType = WritingType.values()[pick3];
                    }
                    if (readingType==null){
                        int pick4 = new Random().nextInt(ReadingType.values().length);
                        readingType = ReadingType.values()[pick4];
                    }


                    h = new Human(name, thinkingType, talent, writingType, readingType, likeToWork);
                }else
                    System.out.println("name can't contain comma");
            }
        }catch (ParseException e) {
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
        try {
            String jsonString = scan.nextLine();

            while (!jsonString.contains("}")) {

                jsonString = jsonString + scan.nextLine();
            }return jsonString;
        }catch (NoSuchElementException n){
            System.out.println("   ok!");
            System.out.println("write command");
            Command com = new Command();
            com.readCommand();

        }

        return null;
    }
}