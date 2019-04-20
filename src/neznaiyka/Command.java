package neznaiyka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Command {

    public void readCommand(boolean exit) throws IOException {
        // разрешение на выход
        try {
            while (exit) {
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
                    case "remove":
                        RemoveCommand command5 = new RemoveCommand();
                        command5.removeFromDeque();
                        System.out.println("write next command");
                        break;
                    case "remove_last":
                        RemoveCommand command6 = new RemoveCommand();
                        command6.remove_last();
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
                        HumanDeque collection = new HumanDeque();
                        collection.saveCollection();
                        exit = false;
                        break;
                    default:
                        System.out.println("Unknown command");
                        System.out.println("Write command");
                        break;
                }
            }
        }catch (IOException e){
            System.out.println("command reading error");
        }catch (NullPointerException nul){
            System.out.println("you stopped");
            HumanDeque collection = new HumanDeque();
            collection.saveCollection();
        }
    }

    // todo checkConsole




}
