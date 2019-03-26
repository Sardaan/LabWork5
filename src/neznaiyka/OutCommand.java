package neznaiyka;

public class OutCommand extends Command{

    private static final String helpMSG="Команды для интерактивного управления коллекцией \n" +
            "   help:                 выводит список доступных команд.\n"+
            "   add_from_list:        добавит готовый элемент из списка в коллекцию.\n" +
            "   add_if_last:          добавит элемент в коллекцию, если имя этого объекта по алфавиту в меньшее.\n" +
            "   add:                  добавит новый элемент в коллекцию.\n" +
            "   show:                 выводит в стандартный поток вывода все элементы коллекции.\n" +
            "   show_list:            выводит в стандартный поток вывода готовые элементы которые можно добавить в коллекцию.\n" +
            "   info:                 выводит в стандартный поток вывода основную информацию о коллекции.\n" +
            "   remove:               удалит элемент из коллекции по его значению.\n" +
            "   remove_last:          удалит из коллекции последний элементы.\n" +
            "   start:                запустит основную программу для настроенной коллекции.\n" +
            "   clear:                очистит коллекцию. \n" +
            "   exit:                 выход из программы (сохранение текущей коллекции в файл). \n";


    /**
     * method of displaying information about the collection
     *
     * @return info about collection
     */
    public static String info(){

        if(HumanDeque.getHumans().size()!=0) {
            return "Подробная информация о коллекции: " + HumanDeque.getHumans().getClass() + "\n" +
                    "Количество элементов: " + HumanDeque.getHumans().size() + "\n" +
                    "HashCode: " + HumanDeque.getHumans().hashCode() + "\n" ;
        }else {
            return "No humans added";
        }
    }

    /**
     * method of displaying humans in collection
     *
     * @return elements of collection
     */

    public static String show(){
        if (FileRedactor.readFile(HumanDeque.getOutput())==null)
            return "There is no added humans";
        else{

            System.out.println("humanType;name;thinkingType,talent"+"\n");
            return FileRedactor.readFile(HumanDeque.getOutput());
        }
    }


    /**
     * method of displaying available humans to add in collection
     *
     * @return list of available humans
     */
    public static String show_list(){
        return HumanDeque.getAvailableHumans();
    }

    /**
     * method of displaying information about available commands
     *
     * @return info about available commands
     */
    public static String help(){
        return helpMSG;
    }
}
