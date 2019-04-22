package se.ifmo.s264424.commands;

import se.ifmo.s264424.HumanDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Command {

    public void readCommand() {
        // разрешение на выход
        boolean exit = true;
        try {
            while (exit) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine().trim().toLowerCase();//.replaceAll("[\\s]{2,}", " ").split(" ");
                switch (s) {
                    case "add":
                        AddCommand command1 = new AddCommand();
                        command1.add();
                        break;
                    case "add_if_last":
                        AddCommand command2 = new AddCommand();
                        command2.add_if_last();
                        break;
                    case "add_if_first":
                        AddCommand addFirst = new AddCommand();
                        addFirst.add_if_first();
                        break;
                    case "remove":
                        RemoveCommand command5 = new RemoveCommand();
                        command5.removeFromDeque();
                        break;
                    case "remove_last":
                        RemoveCommand command6 = new RemoveCommand();
                        command6.remove_last();
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
                        break;
                    case "help":
                        OutCommand command8 = new OutCommand();
                        System.out.println(command8.help());
                        break;
                    case "exit":
                        HumanDeque collection = new HumanDeque();
                        collection.saveCollection();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Unknown command");
                        break;
                }System.out.println("Write command");
            }
        }catch (IOException e){
            System.out.println("command reading error");
        }catch (NullPointerException n){
            System.out.println("you stopped");
        }
    }

}
