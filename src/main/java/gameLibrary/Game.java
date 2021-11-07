package gameLibrary;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Game {
    private String name = null;
    private String developer = null;
    private String publisher = null;
    private String releaseDate = null;
    private ArrayList<String> tags;

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

    public String getDeveloper() {
        if (developer.isEmpty()) {
            throw new NullPointerException("Разработчик не был установлен");
        }
        return developer;
    }

    public void setDeveloper(@NotNull String developer) {
        if (developer.isEmpty()) {
            throw new NullPointerException("Устанавливаемый разработчик пустой");
        }
        this.developer = developer;
    }

    public String getPublisher() {
        if (publisher.isEmpty()) {
            throw new NullPointerException("Издатель не был установлен");
        }
        return publisher;
    }

    public void setPublisher(@NotNull String publisher) {
        if (publisher.isEmpty()) {
            throw new NullPointerException("Устанавливаемый издатель пустой");
        }
        this.publisher = publisher;
    }

    public String getReleaseDate() {
        if (releaseDate.isEmpty()) {
            throw new NullPointerException("Дата выхода не была установлена");
        }
        return releaseDate;
    }

    public void setReleaseDate(@NotNull String releaseDate) {
        if (releaseDate.isEmpty()) {
            throw new NullPointerException("Устанавливаемая дата выхода пустая");
        }
        this.releaseDate = releaseDate;
    }

    public ArrayList<String> getTags() {
        if (tags.isEmpty()) {
            throw new NullPointerException("Теги не были установлены");
        }
        return tags;
    }

    public void setTags(@NotNull ArrayList<String> tags) {
        if (tags.isEmpty()) {
            throw new NullPointerException("Устанавливаемые теги пустые");
        }
        this.tags = tags;
    }
}