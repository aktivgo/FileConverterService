package fileWriter;

import gameLibrary.Developer;

import java.io.IOException;
import java.util.ArrayList;

public interface Writer {
    void write(Object object, String fileName) throws IOException;
}