# Groovy OpenRewrite Playground

Playing around with [OpenRewrite](https://docs.openrewrite.org) for automating [Groovy](https://groovy-lang.org/) upgrades...

## Issues

---

### Classes with Constructors

> Fixed from version 7.0.6+ https://github.com/openrewrite/rewrite/pull/4950

I have a simple class [Pair](src/main/groovy/dk/workbench/playground/Pair.groovy) with a constructor but OpenRewrite
Gradle [plugin](https://docs.openrewrite.org/reference/gradle-plugin-configuration) from version `6.28.0+` fails to parse it?

Running `./gradlew rewriteDryRun` fails in parsing the class:

    > Task :rewriteDryRun
    Validating active recipes
    Scanning sources in project :
    Using active styles []
    There were problems parsing some source files, run with --info to see full stack traces
    There were problems parsing src/main/groovy/dk/workbench/playground/Pair.groovy
    All sources parsed, running active recipes: dk.workbench.openrewrite.groovy
    Applying recipes would make no changes. No report generated.

If I downgrade the OpenRewrite Gradle plugin to version `6.27.2` it works just fine:

    > Task :rewriteDryRun
    Validating active recipes
    Scanning sources in project :
    Using active styles []
    All sources parsed, running active recipes: dk.workbench.openrewrite.groovy

Generating a correct patch file `build/reports/rewrite/rewrite.patch`

    diff --git a/src/main/groovy/dk/workbench/playground/Pair.groovy b/src/main/groovy/dk/workbench/openrewrite/playground/Pair.groovy
    similarity index 0%
    rename from src/main/groovy/dk/workbench/playground/Pair.groovy
    rename to src/main/groovy/dk/workbench/openrewrite/playground/Pair.groovy
    index 971ee02..d6a6d47 100644
    --- a/src/main/groovy/dk/workbench/playground/Pair.groovy
    +++ b/src/main/groovy/dk/workbench/openrewrite/playground/Pair.groovy
    @@ -1,4 +1,4 @@ dk.workbench.openrewrite.groovy
    -package dk.workbench.playground
    +package dk.workbench.openrewrite.playground

    class Pair {

The `6.28.0` version of the plugin uses OpenRewrite [8.41.0](https://github.com/openrewrite/rewrite/releases/tag/v8.41.0) which includes this
"Support Groovy declared constructors" [#4706](https://github.com/openrewrite/rewrite/pull/4706) patch that fixes this
issue "Groovy parser fails to parse constructor declarations" [#4704](https://github.com/openrewrite/rewrite/issues/4704).

But as far as I can see it introduces a new issue: OpenRewrite can no longer parse classes with constructors...
