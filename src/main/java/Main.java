import fileConverter.XmlToJson;
import org.jetbrains.annotations.NotNull;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String @NotNull [] args) throws IOException, ParserConfigurationException, SAXException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Некорректное количество аргументов");
        }

        XmlToJson converter = new XmlToJson();
        converter.convert(args[0], args[1]);
        System.out.println("Преобразование прошло успешно, результат сохранен в файл " + args[1]);
    }
}