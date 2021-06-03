import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        CatHandler catHandler = new CatHandler();
        File catsXML = new File("src/cats.xml");

        parser.parse(catsXML, catHandler);

        for (Cat cat : Cat.cats) {
            System.out.println(cat);
        }

    }
}
