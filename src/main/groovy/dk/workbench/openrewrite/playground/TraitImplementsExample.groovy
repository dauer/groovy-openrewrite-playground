package dk.workbench.openrewrite.playground

import dk.workbench.playground.TraitExample

/**
 * This code does not work with versions before 7.1.0 of the org.openrewrite.rewrite Gradle plugin
 */
class TraitImplementsExample implements TraitExample {

    void bar() {
        println "bar"
    }

}
