package fileConverter;

import fileReader.GamesReader;
import fileWriter.DevelopersWriter;
import gameLibrary.Developer;
import gameLibrary.Game;
import org.jetbrains.annotations.NotNull;
import org.xml.sax.SAXException;
import tools.FileExtension;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class XmlToJson implements FileConverter {

    @Override
    public void convert(String xmlFileName, String jsonFileName) throws IOException, ParserConfigurationException, SAXException {
        if (!FileExtension.getExtension(jsonFileName).equals("json")) {
            throw new IllegalArgumentException("Неверное расширение файла");
        }
        GamesReader reader = new GamesReader();
        ArrayList<Game> games = (ArrayList<Game>) reader.read("data/input/" + xmlFileName);
        ArrayList<Developer> developers = convertGamesToDevelopers(games);

        DevelopersWriter writer = new DevelopersWriter();
        writer.write(developers, "data/output/" + jsonFileName);
    }

    private @NotNull ArrayList<Developer> convertGamesToDevelopers(@NotNull ArrayList<Game> games) {
        ArrayList<Developer> developers = new ArrayList<>();

        for (Game game : games) {
            Developer developer = new Developer();
            developer.setName(game.getDeveloper());
            if (contains(developers, developer.getName())) continue;

            ArrayList<Game> developerGames = new ArrayList<>();
            for (Game gameLoop : games) {
                if (gameLoop.getDeveloper().equals(developer.getName())) {
                    developerGames.add(gameLoop);
                }
            }
            developer.setGames(developerGames);
            developers.add(developer);
        }

        return developers;
    }

    private boolean contains(@NotNull ArrayList<Developer> developers, String developerName) {
        for (Developer developer : developers) {
            if (developer.getName().equals(developerName)) {
                return true;
            }
        }

        return false;
    }
}