package neznaiyka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Command {



    public static void readCommand(boolean exit) throws IOException {
        boolean exitCommand = exit;
        while(!exitCommand) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s = br.readLine().replaceAll("[\\s]{2,}", " ").split(" ");

            switch (s[0]) {
                case "add_from_list":
                    System.out.println("List of available humans:");
                    System.out.println(OutCommand.show_list());
                    AddCommand.add_from_list();
                    System.out.println("write next command");
                    break;
                case "add":
                    AddCommand.add(HumanDeque.getHumans());
                    System.out.println("write next command");
                    break;
                case "add_if_last":
                    AddCommand.add_if_last(HumanDeque.getHumans());
                    System.out.println("write next command");
                    break;
                case "show":
                    System.out.println(OutCommand.show());
                    break;
                case "show_list":
                    System.out.println(OutCommand.show_list());
                    break;
                case "info":
                    System.out.println(OutCommand.info());
                    break;
                case "remove":
                    RemoveCommand.removeFromDeque();
                    System.out.println("write next command");
                    break;
                case "remove_last":
                    RemoveCommand.remove_last();
                    System.out.println("write next command");
                    break;
                case "start":
                    start();
                    break;
                case "clean":
                    RemoveCommand.clean();
                    System.out.println("write next command");
                    break;
                case "help":
                    System.out.println(OutCommand.help());
                    break;
                case "exit":
                    exitCommand = true;
                    break;
                default:
                    System.out.println("Unknown command");
                    System.out.println("Write command");
                    break;
            }
        }
    }

    public static void update() throws IOException {
        if (HumanDeque.getOutput()!=null) {
            if (FileRedactor.readFile(HumanDeque.getOutput()) != null) {
                String info = FileRedactor.readFile(HumanDeque.getOutput()).replaceAll("^[\\s]+", "");
                FileRedactor.writeInFile(HumanDeque.getOutput(), info);
                String str[] = info.replaceAll("[\\s]+", "zzz").split("zzz");
                for (String s : str) {

                    ArrayList<String> humanInfo = new ArrayList<>();

                    humanInfo.add("humanType-" + s.split(";")[0]);
                    humanInfo.add("name-" + s.split(";")[1]);
                    humanInfo.add("thinkingType-" + s.split(";")[2]);
                    humanInfo.add("talent-" + s.split(";")[3]);

                    AddCommand.setModificationTime(System.currentTimeMillis());
                    AddCommand.addHuman(humanInfo);
                    humanInfo.clear();
                }
            }
        }else {
            System.out.println("your output environment is null" + "\n" +
                    "at first write: export OUTPATH=@your_output_file@"+ "\n" +
                    "and then you can start the program");
            readCommand(true);
        }

    }



    /**
     * method to start action, it gets action participants from collection.
     *if in collection too low persons, participants will get from input.csv
     *
     */
    public static void start(){


        if (HumanDeque.getHumans().size() <= 2){
            AddCommand.setModificationTime(System.currentTimeMillis());
            Action.startAction(AddCommand.addHumanFromList(FileRedactor.readFile(HumanDeque.getInput())));
            HumanDeque.setAvailableHumans("Pilulkin;Tubic");
            //FileRedactor.writeInFile(output,FileRedactor.readFile(input));
        }else{
            try{Action.getSize(HumanDeque.getHumans());
                Action.startAction(HumanDeque.getHumans());
            }catch (NumberOfPeopleException exc){
                System.out.println("    TOO MANY PEOPLE IN THIS ACTION"); }
        }

    }

}
