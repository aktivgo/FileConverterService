package gameLibrary;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Developer {
    private String name;
    private ArrayList<Game> games;

    public Developer() {
        games = new ArrayList<>();
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(@NotNull ArrayList<Game> games) {
        this.games = games;
    }
}