# Groovy OpenRewrite Playground

Playing around with [OpenRewrite](https://docs.openrewrite.org) for automating [Groovy](https://groovy-lang.org/) upgrades...

This project uses a single OpenRewrite [rule](https://docs.openrewrite.org/recipes/java/changepackage) `org.openrewrite.java.ChangePackage` to test various Groovy features.

Features not working are placed in the `package dk.workbench.playground` and when OpenRewrite can parse then, they are
moved to `package dk.workbench.openrewrite.playground`.

## Open issues

---

## Fixed issues

- [Classes with constructors](./docs/classes-with-constructors.md)