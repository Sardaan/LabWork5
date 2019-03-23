package neznaiyka;

import java.util.ArrayDeque;
import java.util.Map;



public class HumanDeque {

    private static ArrayDeque<Human> humans = new ArrayDeque<>();
    public static ArrayDeque<Human> getHumans(){
        return humans;
    }


    private static String availableHumans = FileRedactor.readFile("AvailableHumans.csv");
    private static String availableHumansFile = "AvailableHumans.csv";
    public static String getAvailableHumans(){
        return availableHumans;
    }public static void setAvailableHumans(String newList){
        availableHumans=newList;
    }

    public static String getAvailableHumansFile() {
        return availableHumansFile;
    }

    private static String input = "Humans.csv";
    public static String getInput() {
        return input;
    }

    private static Map<String, String> envMap = System.getenv();
    private static String output = envMap.get("OUTPATH");


    public static String getOutput() {
        return output; }









}

