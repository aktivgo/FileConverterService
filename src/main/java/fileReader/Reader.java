package fileReader;

import gameLibrary.Game;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public interface Reader {
    Object read(String fileName) throws IOException, SAXException, ParserConfigurationException;
}