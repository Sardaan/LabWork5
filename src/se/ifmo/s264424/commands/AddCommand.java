package se.ifmo.s264424.commands;

import se.ifmo.s264424.Human;
import se.ifmo.s264424.HumanDeque;
import se.ifmo.s264424.JSONreader;

import java.util.*;

public class AddCommand extends Command {

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
     */
    public void add(){
        System.out.println("Humans parameters: {name, thinkingType, talent, writingType, readingType, likeToWork}");
        String jsonString = JSONreader.getJSON();
        Human human = JSONreader.getHumanFromJSON(jsonString);
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
     */
    public void add_if_last(){
        ArrayDeque<Human> humans = HumanDeque.getHumans();
        System.out.println("Humans parameters: {name, thinkingType, talent, writingType, readingType, likeToWork}");
        String jsonString = JSONreader.getJSON();
        Human lastHuman = JSONreader.getHumanFromJSON(jsonString);

        int k=0;
        for(Human hum : humans){
            if (lastHuman.compareTo(hum)>0){
                k++;
            }
        }if (k==humans.size()){
            humans.add(lastHuman);
            System.out.println("Human is added");
            setModificationTime(System.currentTimeMillis());
        }else
            System.out.println("nothing added in collection");
    }

    /**
     * if the name of human in the list,sorted by alphabet, at the top, human'll be added to the collection
     *
     *
     */
    public void add_if_first(){
        ArrayDeque<Human> humans = HumanDeque.getHumans();
        System.out.println("Humans parameters: {name, thinkingType, talent, writingType, readingType, likeToWork}");
        String jsonString = JSONreader.getJSON();
        Human firstHuman = JSONreader.getHumanFromJSON(jsonString);

        int k=0;
        for(Human hum : humans){
            if (firstHuman.compareTo(hum)<0){
                k++;
            }
        }if (k==humans.size()){
            humans.add(firstHuman);
            setModificationTime(System.currentTimeMillis());
            System.out.println("Human is added");

        }else
            System.out.println("nothing added in collection");
    }




}
