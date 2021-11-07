package gameLibrary;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Developer {
    private String name = null;
    private ArrayList<Game> games;

    public Developer(){
        games = new ArrayList<>();
    }

    public String getName() {
        if (name.isEmpty()) {
            throw new NullPointerException("Название не было установлено");
        }
        return name;
    }

    public void setName(@NotNull String name) {
        if (name.isEmpty()) {
            throw new NullPointerException("Устанавливаемое название пустое");
        }
        this.name = name;
    }

    public ArrayList<Game> getGames() {
        if (name.isEmpty()) {
            throw new NullPointerException("Список игр не был установлен");
        }
        return games;
    }

    public void setGames(@NotNull ArrayList<Game> games) {
        if (games.isEmpty()) {
            throw new NullPointerException("Устанавливаемый список тегов пустой");
        }
        this.games = games;
    }
}