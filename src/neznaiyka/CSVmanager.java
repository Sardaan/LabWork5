package neznaiyka;

import java.io.*;
import java.util.*;

public class CSVmanager {
    private static final String CSVseparator = ",";

    private static Map<String, String> envMap = System.getenv();
    public final static File output = new File(envMap.get("OUTPATH"));

    /**
     * write human parameters in CSV file
     *
     */
    public static void HumansToCSV(){
        StringBuilder line = new StringBuilder();
        TreeSet<Human> treeSet = new TreeSet<>(Human::compareTo);
        for(Human hum : HumanDeque.getHumans()){
            treeSet.add(hum);
        }
        for(Human human : treeSet) {
            line.append(human.getName()).append(CSVseparator);
            line.append(human.getThinkingType()).append(CSVseparator);
            line.append(human.getTalent()).append(CSVseparator);
            line.append(human.getWritingType()).append(CSVseparator);
            line.append(human.getReadingType()).append(CSVseparator);
            line.append(human.getLikeToWork()).append("\n");
        }
            FileRedactor.writeInFile(output, line.toString());

    }
    //todo обработать когда null
    /**
     * method to load collection from csv file
     */
    public static void load(){
        int numberOfStr = 0;
        int numberOfHum = 0;

        if (!FileChecker.checkFile(output) ){

            System.exit(0);
        }
        if (output!=null) try {
            String outFile = FileRedactor.readFile(output);

            String[] lines = outFile.split(";");
            for (String line : lines) {
                numberOfStr++;

                String name = null;
                ThinkingType thinkingType = null;
                Talent talent = null;
                WritingType writingType = null;
                ReadingType readingType = null;
                boolean likeToWork = false;

                String info[] = line.split(",");

                if (info[0] != null) {
                    name = info[0].trim();
                }
                if (info[1] != null) {
                    switch (info[1].toLowerCase()) {
                        case "genius":
                            thinkingType = ThinkingType.GENIUS;
                            break;
                        case "clever":
                            thinkingType = ThinkingType.CLEVER;
                            break;
                        case "average":
                            thinkingType = ThinkingType.AVERAGE;
                            break;
                        case "silly":
                            thinkingType = ThinkingType.SILLY;
                            break;
                    }
                }
                if (info[2] != null) {
                    switch (info[2].toLowerCase()) {
                        case "nope":
                            talent = Talent.NOPE;
                            break;
                        case "music":
                            talent = Talent.MUSIC;
                            break;
                        case "painting":
                            talent = Talent.PAINTING;
                            break;
                        case "medicine":
                            talent = Talent.MEDICINE;
                            break;
                        case "knowledge":
                            talent = Talent.KNOWLEDGE;
                            break;
                        case "hospitality":
                            talent = Talent.HOSPITALITY;
                            break;
                        case "cooking":
                            talent = Talent.COOKING;
                            break;
                        case "thinking out":
                            talent = Talent.ThinkingOUT;
                            break;
                    }
                }
                if (info[3] != null) {
                    switch (info[3].toLowerCase()) {
                        case "lowercase":
                            writingType = WritingType.LOWERCASE;
                            break;
                        case "typed":
                            writingType = WritingType.TYPED;
                            break;
                    }
                }
                if (info[4] != null) {
                    switch (info[4].toLowerCase()) {
                        case "bysyllable":
                            readingType = ReadingType.BySYLLABLE;
                            break;
                        case "byword":
                            readingType = ReadingType.ByWORD;
                            break;
                    }
                }
                if (info[5] != null) {
                    if (info[5].equals("false"))
                        likeToWork = false;
                    else if (info[5].equals("true"))
                        likeToWork = true;
                }

                if (name != null && thinkingType != null && talent != null && writingType != null && readingType != null) {
                    numberOfHum++;
                    Human human = new Human(name, thinkingType, talent, writingType, readingType, likeToWork);
                    HumanDeque.getHumans().add(human);
                }
            }
            if (numberOfHum != numberOfStr)
                System.out.println("File was damaged, that part of info will not be load");

        } catch (NumberFormatException | NoSuchElementException e) {
            System.out.println("cant read this file");
            System.exit(0);
        }
        AddCommand.setModificationTime(System.currentTimeMillis());

    }

}
