package com.example.demo;

import java.util.Comparator;

public class sortByLevel implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getLevel().compareTo(o2.getLevel());
    }
}
