package neznaiyka;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRedactor {

    /**
     * method to read the text in file
     * @param file
     * @return file's content
     */
    static public String readFile(File file) {
        String line;
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file.getName()));
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Can't read file");
        }
        String total = null;

        for (String str : lines){
            if (total==null){
                total = str;
            }else
            total=total+";"+str;
        }
        return total;
    }

    /**
     * method to write text in file
     * @param file
     * @param text
     */
    static public void writeInFile(File file, String text){
        try {
            if (FileChecker.checkFile(file)){
                BufferedWriter bw = new BufferedWriter(new FileWriter(file.getName()));
                bw.write(text);
                bw.flush();
                bw.close();
            }
        }

        catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Can't write in file");
        }
    }
}
