package com.example.xml_generator;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXMLFile {

    public void exportToXML(int number) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("users");
            doc.appendChild(rootElement);

            for (int i = 1; i < number+1; i++) {
                // staff elements
                Element users = doc.createElement("user");
                rootElement.appendChild(users);
                // firstname elements
                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode("name" + i));
                users.appendChild(name);
                // lastname elements
                Element surname = doc.createElement("surname");
                surname.appendChild(doc.createTextNode("surname" + i));
                users.appendChild(surname);
                // nickname elements
                Element login = doc.createElement("login");
                login.appendChild(doc.createTextNode("login" + i));
                users.appendChild(login);
            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            String home = System.getProperty("user.home");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(home+"/Downloads/"+"users"+number+".xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}