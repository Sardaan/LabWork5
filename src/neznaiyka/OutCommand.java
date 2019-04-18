package neznaiyka;

public class OutCommand extends Command{

    private static final String helpMSG="Команды для интерактивного управления коллекцией \n" +
            "   add:                  добавит новый элемент в коллекцию.\n" +
            "   add_if_last:          добавит элемент в коллекцию, если имя этого объекта по алфавиту в меньшее.\n" +
            "   remove:               удалит элемент из коллекции по его значению.\n" +
            "   remove_last:          удалит из коллекции последний элемент.\n" +
            "   info:                 выводит в стандартный поток вывода основную информацию о коллекции.\n" +
            "   show:                 выводит в стандартный поток вывода все элементы коллекции.\n" +
            "   clean:                очистит коллекцию. \n" +
            "   exit:                 выход из программы (сохранение текущей коллекции в файл). \n";


    /**
     * method of displaying information about the collection
     *
     * @return info about collection
     */
    public String info(){
        long end = System.currentTimeMillis();
        String timeInfo = (end - AddCommand.getModificationTime())/1000 +" секунд прошло с обновления коллекции";
        if(HumanDeque.getHumans().size()!=0) {
            return "Подробная информация о коллекции: " + HumanDeque.getHumans().getClass() + "\n" +
                    "Количество элементов: " + HumanDeque.getHumans().size() + "\n" +
                    "HashCode: " + HumanDeque.getHumans().hashCode() + "\n"+ timeInfo;
        }else {
            return "No humans added";
        }
    }

    /**
     * method of displaying humans in collection
     *
     * @return elements of collection
     */
//todo toString, saveCollection
    public String show(){
        HumanDeque deque = new HumanDeque();
        if (HumanDeque.getHumans().size()==0)
            return "There is no added humans";
        else{
            System.out.println("name,thinkingType,talent,writingType,readingType,likeToWork");
            return deque.toString();
        }
    }


    /**
     * method of displaying information about available commands
     *
     * @return info about available commands
     */
    public String help(){
        return helpMSG;
    }
}
