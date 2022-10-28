package com.example.jmatsu;

import org.gradle.api.Action;
import org.gradle.api.Named

@groovy.transform.CompileStatic
class GroovyDefinition implements Named {
    private final String name;

    public String param;

    GroovyDefinition(String name) {
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }

    void anyLambda(Action<String> builder) {
        builder.execute("hello");
    }
}
