package fileConverter;

import org.jetbrains.annotations.NotNull;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public interface FileConverter {
    void convert(@NotNull String inputFileName, @NotNull String outputFileName) throws IOException, ParserConfigurationException, SAXException, ParseException, XMLStreamException;
}