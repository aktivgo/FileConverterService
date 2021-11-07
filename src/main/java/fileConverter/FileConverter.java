package fileConverter;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileConverter {
    void convert(String inputFileName, String outputFileName) throws IOException, ParserConfigurationException, SAXException, ParseException, XMLStreamException;
}