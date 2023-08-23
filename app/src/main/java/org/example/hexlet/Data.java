package org.example.hexlet;

import org.example.hexlet.model.Course;

import java.util.List;
import java.util.ArrayList;

public class Data {
    private static final int ITEMS_COUNT = 30;

    private static int idCounter = ITEMS_COUNT;

    public static List<Course> getCourses() {

        List<Course> courses = new ArrayList<>();

//        for (int i = 1; i < ITEMS_COUNT; i++) {
//            Long id = (long) (i);
//            String name = "Course " + String.valueOf(i);
//            String description = "description for course " + String.valueOf(i);
//            Course course = new Course(id, name, description);
//            courses.add(course);
//        }

        return courses;
    }

    public static String getNextId() {
        int id = ++idCounter;
        return Integer.toString(id);
    }
}