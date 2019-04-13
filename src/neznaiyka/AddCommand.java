package neznaiyka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AddCommand extends Command{

    private static long modificationTime;
    public static long getModificationTime(){
        return modificationTime;
    }
    public static void setModificationTime(long newTime){
        modificationTime = newTime;
    }


    /**
     * method of creating a new Human and adding it to the collection
     *
     *
     * @throws IOException
     */
    public void add() throws IOException{

// todo: с пробелами че нить надо сделать и имя если нулл
        System.out.println("Humans paramaters: {name, thinkingType, talent,is he weird or ordinary}");
        String jsonString = JSONreader.getJSON();
        HumanDeque.getHumans().add(JSONreader.getHumanfromJSON(jsonString));

        setModificationTime(System.currentTimeMillis());
//        String info = addHuman(humanInfo);
//        if (info!=null && FileRedactor.readFile(HumanDeque.output)!=null)
//            FileRedactor.addToFile(HumanDeque.output,"\n"+info);
//        if (info!=null && FileRedactor.readFile(HumanDeque.output)==null)
//            FileRedactor.addToFile(HumanDeque.output,info);

    }

    /**
     * if the name of human in the list,sorted by alphabet, at the bottom, human'll be added to the collection
     *
     *
     * @throws IOException
     */

    // todo тут полная хрень убиться можно не по алфавиту и сиаут убери
    public void add_if_last() throws IOException{
        ArrayDeque<Human> humans = HumanDeque.getHumans();

        System.out.println("Humans paramaters: {name, thinkingType, talent,is he weird or ordinary}");
        String jsonString = JSONreader.getJSON();
        Human lastHuman = JSONreader.getHumanfromJSON(jsonString);
        int k=0;
        for(Human hum : humans){
            if (lastHuman.compareTo(hum)>0){
                k++;
            }
        }if (k==humans.size()){
            humans.add(lastHuman);
        }

//        ArrayList<String> humanInfo = JSONreader.getJSON();
//        TreeSet<String> names = new TreeSet<>();
//        for (String str: humanInfo){
//            if (str.contains("name")) {
//                try {
//                    name = str.replace("name-", "");
//                    names.add(name);
//                } catch (ArrayIndexOutOfBoundsException ignored) {}
//            }
//        }
//        for(Human hum : humans){
//            names.add(hum.getName());
//        }
//
//        if (name!=null && names.last().equals(name)) {
//            info = addHuman(humanInfo);
//            setModificationTime(System.currentTimeMillis());
//            if ( FileRedactor.readFile(HumanDeque.output)!=null)
//                FileRedactor.addToFile(HumanDeque.output,"\n"+info);
//            else
//                FileRedactor.addToFile(HumanDeque.output,info);
//        }



    }


//    public static String addHuman(ArrayList<String> humanInfo){
//
//        String name=null;
//
//        int pick1 = new Random().nextInt(ThinkingType.values().length);
//        ThinkingType thinkingType = ThinkingType.values()[pick1];
//
//        int pick2 = new Random().nextInt(Talent.values().length);
//        Talent talent = Talent.values()[pick2];
//
//        String humanType = "ordinary";
//
//        for (String info : humanInfo){
//            if (info.contains("name")){
//                try{
//                    name = info.replace("name-","");
//                }catch (ArrayIndexOutOfBoundsException ignored){}
//
//            }
//
//            if (info.contains("thinkingType")){
//                try{
//                    switch (info.replace("thinkingType-","")){
//                        case "genius":
//                        case "GENIUS":
//                            thinkingType = ThinkingType.GENIUS;
//                            break;
//                        case "clever":
//                        case "CLEVER":
//                            thinkingType = ThinkingType.CLEVER;
//                            break;
//                        case "average":
//                        case "AVERAGE":
//                            thinkingType = ThinkingType.AVERAGE;
//                            break;
//                        case "silly":
//                        case "SIllY":
//                            thinkingType = ThinkingType.SILLY;
//                            break;
//                    }
//                }catch (ArrayIndexOutOfBoundsException ignored){}
//
//            }
//
//            if (info.contains("talent")){
//                try{
//                    switch (info.replace("talent-","").toLowerCase()){
//                        case "painting":
////                        case "PAINTING":
//                            talent = Talent.PAINTING;
//                            break;
//                        case "music":
////                        case "MUSIC":
//                            talent = Talent.MUSIC;
//                            break;
//                        case "cooking":
////                        case "COOKING":
//                            talent = Talent.COOKING;
//                            break;
//                        case "knowlege":
////                        case "KNOWLEGE":
//                            talent = Talent.KNOWLEGE;
//                            break;
//                    }
//                }catch (ArrayIndexOutOfBoundsException ignored){}
//
//            }
//        }
//        for (String info : humanInfo){
//            if(name!=null && info.contains("humanType")){
//                try{
//                    switch (info.replace("humanType-","")){
//                        case "korotyshka":
//                        case "Korotyshka":
//                            HumanDeque.getHumans().add(new Korotyshka(name, thinkingType,talent));
//                            humanType = "korotyshka";
//                            break;
//                        case "malyish":
//                        case "Malyish":
//                            HumanDeque.getHumans().add(new Korotyshka.Malyish(name, thinkingType, talent));
//                            humanType = "malyish";
//                            break;
//                        case "weirdo":
//                        case "Weirdo":
//                            HumanDeque.getHumans().add(new Weirdo(name, thinkingType, talent));
//                            humanType = "weirdo";
//                            break;
//                        default:
//                            HumanDeque.getHumans().add(new Ordinary(name, thinkingType, talent));
//                            humanType = "ordinary";
//                            break;
//                    }
//                }catch (ArrayIndexOutOfBoundsException ignored){}
//            }
//        }
//        if (name!=null){
//            return humanType +";"+ name +";"+ thinkingType +";"+ talent;}
//        else
//            return null;
//
//    }




}
