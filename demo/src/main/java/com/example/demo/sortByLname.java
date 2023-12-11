package com.example.demo;

import java.util.Comparator;

public class sortByLname implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getLastname().compareTo(o2.getLastname());
    }
}
