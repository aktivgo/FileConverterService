import fileConverter.XmlToJson;
import fileReader.GamesReader;
import gameLibrary.Game;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Некорректное количество аргументов");
        }

        XmlToJson converter = new XmlToJson();
        converter.convert("games.xml", "developers.json");
        System.out.println("Преобразование прошло успешно, результат сохранен в файл " + "developers.json");
    }
}