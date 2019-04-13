package neznaiyka;

import java.util.ArrayDeque;
import java.util.Map;
import java.io.*;



public class HumanDeque{

    private static ArrayDeque<Human> humans = new ArrayDeque<>();
    public static ArrayDeque<Human> getHumans(){
        return humans;
    }


    public final static File input = new File("Humans.csv");
    private static Map<String, String> envMap = System.getenv();
    public final static File output = new File(envMap.get("OUTPATH"));


    // Все придется поменять

//    private static String input = "Humans.csv";
//    public static String getInput() {
//        return input;
//    }

//    private static Map<String, String> envMap = System.getenv();
//    private static String output = envMap.get("OUTPATH");
//
//
//    public static String getOutput() {
//        return output; }

}

