package com.example.jmatsu;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project

class GroovyDefinitionExtension {
    private final Project project;
    private final NamedDomainObjectContainer<GroovyDefinition> definitions;

    GroovyDefinitionExtension(Project project) {
        this.project = project;
        this.definitions = project.container(GroovyDefinition.class);
    }

    NamedDomainObjectContainer<GroovyDefinition> getDefinitions() {
        return definitions;
    }
}
