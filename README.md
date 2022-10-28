As for Kotlin DSL, A build function that take an Action interface may fail depending on Gradle versions if it's originally written in Groovy.

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

This behaviour depends on Gradle -- Groovy transitively.

| Language | Gradle Version | Result |
|:---|:---|:---|
| Java | 6.6-6.8 | Success |
| Groovy | 6.6-6.7.1 | Fail |
| Groovy | 6.8- | Success |

We cannot avoid this behaviour even if we specify the distribution Groovy version.

# Conclusion

- Gradle version at runtime would cause this issue.
- Gradle plugins written in Groovy may not be reliable in some cases.
- A workaround is to use Java code for classes that provide Action interface.

