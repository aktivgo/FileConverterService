import fileReader.GamesReader;

public class Main {
    public static void main(String[] args) {
        GamesReader reader = new GamesReader();
        reader.read("data/input/games.xml");
    }
}