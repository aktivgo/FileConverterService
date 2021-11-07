package fileWriter;

import gameLibrary.Developer;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public interface Writer {
    void write(Object object, String fileName) throws IOException, XMLStreamException, TransformerConfigurationException;
}