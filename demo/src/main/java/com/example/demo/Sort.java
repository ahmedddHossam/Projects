package com.example.demo;

import java.util.Collections;
import java.util.List;

public class Sort {
    delete delete = new delete();
    public List<User> sortXmlFile (List<User>users, String sortField, String sortOrder ) {
        System.out.println("Sort Field: " + sortField);
        System.out.println("Sort Order: " + sortOrder);
        if (sortOrder.equals("ascending")){
            System.out.println("condition 1 entered");
            if (sortField.equals("ID")){
                System.out.println("second condition entered");
                Collections.sort(users,new sortByID());
            }
            else if (sortField.equals("First Name")){
                Collections.sort(users,new sortByFname());
            }
            else if (sortField.equals("Last Name")){
                Collections.sort(users,new sortByLname());
            }
            else if (sortField.equals("GPA")){
                Collections.sort(users,new sortByGpa());
            }
            else if (sortField.equals("Level")){
                Collections.sort(users,new sortByLevel());
            }
        }
        else {
            if (sortField.equals("ID")){
                Collections.sort(users,new sortByID());
                Collections.reverse(users);
            }
            else if (sortField.equals("First Name")){
                Collections.sort(users,new sortByFname());
                Collections.reverse(users);
            }
            else if (sortField.equals("Last Name")){
                Collections.sort(users,new sortByLname());
                Collections.reverse(users);
            }
            else if (sortField.equals("GPA")){
                Collections.sort(users,new sortByGpa());
                Collections.reverse(users);
            }
            else if (sortField.equals("Level")){
                Collections.sort(users,new sortByLevel());
                Collections.reverse(users);
            }
        }
        delete.updateXmlFile(users);
        return users ;
    }
}
