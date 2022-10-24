plugins {
    id("com.example.jmatsu.groovy")
    id("com.example.jmatsu.java")
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

        create("fail") {
            param = "${file("if you touch some built-in api")}"

            anyLambda {
                "without built-in api call"
            }
        }
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