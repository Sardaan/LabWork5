package neznaiyka;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        Command.update();

        if (HumanDeque.output!=null) {
            System.out.println("Write your command or 'help'");
            Command command = new Command();
            command.readCommand(false);
        }


    }
}

//todo outpath,
//todo права доступа
//todo доступы в файл
//todo дофига эксепшенов  :(((

//todo енам в записи файла
//Todo add if last
//todo переименовать джарник
