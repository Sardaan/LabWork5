package neznaiyka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveCommand extends Command{


    /**
     * method to delete the specified item in the collection
     *
     * @throws IOException
     */
    public static void remove() throws IOException {
        System.out.println("Write person you want to remove");
        String human = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        for(Object hum: HumanDeque.getHumans()){
            if (hum.toString().equals(human)){
                HumanDeque.getHumans().remove(hum);
                if ("Pilulkin;Guslya;Ponchik;Steclyashkin;Tubic;Znaika;Lenny;Ern".contains(human)) {
                    if (!HumanDeque.getAvailableHumans().contains(human)){
                        HumanDeque.setAvailableHumans(HumanDeque.getAvailableHumans().concat(";" + human));
                    }
                    FileRedactor.writeInFile(HumanDeque.getAvailableHumansFile(), HumanDeque.getAvailableHumans());
                }
                FileRedactor.readFile(HumanDeque.getOutput()).replaceAll("^[\\s]+","");
                FileRedactor.writeInFile(HumanDeque.getOutput(), FileRedactor.readFile(HumanDeque.getOutput()).replaceAll("^[\\s]+",""));
                if (FileRedactor.readFile(HumanDeque.getOutput())!=null){
                    String str[] = FileRedactor.readFile(HumanDeque.getOutput()).replaceAll("[\\s]+","zZz").split("zZz");
                    for (int i=0; i<str.length;i++){
                        if(str.length==1 && str[i].contains(human)){
                            FileRedactor.writeInFile(HumanDeque.getOutput(),"");
                        }
                        if (str[i].contains(human) && str.length>1){
                            System.out.println("    =="+FileRedactor.readFile(HumanDeque.getOutput()).replaceAll(str[i]+"[\\s]+",""));
                            FileRedactor.writeInFile(HumanDeque.getOutput(), FileRedactor.readFile(HumanDeque.getOutput()).replaceAll(str[i]+"[\\s]+",""));
                        }
                    }
                }
            }
        }
    }


    /**
     * method to delete the last item in the collection
     *
     */
    public static void remove_last(){

        if (HumanDeque.getHumans().size()!=0){
            FileRedactor.readFile(HumanDeque.getOutput()).replaceAll("^[\\s]+","");
            FileRedactor.writeInFile(HumanDeque.getOutput(), FileRedactor.readFile(HumanDeque.getOutput()).replaceAll("^[\\s]+",""));
            HumanDeque.getHumans().remove(HumanDeque.getHumans().getLast());
            if ("Pilulkin;Guslya;Ponchik;Steclyashkin;Tubic;Znaika;Lenny;Ern".contains(HumanDeque.getHumans().getLast().toString())) {
                HumanDeque.setAvailableHumans(HumanDeque.getAvailableHumans().concat(";" + HumanDeque.getHumans().getLast().toString()));
                FileRedactor.writeInFile(HumanDeque.getAvailableHumansFile(), HumanDeque.getAvailableHumans());
            }
            if (FileRedactor.readFile(HumanDeque.getOutput())!=null){
                String string[] = FileRedactor.readFile(HumanDeque.getOutput()).replaceAll("[\\s]+","zzz").split("zzz");
                for (String str : string){
                    if(string.length==1 && str.contains(HumanDeque.getHumans().getLast().toString())){
                        FileRedactor.writeInFile(HumanDeque.getOutput(),"");
                    }
                    if (string.length>1 && str.contains(HumanDeque.getHumans().getLast().toString())){
                        FileRedactor.writeInFile(HumanDeque.getOutput(), FileRedactor.readFile(HumanDeque.getOutput()).replace(str,""));
                    }
                }
            }
        }

    }
    public static void removeAll(){
        for (int i=0; i<HumanDeque.getHumans().size();i++){
            remove_last();
        }
    }
}
