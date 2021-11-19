package gameLibrary;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Game {
    private String name;
    private String developer;
    private String publisher;
    private String releaseDate;
    private ArrayList<String> tags;

    public Game() {
        tags = new ArrayList<>();
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull String getDeveloper() {
        return developer;
    }

    public void setDeveloper(@NotNull String developer) {
        this.developer = developer;
    }

    public @NotNull String getPublisher() {
        return publisher;
    }

    public void setPublisher(@NotNull String publisher) {
        this.publisher = publisher;
    }

    public @NotNull String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(@NotNull String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public @NotNull ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(@NotNull ArrayList<String> tags) {
        this.tags = tags;
    }
}