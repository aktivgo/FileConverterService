package fileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import gameLibrary.Developer;
import gameLibrary.Game;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DevelopersWriter implements Writer {
    @Override
    public void write(Object object, String filePath) throws IOException {
        ArrayList<Developer> developers = (ArrayList<Developer>) object;

        JsonObject developersObject = getDevelopersObject(developers);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(developersObject);

        File file = new File(filePath);
        file.createNewFile();
        FileWriter writer = new FileWriter(filePath, false);
        writer.write(json);
        writer.flush();
        writer.close();
    }

    private @NotNull JsonObject getDevelopersObject(@NotNull ArrayList<Developer> developers) {
        JsonArray jsonDevelopers = new JsonArray();
        for (Developer developer : developers) {
            JsonObject jsonDeveloper = new JsonObject();
            jsonDeveloper.addProperty("name", developer.getName());
            jsonDeveloper.add("games", getGamesJson(developer));

            JsonObject genreObject = new JsonObject();
            genreObject.add("developer", jsonDeveloper);
            jsonDevelopers.add(genreObject);
        }

        JsonObject developersObject = new JsonObject();
        developersObject.add("developers", jsonDevelopers);
        return developersObject;
    }

    private @NotNull JsonArray getGamesJson(@NotNull Developer developer){
        JsonArray jsonGames = new JsonArray();

        for (Game game : developer.getGames()) {
            JsonObject gameObject = new JsonObject();
            gameObject.addProperty("name", game.getName());
            gameObject.addProperty("publisher", game.getPublisher());
            gameObject.addProperty("releaseDate", game.getReleaseDate());
            gameObject.add("tags", getTagsJson(game));

            jsonGames.add(gameObject);
        }

        return jsonGames;
    }

    private @NotNull JsonArray getTagsJson(@NotNull Game game) {
        JsonArray jsonTags = new JsonArray();
        for (String tag : game.getTags()) {
            jsonTags.add(tag);
        }
        return jsonTags;
    }
}