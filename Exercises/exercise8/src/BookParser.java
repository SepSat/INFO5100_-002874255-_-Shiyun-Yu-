import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.StringReader;
import java.io.StringWriter;
import org.xml.sax.InputSource;





public class BookParser {

    public static void main(String[] args) {
        try {
            String xmlData = readFileToString("src/BookShelf.xml");; // Replace this with actual XML data or file reading logic
            String jsonData = readFileToString("src/BookShelf.json");

            // Parse XML
            parseXML(xmlData);

            // Parse JSON
            parseJSON(jsonData);

            // Add a new book entry to both XML and JSON
            String newXmlData = addBookToXML(xmlData);
            String newJsonData = addBookToJSON(jsonData);

            // Reprint the updated documents
            System.out.println("Updated XML:\n" + newXmlData);
            System.out.println("Updated JSON:\n" + newJsonData);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static void parseJSON(String jsonData) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject obj = (JSONObject) parser.parse(jsonData);
            JSONArray bookShelf = (JSONArray) obj.get("BookShelf");

            for (Object bookObject : bookShelf) {
                JSONObject book = (JSONObject) bookObject;
                System.out.println("Book Title: " + book.get("title"));
                System.out.println("Published Year: " + book.get("publishedYear"));
                System.out.println("Number of Pages: " + book.get("numberOfPages"));

                JSONArray authors = (JSONArray) book.get("authors");
                System.out.print("Authors: ");
                for (Object author : authors) {
                    System.out.print(author.toString());
                    if (!author.equals(authors.get(authors.size() - 1))) {
                        System.out.print(", ");
                    }
                }
                System.out.println("\n");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static String readFileToString(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        return contentBuilder.toString();
    }
    @SuppressWarnings("unchecked")
    private static String addBookToJSON(String jsonData) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject obj = (JSONObject) parser.parse(jsonData);
            JSONArray bookShelf = (JSONArray) obj.get("BookShelf");

            JSONObject newBook = new JSONObject();
            newBook.put("title", "New Book Title");
            newBook.put("publishedYear", 2023);
            newBook.put("numberOfPages", 500);
            JSONArray newAuthors = new JSONArray();
            newAuthors.add("New Author");
            newBook.put("authors", newAuthors);

            bookShelf.add(newBook);

            return obj.toJSONString();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static void parseXML(String xmlData) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlData)));

            NodeList bookList = document.getElementsByTagName("Book");
            for (int i = 0; i < bookList.getLength(); i++) {
                Node book = bookList.item(i);
                if (book.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) book;
                    System.out.println("Book Title: " + bookElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Published Year: " + bookElement.getElementsByTagName("publishedYear").item(0).getTextContent());
                    System.out.println("Number of Pages: " + bookElement.getElementsByTagName("numberOfPages").item(0).getTextContent());

                    NodeList authors = bookElement.getElementsByTagName("author");
                    System.out.print("Authors: ");
                    for (int j = 0; j < authors.getLength(); j++) {
                        System.out.print(authors.item(j).getTextContent());
                        if (j < authors.getLength() - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String addBookToXML(String xmlData) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlData)));

            // Create new book element
            Element newBook = document.createElement("Book");

            Element title = document.createElement("title");
            title.appendChild(document.createTextNode("New Book Title"));
            newBook.appendChild(title);

            Element year = document.createElement("publishedYear");
            year.appendChild(document.createTextNode("2023"));
            newBook.appendChild(year);

            Element pages = document.createElement("numberOfPages");
            pages.appendChild(document.createTextNode("500"));
            newBook.appendChild(pages);

            Element authors = document.createElement("authors");
            Element author = document.createElement("author");
            author.appendChild(document.createTextNode("New Author"));
            authors.appendChild(author);
            newBook.appendChild(authors);
            // Print the information of the new book
            printBookInfo(newBook);
            // Append the new book to the bookshelf
            document.getDocumentElement().appendChild(newBook);

            // Convert the updated Document back to a String
            // Note that I didn't include pretty-printing.
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));

            return writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private static void printBookInfo(Element bookElement) {
        System.out.println("Added book information: ");
        System.out.println("Book Title: " + bookElement.getElementsByTagName("title").item(0).getTextContent());
        System.out.println("Published Year: " + bookElement.getElementsByTagName("publishedYear").item(0).getTextContent());
        System.out.println("Number of Pages: " + bookElement.getElementsByTagName("numberOfPages").item(0).getTextContent());

        NodeList authors = bookElement.getElementsByTagName("author");
        System.out.print("Authors: ");
        for (int j = 0; j < authors.getLength(); j++) {
            System.out.print(authors.item(j).getTextContent());
            if (j < authors.getLength() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }

}
