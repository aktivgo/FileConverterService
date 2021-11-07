package fileConverter;

import fileReader.DevelopersReader;
import fileWriter.GamesWriter;
import gameLibrary.Developer;
import gameLibrary.Game;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;
import tools.FileExtension;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;

public class JsonToXml implements FileConverter {
    @Override
    public void convert(String jsonFileName, String xmlFileName) throws IOException, ParseException, XMLStreamException {
        if (!FileExtension.getExtension(xmlFileName).equals("xml")) {
            throw new IllegalArgumentException("Неверное расширение файла");
        }
        DevelopersReader reader = new DevelopersReader();
        ArrayList<Developer> developers = (ArrayList<Developer>) reader.read("data/input/" + jsonFileName);
        ArrayList<Game> games = convertDevelopersToGames(developers);

        GamesWriter writer = new GamesWriter();
        writer.write(games, "data/output/" + xmlFileName);
    }

    private @NotNull ArrayList<Game> convertDevelopersToGames(@NotNull ArrayList<Developer> developers) {
        ArrayList<Game> games = new ArrayList<>();

        for (Developer developer : developers) {
            ArrayList<Game> developerGames = developer.getGames();
            games.addAll(developerGames);
        }

        return games;
    }
}