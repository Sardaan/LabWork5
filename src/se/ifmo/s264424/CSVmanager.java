package se.ifmo.s264424;

import se.ifmo.s264424.commands.AddCommand;
import se.ifmo.s264424.enums.Talent;
import se.ifmo.s264424.enums.WritingType;
import se.ifmo.s264424.enums.ReadingType;
import se.ifmo.s264424.enums.ThinkingType;

import java.io.*;
import java.util.*;

public class CSVmanager {
    private static final String CSVseparator = ",";
    private static Map<String, String> envMap = System.getenv();
    private static File output;
    public static File getOut(){
        return output;
    }

    /**
     * write human parameters in CSV file
     *
     */
    public static void HumansToCSV(){
        StringBuilder line = new StringBuilder();
        TreeSet<Human> treeSet = new TreeSet<>(Human::compareTo);
        treeSet.addAll(HumanDeque.getHumans());
        line.append("name,thinkingType,talent,writingType,readingType,likeToWork");
        line.append("\n");
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
        try{
           output = new File(envMap.get("OUTPATH"));
        }catch (Exception e){
            System.out.println("Maybe you didn't set your output environment right" + "\n" +
                    "at first write: export OUTPATH=@your_output_file@"+ "\n" +
                    "and then you can start the program");
            System.exit(0);
        }if (!FileChecker.checkFile(CSVmanager.getOut())){
            System.out.println("your environment set wrong ");
            System.exit(0);
            }
        String outFile;
        int numberOfStr = 0;

        if ((outFile=FileRedactor.readFile(output))!=null) {
            try {
                String[] lines = outFile.split(";");
                for (int i=1; i<lines.length;i++){
                    numberOfStr++;
                    String info[] = lines[i].split(",");
                    if (info.length == 6) {
                        CSVtoHuman(info);
                    }
                }
                if (HumanDeque.getHumans().size() != numberOfStr)
                    System.out.println("File was damaged, that part of info will not be load");
            } catch (NumberFormatException | NoSuchElementException e) {
                System.out.println("can't read this file");
                System.exit(0);
            }
        }
        AddCommand.setModificationTime(System.currentTimeMillis());

    }

    public static void CSVtoHuman(String []info){

        String name = null;
        ThinkingType thinkingType = null;
        Talent talent = null;
        WritingType writingType = null;
        ReadingType readingType = null;
        Boolean likeToWork = null;


        if (info[0] != null) {
            name = info[0].trim();
        }
        if (info[1] != null) {
            thinkingType = ThinkingType.getType(info[1]);
        }
        if (info[2] != null) {
            talent = Talent.getTalent(info[2]);
        }
        if (info[3] != null) {
            writingType = WritingType.getType(info[3]);
        }
        if (info[4] != null) {
            readingType = ReadingType.getType(info[4]);
        }
        if (info[5] != null) {
            if (info[5].equals("false"))
                likeToWork = false;
            else if (info[5].equals("true"))
                likeToWork = true;
        }

        if (name != null && thinkingType != null && talent != null && writingType != null && readingType != null && likeToWork != null) {
            Human human = new Human(name, thinkingType, talent, writingType, readingType, likeToWork);
            HumanDeque.getHumans().add(human);
        }
    }





}
