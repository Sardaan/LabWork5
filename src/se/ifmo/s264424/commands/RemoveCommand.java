package se.ifmo.s264424.commands;


import se.ifmo.s264424.Human;
import se.ifmo.s264424.HumanDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class RemoveCommand extends Command {


    /**
     * method to delete the specified item in the collection
     *
     * @throws IOException
     */
    public void removeFromDeque() throws IOException {
        System.out.println("Write person you want to remove");
        String human = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        Human humanToRemove = null;
        try {
            for (Human hum : HumanDeque.getHumans()) {
                if (hum.getName().equals(human)) {
                    humanToRemove = hum;
                }
            }
            if (humanToRemove != null) {

                HumanDeque.getHumans().remove(humanToRemove);
                AddCommand.setModificationTime(System.currentTimeMillis());
            }
        }catch (NoSuchElementException e){
            System.out.println("There is no human to remove");
        }

    }


    /**
     * method to delete the last item in the collection
     *
     */
    public void remove_last(){
        try {
            HumanDeque.getHumans().remove(HumanDeque.getHumans().getLast());
            AddCommand.setModificationTime(System.currentTimeMillis());
        }catch(NoSuchElementException e){
            System.out.println("There is no human to remove");
        }
    }

    /**
     * method to remove all elements from collection
     *
     */
    public void clean(){
        try {
            int size = HumanDeque.getHumans().size();
            for (int i = 0; i < size; i++)
                remove_last();
            AddCommand.setModificationTime(System.currentTimeMillis());
        }catch (NoSuchElementException e){
            System.out.println("There is no human to remove");
        }

    }
}
