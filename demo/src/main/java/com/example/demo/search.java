package com.example.demo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class search {
    private List<User>users ;
    private int cnt ;

    public search (List<User>users , int cnt ) {
        this.users = users ;
        this.cnt = cnt ;
    }

    public List<User> getUsers() {
        return users;
    }

    public int getCnt() {
        return cnt;
    }

    public static search searchUsers(String id, String firstname, String lastname, String gender, String gpa, String level, String address) {
        List<User> searchResults = new ArrayList<>();
        List<String> ids = new ArrayList<>() ;

        try {
            File file = new File("C:\\Users\\Mido\\IdeaProjects\\Soa Assignment\\student.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(file);

            NodeList nodeList = document.getElementsByTagName("Student");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    if (gpa != null && !gpa.isEmpty()) {
                        String studentGPA = element.getElementsByTagName("GPA").item(0).getTextContent();
                        if (studentGPA.equals(gpa) ) {
                            User obj = getUserFromXmlElement(element);
                            if (ids.contains(obj.getId())) {
                                continue;
                            }
                            searchResults.add(obj);
                            ids.add(obj.getId());
                        }
                    }

                    if (firstname != null && !firstname.isEmpty()) {
                        String studentFirstName = element.getElementsByTagName("FirstName").item(0).getTextContent();
                        if (studentFirstName.equals(firstname)) {
                            User obj = getUserFromXmlElement(element);
                            if (ids.contains(obj.getId())) {
                                continue;
                            }
                            searchResults.add(obj);
                            ids.add(obj.getId());
                        }
                    }

                    if (lastname != null && !lastname.isEmpty()) {
                        String studentLastName = element.getElementsByTagName("LastName").item(0).getTextContent();
                        if (studentLastName.equals(lastname)) {
                            User obj = getUserFromXmlElement(element);
                            if (ids.contains(obj.getId())) {
                                continue;
                            }
                            searchResults.add(obj);
                            ids.add(obj.getId());
                        }
                    }

                    if (id != null && !id.isEmpty()) {
                        String studentID = element.getAttribute("ID");
                        if (studentID.equals(id)) {
                            User obj = getUserFromXmlElement(element);
                            if (ids.contains(obj.getId())) {
                                continue;
                            }
                            searchResults.add(obj);
                            ids.add(obj.getId());
                        }
                    }

                    if (gender != null && !gender.isEmpty()) {
                        String studentGender = element.getElementsByTagName("Gender").item(0).getTextContent();
                        if (studentGender.equals(gender)) {
                            User obj = getUserFromXmlElement(element);
                            if (ids.contains(obj.getId())) {
                                continue;
                            }
                            searchResults.add(obj);
                            ids.add(obj.getId());
                        }
                    }

                    if (level != null && !level.isEmpty()) {
                        String studentLevel = element.getElementsByTagName("Level").item(0).getTextContent();
                        if (studentLevel.equals(level)) {
                            User obj = getUserFromXmlElement(element);
                            if (ids.contains(obj.getId())) {
                                continue;
                            }
                            searchResults.add(obj);
                            ids.add(obj.getId());
                        }
                    }

                    if (address != null && !address.isEmpty()) {
                        String studentAddress = element.getElementsByTagName("Address").item(0).getTextContent();
                        if (studentAddress.equals(address)) {
                            User obj = getUserFromXmlElement(element);
                            if (ids.contains(obj.getId())) {
                                continue;
                            }
                            searchResults.add(obj);
                            ids.add(obj.getId());
                        }
                    }
                }
            }
        }
        catch (ParserConfigurationException | IOException | SAXException e) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, e);
        }

        return new search(searchResults,searchResults.size());
    }

    private static User getUserFromXmlElement(Element element) {
        User user = new User();
        user.setId(element.getAttribute("ID"));
        user.setFirstname(element.getElementsByTagName("FirstName").item(0).getTextContent());
        user.setLastname(element.getElementsByTagName("LastName").item(0).getTextContent());
        user.setGender(element.getElementsByTagName("Gender").item(0).getTextContent());
        user.setGpa(element.getElementsByTagName("GPA").item(0).getTextContent());
        user.setLevel(element.getElementsByTagName("Level").item(0).getTextContent());
        user.setAddress(element.getElementsByTagName("Address").item(0).getTextContent());
        return user;
    }


}

