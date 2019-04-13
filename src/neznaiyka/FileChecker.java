package neznaiyka;

import java.io.*;

public class FileChecker {
    public static boolean checkFile(File file) {
        try {
            boolean exists = file.exists();
            if (exists) {
                if (!file.canWrite()) {
                    System.out.println("Файл не может быть записан!");
                    return false;
                } else {
                    if (!file.canRead()) {
                        System.out.println("Файл не может быть прочтен!");
                        return false;
                    } else if (!file.isFile()) {
                        System.out.println("Необходим файл, а не директория!");
                        return false;
                    } else
                        return true;
                }
            } else {
                System.out.println("Файл не существует!");
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
//todo сделать файл setWritable