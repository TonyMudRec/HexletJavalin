package org.example.hexlet;

import lombok.Getter;
import org.example.hexlet.model.Course;

import java.util.List;
import java.util.ArrayList;

public class Data {
    private static final int ITEMS_COUNT = 30;

    @Getter
    private static List<Course> courses = new ArrayList<>();

    private static int idCounter = ITEMS_COUNT;

//    public static List<Course> getCourses() {
//
////        for (int i = 1; i < ITEMS_COUNT; i++) {
////            Long id = (long) (i);
////            String name = "Course " + i;
////            String description = "description for course " + i;
////            Course course = new Course(id, name, description);
////            courses.add(course);
////        }
//
//        return courses;
//    }
    
    public static void save(Course course) {
        courses.add(course);
    }

    public static Long getNextId() {
        return (long) ++idCounter;
    }
}