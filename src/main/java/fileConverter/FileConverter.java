package fileConverter;

import java.io.FileNotFoundException;

public interface FileConverter {
    void convert(String inputFileName, String outputFileName) throws FileNotFoundException;
}