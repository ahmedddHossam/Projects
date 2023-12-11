package com.example.demo;

import java.util.Comparator;

public class sortByGpa implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getGpa().compareTo(o2.getGpa());
    }
}
