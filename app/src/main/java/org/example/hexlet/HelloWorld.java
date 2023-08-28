package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringEscapeUtils;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HelloWorld {

    public static List<Course> courses =  Data.getCourses();
    public static String error = null;
    public static void main(String[] args) {
        getApp().start(7070);
    }

    public static Javalin getApp() {
        Javalin app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/", ctx -> {
           ctx.render("layout/page.jte");
        });

        app.get("/courses", ctx -> {
            String header = "Курсы по программированию";
            String term = ctx.queryParam("term");
            List<Course> filteredCourses = null;
            if (term != null) {
                filteredCourses = courses.stream()
                        .filter(c -> c.getName().contains(term))
                        .toList();
            }
            var page = new CoursesPage(filteredCourses == null ? courses : filteredCourses, header, term);
            ctx.render("index.jte", Collections.singletonMap("page", page));
        });

        app.get("/courses/new", ctx -> {
            ctx.render("new.jte", Collections.singletonMap("error", error));
        });

        app.post("/courses", ctx -> {
            String name = null;
            String description = ctx.formParam("description");

            try {
                name = ctx.formParamAsClass("name", String.class)
                        .check(value -> !value.isEmpty() || !value.isBlank(), "Name field cannot be empty")
                        .get();
            } catch (ValidationException e) {
                error = e.toString();
                ctx.redirect("/courses/new");
            }
            Course course = new Course(Data.getNextId(), name, description);
            Data.save(course);
            ctx.redirect("/courses");
        });

        app.get("/courses/{id}", ctx -> {
            long id = Long.parseLong(ctx.pathParam("id"));
            Course course = courses.stream()
                    .filter(c -> c.getId() == id)
                    .findFirst().get();
            ctx.render("show.jte", Collections.singletonMap("course", course));
        });

        app.get("/getMyId/{id}", ctx -> {
            String id = ctx.pathParam("id");
//            ctx.contentType("html");
//            ctx.result(id);
            var escapedId = StringEscapeUtils.escapeHtml4(id);
            ctx.contentType("text/html");
            ctx.result(escapedId);
        });

        return app;
    }
}