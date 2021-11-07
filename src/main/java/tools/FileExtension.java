package tools;

import java.io.FileNotFoundException;

public class FileExtension {

    public static String getExtension(String fileName) throws FileNotFoundException {
        if (fileName.indexOf('.') < 0 || fileName.indexOf('.') == fileName.length() - 1) {
            throw new FileNotFoundException("Incorrect file name input");
        }

        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}