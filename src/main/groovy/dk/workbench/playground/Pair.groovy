package dk.workbench.playground

import groovy.transform.CompileStatic

/**
 * This code does not work with versions "6.28.0" -> "7.0.5" of the org.openrewrite.rewrite Gradle plugin
 * Fixed by this commit https://github.com/openrewrite/rewrite/pull/4950
 */

@CompileStatic
class Pair {

    String first
    String second

    Pair() {
        first = 'John'
        second = 'Doe'
    }

    Pair(String first, String second) {
        this.first = first
        this.second = second
    }

}
