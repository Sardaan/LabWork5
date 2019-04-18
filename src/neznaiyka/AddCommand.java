package neznaiyka;

import java.io.IOException;
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
        System.out.println("Humans parameters: {name, thinkingType, talent, writingType, readingType, likeToWork");
        String jsonString = JSONreader.getJSON();
        Human human = JSONreader.getHumanfromJSON(jsonString);
        if (human!=null) {
            HumanDeque.getHumans().add(human);
            System.out.println("Human is added");
            setModificationTime(System.currentTimeMillis());
        }else{
            System.out.println("nothing added in collection");
        }

    }

    /**
     * if the name of human in the list,sorted by alphabet, at the bottom, human'll be added to the collection
     *
     *
     * @throws IOException
     */
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
            System.out.println("Human is added");
            setModificationTime(System.currentTimeMillis());
        }
    }



}
