package neznaiyka;

import java.util.ArrayDeque;
import java.util.Map;



public class HumanDeque /*implements Comparable<Human>*/{

    private static ArrayDeque<Human> humans = new ArrayDeque<>();
    public static ArrayDeque<Human> getHumans(){
        return humans;
    }


    public static String getAvailableHumans() {
        return FileRedactor.readFile("AvailableHumans.csv");
    }
    public static void setAvailableHumans(String newList){
        FileRedactor.writeInFile("AvailableHumans.csv", newList);
    }
    private static String availableHumansFile = "AvailableHumans.csv";
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


//    @Override
//    public int compareTo(Human human){
//        int isLast = 0;
//        for (Human hum: HumanDeque.getHumans()) {
//            if (hum.getName().compareTo(human.getName())>0){
//                isLast++;
//
//            }
//        }return HumanDeque.getHumans().size() - isLast;
//    }


}

