package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        getApp().start(7070); // Стартуем веб-сервер
    }

    public static Javalin getApp() {
        Javalin app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        app.get("/hello", ctx -> {
            String name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello, " + name + "!");
        });
        app.get("users/{id}/post/{postId}", ctx -> {
            int id = ctx.pathParamAsClass("id", Integer.class).getOrDefault(1);
            int postId = ctx.pathParamAsClass("postId", Integer.class).getOrDefault(1);
            ctx.result("Id = " + id + "\n" + "Post Id = " + postId);
        });

        return app;
    }
}