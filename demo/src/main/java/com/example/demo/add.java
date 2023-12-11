package com.example.demo;

import org.springframework.stereotype.Service;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class add {
    List<String> ids = new ArrayList<>();
    public void addStudent(List<User> userList) {
        try {
            File file = new File("C:\\Users\\Mido\\IdeaProjects\\Soa Assignment\\student.xml");
            Document document;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            if (file.exists()) {
                document = dBuilder.parse(file);
            }
            else {
                document = dBuilder.newDocument();
                Element root = document.createElement("University");
                document.appendChild(root);
            }
            Element root = document.getDocumentElement();
            for (User user : userList) {
                if (ids.contains(user.getId()))
                    continue ;
                ids.add(user.getId()) ;
                Element student = document.createElement("Student");
                root.appendChild(student);

                Attr attr = document.createAttribute("ID");
                attr.setValue(user.getId());
                student.setAttributeNode(attr);

                Element firstName = document.createElement("FirstName");
                firstName.appendChild(document.createTextNode(user.getFirstname()));
                student.appendChild(firstName);

                Element lastName = document.createElement("LastName");
                lastName.appendChild(document.createTextNode(user.getLastname()));
                student.appendChild(lastName);

                Element gender = document.createElement("Gender");
                gender.appendChild(document.createTextNode(user.getGender()));
                student.appendChild(gender);

                Element gpa = document.createElement("GPA");
                gpa.appendChild(document.createTextNode(user.getGpa()));
                student.appendChild(gpa);

                Element level = document.createElement("Level");
                level.appendChild(document.createTextNode(user.getLevel()));
                student.appendChild(level);

                Element address = document.createElement("Address");
                address.appendChild(document.createTextNode(user.getAddress()));
                student.appendChild(address);
            }


            DOMSource source = new DOMSource(document);
            Result result = new StreamResult(file);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

        }
        catch (ParserConfigurationException | TransformerException | IOException | SAXException e) {
            Logger.getLogger(indexController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
