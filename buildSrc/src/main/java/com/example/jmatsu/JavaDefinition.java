package com.example.jmatsu;

import org.gradle.api.Action;
import org.gradle.api.Named;

public class JavaDefinition implements Named {
    private final String name;

    public String param;

    public JavaDefinition(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void anyLambda(Action<String> builder) {
        builder.execute("hello");
    }
}
