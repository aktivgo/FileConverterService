package fileReader;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class GamesReader implements FileReader{

    public GamesReader(){};

    @Override
    public void read(String fileName) {
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse(fileName);

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            System.out.println("List of games:");
            System.out.println();
            // Просматриваем все подэлементы корневого - т.е. игры
            NodeList games = root.getChildNodes();
            for (int i = 0; i < games.getLength(); i++) {
                Node game = games.item(i);
                // Если нода не текст, то это игра - заходим внутрь
                if (game.getNodeType() != Node.TEXT_NODE) {
                    NodeList gameProperties = game.getChildNodes();
                    for(int j = 0; j < gameProperties.getLength(); j++) {
                        Node gameProperty = gameProperties.item(j);
                        // Если нода не текст, то это один из параметров игры - печатаем
                        if (gameProperty.getNodeType() != Node.TEXT_NODE) {
                            if (gameProperty.getNodeName().equals("tags")) {
                                System.out.print(gameProperty.getNodeName() + ": ");
                                NodeList tags = gameProperty.getChildNodes();
                                for (int z = 0; z < tags.getLength(); z++) {
                                    Node tag = tags.item(z);
                                    if (tag.getNodeType() != Node.TEXT_NODE) {
                                        System.out.print(tag.getTextContent() + ", ");
                                    }
                                }
                                System.out.println();
                            } else {
                                System.out.println(gameProperty.getNodeName() + ": " + gameProperty.getTextContent());
                            }
                        }
                    }
                    System.out.println("===========>>>>");
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}