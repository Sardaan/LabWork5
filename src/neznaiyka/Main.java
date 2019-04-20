package neznaiyka;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        HumanDeque deque = new HumanDeque();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                deque.saveCollection();
            } catch (Exception e) {
                System.err.println("Collection is not saved!");
            }

        }));

        CSVmanager.load();
        System.out.println("Write your command or 'help'");
        Command command = new Command();
        command.readCommand(true);



    }
}

//todo runtime getRuntime


