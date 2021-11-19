package fileWriter;

import gameLibrary.Game;
import org.jetbrains.annotations.NotNull;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GamesWriter implements Writer {

    @Override
    public void write(@NotNull Object object, @NotNull String filePath) throws IOException, XMLStreamException {
        ArrayList<Game> games = (ArrayList<Game>) object;

        XMLOutputFactory output = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = output.createXMLStreamWriter(new FileOutputStream(filePath), "UTF-8");

        writer.writeStartDocument("utf-8", "1.0");
        writer.writeStartElement("library");
        for (int i = 0; i < games.size(); i++) {
            writeGame(writer, games.get(i), i);
        }
        writer.writeEndElement();

        writer.writeEndDocument();
        writer.flush();
    }

    private void writeGame(@NotNull XMLStreamWriter writer, @NotNull Game game, int id) throws XMLStreamException {
        writer.writeStartElement("game");
        writer.writeAttribute("id", String.valueOf(id));

        writer.writeStartElement("name");
        writer.writeCharacters(game.getName());
        writer.writeEndElement();

        writer.writeStartElement("developer");
        writer.writeCharacters(game.getDeveloper());
        writer.writeEndElement();

        writer.writeStartElement("publisher");
        writer.writeCharacters(game.getPublisher());
        writer.writeEndElement();

        writer.writeStartElement("releaseDate");
        writer.writeCharacters(game.getReleaseDate());
        writer.writeEndElement();

        writeTags(writer, game);

        writer.writeEndElement();
    }

    private void writeTags(@NotNull XMLStreamWriter writer, @NotNull Game game) throws XMLStreamException {
        writer.writeStartElement("tags");
        for (String tag : game.getTags()) {
            writer.writeStartElement("tag");
            writer.writeCharacters(tag);
            writer.writeEndElement();
        }
        writer.writeEndElement();
    }
}