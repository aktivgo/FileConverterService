package fileReader;

import gameLibrary.Developer;
import gameLibrary.Game;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DevelopersReader implements Reader {

    @Override
    public @NotNull Object read(@NotNull String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(fileName);
        JSONObject document = (JSONObject) parser.parse(reader);
        return getDevelopers(document);
    }

    private @NotNull ArrayList<Developer> getDevelopers(@NotNull JSONObject document) {
        ArrayList<Developer> developers = new ArrayList<>();

        JSONArray developersJson = (JSONArray) document.get("developers");
        for (Object developerJson : developersJson) {
            JSONObject developerData = (JSONObject) developerJson;
            JSONObject developerProperties = (JSONObject) developerData.get("developer");
            Developer developer = getDeveloper(developerProperties);
            fillDevelopersInGames(developer);
            developers.add(developer);
        }

        return developers;
    }

    private @NotNull Developer getDeveloper(@NotNull JSONObject developerProperties) {
        Developer developer = new Developer();

        developer.setName(developerProperties.get("name").toString());
        JSONArray gamesJson = (JSONArray) developerProperties.get("games");
        ArrayList<Game> games = getGames(gamesJson);
        developer.setGames(games);

        return developer;
    }


    private void fillDevelopersInGames(@NotNull Developer developer) {
        ArrayList<Game> games = developer.getGames();
        for (Game game : games) {
            game.setDeveloper(developer.getName());
        }
    }

    private @NotNull ArrayList<Game> getGames(@NotNull JSONArray gamesJson) {
        ArrayList<Game> games = new ArrayList<>();

        for (Object gameJson : gamesJson) {
            JSONObject gameData = (JSONObject) gameJson;
            Game game = getGame(gameData);
            games.add(game);
        }
        return games;
    }

    private @NotNull Game getGame(@NotNull JSONObject gameData) {
        Game game = new Game();
        game.setName(gameData.get("name").toString());
        game.setPublisher(gameData.get("publisher").toString());
        game.setReleaseDate(gameData.get("releaseDate").toString());
        JSONArray tagsJson = (JSONArray) gameData.get("tags");
        setTagsToGame(tagsJson, game);
        return game;
    }

    private void setTagsToGame(@NotNull JSONArray tagsJson, @NotNull Game game) {
        ArrayList<String> tags = new ArrayList<>();
        for (Object tag : tagsJson) {
            tags.add(tag.toString());
        }
        game.setTags(tags);
    }
}