package fileConverter;

import fileReader.DevelopersReader;
import fileWriter.GamesWriter;
import gameLibrary.Developer;
import gameLibrary.Game;
import org.xml.sax.SAXException;
import tools.FileExtension;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class JsonToXml implements FileConverter {
    @Override
    public void convert(String jsonFileName, String xmlFileName) throws IOException, ParserConfigurationException, SAXException {
        if (!FileExtension.getExtension(jsonFileName).equals("xml")) {
            throw new IllegalArgumentException("Неверное расширение файла");
        }
        DevelopersReader reader = new DevelopersReader();
        ArrayList<Developer> developers = (ArrayList<Developer>) reader.read("data/input/" + jsonFileName);
        ArrayList<Game> games = convertDevelopersToGames(developers);

        GamesWriter writer = new GamesWriter();
        writer.write(games, "data/output/" + xmlFileName);
    }

    private ArrayList<Game> convertDevelopersToGames(ArrayList<Developer> developers) {
        return null;
    }
}