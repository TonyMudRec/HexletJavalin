package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        getApp().start(7070); // Стартуем веб-сервер
    }

    public static Javalin getApp() {
        return Javalin.create(config -> {
            config.plugins.enableDevLogging();
        })
                .get("/hello", ctx -> {
                    String name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
                    ctx.result("Hello, " + name + "!");
                });
    }
}