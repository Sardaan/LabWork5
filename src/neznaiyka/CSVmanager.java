package neznaiyka;

import java.io.*;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
        for(Human human : HumanDeque.getHumans()) {
            line.append(human.getName()).append(CSVseparator);
            line.append(human.getThinkingType()).append(CSVseparator);
            line.append(human.getTalent()).append(CSVseparator);
            line.append(human.getWritingType()).append(CSVseparator);
            line.append(human.getReadingType()).append(CSVseparator);
            line.append(human.getLikeToWork()).append("\n");
        }
            FileRedactor.writeInFile(output, line.toString());

    }
    //todo чтобы сделать типо сериализации
    //todo обработать когда null
    // в телефоне посмотри на реализацию миши

    /**
     * method to load collection from csv file
     */
    //todo возвращает только один последний елемент
    public static void load(){

        if (!FileChecker.checkFile(output) ){

            System.exit(0);
        }
        if (output!=null) {
            try {
                String name = null;
                ThinkingType thinkingType = null;
                Talent talent = null;
                WritingType writingType = null;
                ReadingType readingType = null;
                boolean likeToWork = false;

                Scanner sc = new Scanner(output);
                while (sc.hasNextLine()) {
                    sc.useDelimiter(",");
                    if (sc.hasNext()) {
                        name = (sc.next()).trim();
                    }
                    if (sc.hasNext()) {
                        String column2 = sc.next().trim();
                        switch (column2.toLowerCase()) {
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
                    if (sc.hasNext()) {
                        String column3 = sc.next().trim();
                        switch (column3.toLowerCase()) {
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
                    if (sc.hasNext()) {
                        String column4 = sc.next().trim();
                        switch (column4.toLowerCase()) {
                            case "lowercase":
                                writingType = WritingType.LOWERCASE;
                                break;
                            case "typed":
                                writingType = WritingType.TYPED;
                                break;
                        }
                    }
                    if (sc.hasNext()) {
                        String column5 = sc.next().trim();
                        switch (column5.toLowerCase()) {
                            case "by syllable":
                                readingType = ReadingType.BySYLLABLE;
                                break;
                            case "by word":
                                readingType = ReadingType.ByWORD;
                                break;
                        }
                    }
                    if (sc.hasNext()) {
                        String column6 = sc.next().trim();
                        if (column6.equals("false"))
                            likeToWork = false;
                        else if (column6.equals("true"))
                            likeToWork = true;
                    }
                    //todo if the file was damaged

                    if (name!=null && thinkingType!=null && talent!=null && writingType!=null && readingType==null){
                        Human human = new Human(name, thinkingType, talent, writingType, readingType, likeToWork);
                        HumanDeque.getHumans().add(human);
                    }else{
                        System.out.println("File was damaged, that part of info will not be load");
                    }

                    if (sc.hasNextLine())
                        sc.nextLine();
                }
            } catch (NumberFormatException | NoSuchElementException e) {
                System.out.println("cant read this file");
                System.exit(0);
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
        AddCommand.setModificationTime(System.currentTimeMillis());

    }

}
