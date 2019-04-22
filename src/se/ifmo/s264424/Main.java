package se.ifmo.s264424;

import se.ifmo.s264424.commands.Command;

import java.io.IOException;

public class Main {

    public static void main(String[] args){

        HumanDeque deque = new HumanDeque();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                deque.saveCollection();
            } catch (Exception e) {
                System.err.println("Collection is not saved!");
            }

        }));

        try{
            CSVmanager.load();
        }catch (Exception e){
            System.out.println("Can't load info from file");
            System.exit(0);
        }
        System.out.println("Write your command or 'help'");
        Command command = new Command();
        command.readCommand();
    }
}



