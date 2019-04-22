package se.ifmo.s264424;

import java.io.*;

public class FileChecker {
    /**
     * method to check file
     *
     * @param file
     * @return true if you can work with file
     */
    public static boolean checkFile(File file) {
        try {
            if(!file.exists() || !file.isFile()){
                System.out.println("file with that name doesn't exist");

                return false;
            }
            if (!file.canRead() || !file.canWrite()){
                System.out.println("You haven't rights to work with that file");
                return false;
            }
            else return true;
        } catch (Exception e) {
            return false;
        }
    }
}
//todo сделать файл setWritable