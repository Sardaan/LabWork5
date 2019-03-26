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


        //если имя по алфавиту меньше чем все остальные имана в коллекции
        //то метод возвращиет отрицательное значение
    public static int compareTo(String name){
        int isLast = 0;
        for (Human hum: HumanDeque.getHumans()) {
            if (name.compareTo(hum.getName())>0){
                isLast++;

            }
        }return HumanDeque.getHumans().size() - isLast;
    }


}

