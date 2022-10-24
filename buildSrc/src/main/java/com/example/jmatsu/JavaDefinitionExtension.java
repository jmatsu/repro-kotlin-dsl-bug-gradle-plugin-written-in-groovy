package com.example.jmatsu;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;

public class JavaDefinitionExtension {
    private final Project project;
    private final NamedDomainObjectContainer<JavaDefinition> definitions;

    JavaDefinitionExtension(Project project) {
        this.project = project;
        this.definitions = project.container(JavaDefinition.class);
    }

    public NamedDomainObjectContainer<JavaDefinition> getDefinitions() {
        return definitions;
    }
}
