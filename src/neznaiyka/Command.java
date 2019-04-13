package neznaiyka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class Command {



    public void readCommand(boolean exit) throws IOException {
        boolean exitCommand = exit;
        while(!exitCommand) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s = br.readLine().replaceAll("[\\s]{2,}", " ").split(" ");

            switch (s[0]) {
                case "add":
                    AddCommand command1 = new AddCommand();
                    command1.add();
                    System.out.println("write next command");
                    break;
                case "add_if_last":
                    AddCommand command2 = new AddCommand();
                    command2.add_if_last();
                    System.out.println("write next command");
                    break;
                case "show":
                    OutCommand command3 = new OutCommand();
                    System.out.println(command3.show());
                    break;
                case "info":
                    OutCommand command4 = new OutCommand();
                    System.out.println(command4.info());
                    break;
                case "remove":
                    RemoveCommand command5 =new RemoveCommand();
                    command5.removeFromDeque();
                    System.out.println("write next command");
                    break;
                case "remove_last":
                    RemoveCommand command6 = new RemoveCommand();
                    command6.remove_last();
                    System.out.println("write next command");
                    break;
                case "clean":
                    RemoveCommand command7 = new RemoveCommand();
                    command7.clean();
                    System.out.println("write next command");
                    break;
                case "help":
                    OutCommand command8 = new OutCommand();
                    System.out.println(command8.help());
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

    // todo какая то хрень с проверкой файлов
    public void update() throws IOException {
        if (FileRedactor.readFile(HumanDeque.output) != null) {
            FileChecker.checkFile(HumanDeque.output);
            String info = FileRedactor.readFile(HumanDeque.output).replaceAll("^[\\s]+", "");
            FileRedactor.writeInFile(HumanDeque.output, info);
            String str[] = info.replaceAll("[\\s]+", "zzz").split("zzz");
            for (String s : str) {

                ArrayList<String> humanInfo = new ArrayList<>();
                humanInfo.add("humanType-" + s.split(";")[0]);
                humanInfo.add("name-" + s.split(";")[1]);
                humanInfo.add("thinkingType-" + s.split(";")[2]);
                humanInfo.add("talent-" + s.split(";")[3]);

                AddCommand.setModificationTime(System.currentTimeMillis());
                //AddCommand.addHuman(humanInfo);
                humanInfo.clear();
            }

        }else {
            System.out.println("your output environment is null" + "\n" +
                    "at first write: export OUTPATH=@your_output_file@"+ "\n" +
                    "and then you can start the program");
        }

    }

}
