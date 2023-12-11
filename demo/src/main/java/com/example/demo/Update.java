package com.example.demo;
import java.util.List;


public class Update {
    delete delete = new delete() ;

    public List<User> updateStudent(List<User> users, String id, String fname, String lname, String gen, String gp, String lev, String addr) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                if (!fname.equals("")) {
                    user.setFirstname(fname);
                }
                if (!lname.equals("")) {
                    user.setLastname(lname);
                }
                if (!gen.equals("")) {
                    user.setGender(gen);
                }
                if (!gp.equals("")) {
                    user.setGpa(gp);
                }
                if (!lev.equals("")) {
                    user.setLevel(lev);
                }
                if (!addr.equals("")) {
                    user.setAddress(addr);
                }
            }
        }
        delete.updateXmlFile(users);
        return users;
    }

}

