package com.example.jmatsu


import org.gradle.api.Plugin;
import org.gradle.api.Project;

class GroovySamplePlugin implements Plugin<Project> {

    @Override
    void apply(Project target) {
        target.getExtensions().add("groovySample", new GroovyDefinitionExtension(target));
    }
}
