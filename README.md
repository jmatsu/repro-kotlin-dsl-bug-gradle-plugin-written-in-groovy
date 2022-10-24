As for Kotlin DSL, A build function that take an Action interface may fail in some cases if it's originally written in Groovy.

```gradle
groovySample { // Not a lambda of Action
  definitions { // Not a lambda of Action
    param = "${file("calling built-in function causes a weired behaviour!")}"

    anyLambda { // Action!
      "hello~"
    }
  }
}
```

# Show cases

The following code does not cause any issue.

```gradle
groovySample {
  definitions {
    anyLambda {
      "hello~"
    }
  }
}
```

The following code produces an error. We could sometimes see similar error messages with old Kotlin like 1.2 or lower if receivers of the lambda are ambiguous.

```gradle
groovySample {
  definitions {
    anyLambda {
      "hello~"
    }
  }
}

// =>
* What went wrong:
Build_gradle$2$1$3
> Build_gradle$2$1$3
```

This behaviour depends on Gradle.

| Language | Gradle Version | Result |
|:---|:---|:---|:---|
| Java | 5.6-5.8 | Success |
| Java | 5.7.1- | Success |
| Groovy | 5.6-5.7.1 | Fail |
| Groovy | 5.8- | Success |
| Groovy | 5.7.1- | Success |

And also, this behaviour seems to be affected by a runtime configuration.

| Language | Android Gradle Plugin | Result |
|:---|:---|:---|:---|
| Groovy | 4.1.x | 5.7.1 | Fail |
| Groovy | 4.2.x | 5.7.1- | Success |

# Table

| Language | Android Gradle Plugin | Gradle Version | Result |
|:---|:---|:---|:---|
| Java | 4.1.x | 5.6-5.8 | Success |
| Java | 4.2.x | 5.7.1- | Success |
| Groovy | 4.1.x | 5.6-5.7.1 | Fail |
| Groovy | 4.1.x | 5.8- | Success |
| Groovy | 4.2.x | 5.7.1- | Success |
