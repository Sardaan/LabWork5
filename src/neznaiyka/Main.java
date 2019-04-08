package neznaiyka;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        Command.update();

        if (HumanDeque.getOutput()!=null) {
            System.out.println("Write your command or 'help'");
            Command.readCommand(false);
        }


    }
}

