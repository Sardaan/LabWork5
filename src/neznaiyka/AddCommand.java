package neznaiyka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

public class AddCommand extends Command{


    /**
     * method of adding already created human to the collection
     *
     * @throws IOException
     */
    public static void add_from_list() throws IOException {
        System.out.println("Write human from list");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String human = br.readLine();
        if (HumanDeque.getAvailableHumans().contains(human)){
            addHuman(human);
            HumanDeque.setAvailableHumans(HumanDeque.getAvailableHumans().replace(human, "").replace(";;",";").replaceAll("^;|;$",""));
            FileRedactor.writeInFile(HumanDeque.getAvailableHumans(),FileRedactor.readFile(HumanDeque.getAvailableHumansFile()));
        }else
            System.out.println("I don't know this human");
    }

    /**
     * method of creating a new Human and adding it to the collection
     *
     * @param humans - collection where we add new element
     * @throws IOException
     */
    public static void add(ArrayDeque<Human> humans) throws IOException{

        System.out.println("Humans paramaters: {name, thinkingType, talent,is he weird or ordinary}");
        //TODO key-value
        ArrayList<String> humanInfo = JSONreader.getJSON();

        String info = addToDeque(humanInfo);
        if ( FileRedactor.readFile(HumanDeque.getOutput())!=null)
            FileRedactor.addToFile(HumanDeque.getOutput(),"\n"+info);
        else
            FileRedactor.addToFile(HumanDeque.getOutput(),info);


    }
    public static ArrayDeque<Human> addHuman(String input) {

        String information="";
        for (String human : input.split(";")){

            switch (human){
                case "Pilulkin":
                    HumanDeque.getHumans().add(new Ordinary("Pilulkin",ThinkingType.GENIUS, Talent.MEDICINE));
                    information = "ordinary;Pilulkin;genius;medecine";
                    break;
                case "Tubic":
                    HumanDeque.getHumans().add(new Ordinary("Tubic", ThinkingType.SILLY, Talent.PAINTING));
                    information = "ordinary;Tubic;silly;painting";
                    break;
                case "Guslya":
                    HumanDeque.getHumans().add(new Ordinary("Guslya", ThinkingType.CLEVER, Talent.MUSIC));
                    information = "ordinary;Guslya;clever;music";
                    break;
                case "Ponchik":
                    HumanDeque.getHumans().add(new Ordinary("Ponchik", ThinkingType.AVERAGE, Talent.COOKING));
                    information = "ordinary;Ponchik;average;cooking";
                    break;
                case "Lenny":
                    HumanDeque.getHumans().add(new Korotyshka.Malyish("Lenny", ThinkingType.AVERAGE));
                    information = "malyish;Lenny;average;nope";
                    break;
                case "Znaika":
                    HumanDeque.getHumans().add(new Ordinary("Znaika", ThinkingType.GENIUS, Talent.KNOWLEGE));
                    information = "ordinary;Znaika;genius;knowlege";
                    break;
                case "Steclyashkin":
                    HumanDeque.getHumans().add(new Ordinary("Steclyashkin", ThinkingType.AVERAGE, Talent.HOSPITALITY));
                    information = "ordinary;Steclyashkin;average;hospitality";
                    break;
                case "Ern":
                    HumanDeque.getHumans().add(new Korotyshka("Ern", ThinkingType.KOROTYSHKA));
                    information = "korotyshka;Ern;korotyshka;nope";
                    break;
                default:
                    System.out.println("   блять опять че то не так!");
                    break;
            }
        }
        if ( FileRedactor.readFile(HumanDeque.getOutput())!=null)
            FileRedactor.addToFile(HumanDeque.getOutput(),"\n"+information);
        else
            FileRedactor.addToFile(HumanDeque.getOutput(),information);
        return HumanDeque.getHumans();
    }

    public static String addToDeque(ArrayList<String> humanInfo){


        int pick = new Random().nextInt(ThinkingType.values().length);
        ThinkingType thinkingType = ThinkingType.values()[pick];
        Talent talent = Talent.NOPE;;
        String name=null;
        String humanType = null;

        for (String info : humanInfo){
            if (info.contains("name")){
                try{
                    name = info.replace("name-","");
                }catch (ArrayIndexOutOfBoundsException ignored){}

            }

            if (info.contains("thinkingType")){
                try{
                    switch (info.replace("thinkingType-","")){
                        case "genius":
                        case "GENIUS":
                            thinkingType = ThinkingType.GENIUS;
                            break;
                        case "korotyshka":
                        case "KOROTYSHKA":
                            thinkingType = ThinkingType.KOROTYSHKA;
                            break;
                        case "clever":
                        case "CLEVER":
                            thinkingType = ThinkingType.CLEVER;
                            break;
                        case "average":
                        case "AVERAGE":
                            thinkingType = ThinkingType.AVERAGE;
                            break;
                        case "silly":
                        case "SIllY":
                            thinkingType = ThinkingType.SILLY;
                            break;
                    }
                }catch (ArrayIndexOutOfBoundsException ignored){}

            }

            if (info.contains("talent")){
                try{
                    switch (info.replace("talent-","")){
                        case "painting":
                        case "PAINTING":
                            talent = Talent.PAINTING;
                            break;
                        case "music":
                        case "MUSIC":
                            talent = Talent.MUSIC;
                            break;
                        case "cooking":
                        case "COOKING":
                            talent = Talent.COOKING;
                            break;
                        case "knowlege":
                        case "KNOWLEGE":
                            talent = Talent.KNOWLEGE;
                            break;
                    }
                }catch (ArrayIndexOutOfBoundsException ignored){}

            }
        }
        for (String info : humanInfo){
            if(info.contains("humanType")){
                try{
                    switch (info.replace("humanType-","")){
                        case "weirdo":
                        case "Weirdo":
                            HumanDeque.getHumans().add(new Weirdo(name, thinkingType, talent));
                            humanType = "weirdo";
                            break;
                        default:
                            HumanDeque.getHumans().add(new Ordinary(name, thinkingType, talent));
                            humanType = "ordinary";
                            break;
                    }
                }catch (ArrayIndexOutOfBoundsException ignored){}
            }
        }return humanType +";"+ name +";"+ thinkingType +";"+ talent;

    }



}
