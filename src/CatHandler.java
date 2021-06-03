import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CatHandler extends DefaultHandler {
    private Cat cat = null;
    private StringBuilder data = null;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("cat")){
            cat = new Cat();
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")){
            cat.setName(data.toString());
        } else if (qName.equalsIgnoreCase("age")){
            cat.setAge(Integer.parseInt(data.toString()));
        } else if (qName.equalsIgnoreCase("breed")){
            cat.setBreed(data.toString());
        } else if (qName.equalsIgnoreCase("weight")){
            cat.setWeight(Integer.parseInt(data.toString()));
        }

        if (qName.equalsIgnoreCase("cat")){
            Cat.cats.add(cat);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}
