package fileConverter;

import tools.FileExtension;

import java.io.FileNotFoundException;

public class XmlToJson implements FileConverter {

    @Override
    public void convert(String xmlFileName, String jsonFileName) throws FileNotFoundException {
        if (!FileExtension.getExtension(jsonFileName).equals("json")) {
            throw new IllegalArgumentException("Неверное расширение файла");
        }

        
    }
}