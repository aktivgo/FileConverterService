package fileConverter;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileConverter {
    void convert(String inputFileName, String outputFileName) throws IOException, ParserConfigurationException, SAXException;
}