package neznaiyka;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRedactor {


    static public String readFile(String filename) {
        String line;
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String total = null;

        for (String str : lines){
            if (total==null){
                total = str;
            }else
            total=total+"\n"+str;
        }
        return total;
    }
    static public void writeInFile(String fileName, String text){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(text);
            bw.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void addToFile(String fileName, String text){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
            bw.write(text);
            bw.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
