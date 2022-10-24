plugins {
    id("com.android.application")
    id("com.example.jmatsu.groovy")
    id("com.example.jmatsu.java")
}

android {
    compileSdkVersion(33)

    defaultConfig {
        applicationId = "com.example.ktscheck"
        minSdkVersion(16)
        targetSdkVersion(33)
        versionCode = 1
    }

}

groovySample {
    definitions {
        create("ok1") {
            anyLambda {
                "any processing you want"
            }
        }

        create("ok2") {
            param = "${file("if you touch some built-in api")}"

            anyLambda {
                "$project: here also needs to touch built-in api"
            }
        }

        // AGP 4.1.2 × Gradle 6.7.1 -> NG
        // AGP 4.1.2 × Gradle 6.8 -> OK
        // AGP 4.2.0 × Gradle 6.7.1 -> OK
//        create("fail") {
//            param = "${file("if you touch some built-in api")}"
//
//            anyLambda {
//                "without built-in api call"
//            }
//        }
    }
}

javaSample {
    definitions {
        create("ok1") {
            anyLambda {
                "any processing you want"
            }
        }

        create("ok2") {
            param = "${file("if you touch some built-in api")}"

            anyLambda {
                "$project: here also needs to touch built-in api"
            }
        }

        create("ok3") {
            param = "${file("if you touch some built-in api")}"

            anyLambda {
                "without built-in api call"
            }
        }
    }
}