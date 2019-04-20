package neznaiyka;

import java.util.ArrayDeque;


public class HumanDeque{

    private static ArrayDeque<Human> humans = new ArrayDeque<>();
    public static ArrayDeque<Human> getHumans(){
        return humans;
    }

    /**
     * method to save collection
     */
    //todo save collection если нет доступа к файлу
    public void saveCollection(){

        if(FileChecker.checkFile(CSVmanager.output)) {
            CSVmanager.HumansToCSV();
        }
        else
            System.out.println("Cant save collection");

    }


    @Override
    public String toString() {
        String str="";
        if (getHumans().size()!=0) {
            for (Human human : getHumans()) {
                str = str + human.getName() + "," + human.getThinkingType() + "," + human.getTalent() + "," + human.getWritingType() +
                        "," + human.getReadingType() + "," + human.getLikeToWork() + "\n";
            }
        }
        return str;
    }
}

