package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class indexController {
    private final List<User> users = new ArrayList<>();
    add add = new add() ;
    delete delete = new delete() ;
    Update update = new Update() ;
    Sort sort = new Sort() ;
    private final List<String>ids = new ArrayList<>();
    @PostMapping("/register")
    public List<User> addStudent (@ModelAttribute User user) {
        if (!ids.contains(user.getId())) {
            users.add(user);
            ids.add(user.getId());
        }
        add.addStudent(users);
        return users;
    }
    @GetMapping("/search")
    public search searchStudent(@RequestParam(required = false) String id,
                                    @RequestParam(required = false) String firstname,
                                    @RequestParam(required = false) String lastname,
                                    @RequestParam(required = false) String gender,
                                    @RequestParam(required = false) String gpa,
                                    @RequestParam(required = false) String level,
                                    @RequestParam(required = false) String address) {

        return search.searchUsers(id,firstname,lastname,gender,gpa,level,address);
    }

    @PostMapping("/delete")
    public List<User> deleteStudent(@RequestParam String id) {
        delete.deleteStudentById(users, id);
        return users;
    }

    @PostMapping("/update")
    public List<User> updateStudent (@RequestParam String id,
                                     @RequestParam(required = false) String fname,
                                     @RequestParam(required = false) String lname,
                                     @RequestParam(required = false) String gen,
                                     @RequestParam(required = false) String gp,
                                     @RequestParam(required = false) String lev,
                                     @RequestParam(required = false) String addr) {
        return update.updateStudent(users,id,fname,lname,gen,gp,lev,addr);
    }

    @PostMapping("/sort")
    public List<User> sortXml (@RequestParam String sortField, @RequestParam String sortOrder ) {
        return sort.sortXmlFile(users,sortField,sortOrder);
    }

}



