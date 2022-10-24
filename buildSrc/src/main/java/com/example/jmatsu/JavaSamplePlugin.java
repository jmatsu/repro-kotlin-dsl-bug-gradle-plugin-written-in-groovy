package com.example.jmatsu;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class JavaSamplePlugin implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        target.getExtensions().add("javaSample", new JavaDefinitionExtension(target));
    }
}
