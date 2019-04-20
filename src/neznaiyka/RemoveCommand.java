package neznaiyka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveCommand extends Command{


    /**
     * method to delete the specified item in the collection
     *
     * @throws IOException
     */
    public void removeFromDeque() throws IOException {
        System.out.println("Write person you want to remove");
        String human = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        Human humanToRemove = null;

        for(Human hum: HumanDeque.getHumans()){
            if (hum.getName().equals(human)) {
                humanToRemove = hum;
            }
        }if (humanToRemove!=null){

            HumanDeque.getHumans().remove(humanToRemove);
            AddCommand.setModificationTime(System.currentTimeMillis());
        }

    }


    /**
     * method to delete the last item in the collection
     *
     */
    public void remove_last(){

        HumanDeque.getHumans().remove(HumanDeque.getHumans().getLast());
        AddCommand.setModificationTime(System.currentTimeMillis());
    }

    /**
     * method to remove all elements from collection
     *
     */
    public void clean(){

        int size = HumanDeque.getHumans().size();
        for(int i=0; i<size;i++)
            remove_last();
        AddCommand.setModificationTime(System.currentTimeMillis());
    }
}
