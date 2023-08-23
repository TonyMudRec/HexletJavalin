package org.example.hexlet;

import java.util.Random;
import java.util.Locale;
import com.github.javafaker.Faker;
import org.example.hexlet.model.Course;

import java.util.List;
import java.util.ArrayList;

public class Data {
    private static final int ITEMS_COUNT = 30;

    private static int idCounter = ITEMS_COUNT;

    public static List<Course> getCourses() {
        Random random = new Random(123);
        Faker faker = new Faker(new Locale("en"), random);

        List<Course> courses = new ArrayList<>();

        for (int i = 0; i < ITEMS_COUNT; i++) {
            Long id = (long) (i + 1);
            String name = String.valueOf(faker.name());
            Course course = new Course(id, name, name);
            courses.add(course);
        }

        return courses;
    }

    public static String getNextId() {
        int id = ++idCounter;
        return Integer.toString(id);
    }
}