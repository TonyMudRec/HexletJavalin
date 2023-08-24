package org.example.hexlet;

import io.javalin.Javalin;
import org.apache.commons.lang3.StringEscapeUtils;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

import java.util.Collections;
import java.util.List;

public class HelloWorld {

    public static List<Course> courses =  Data.getCourses();
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
            var header = "Курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("index.jte", Collections.singletonMap("page", page));
        });
        app.get("/courses/{id}", ctx -> {
            var id = Long.valueOf(ctx.pathParam("id"));
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