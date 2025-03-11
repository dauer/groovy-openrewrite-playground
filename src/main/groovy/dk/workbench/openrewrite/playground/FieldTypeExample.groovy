package dk.workbench.openrewrite.playground

import groovy.xml.slurpersupport.GPathResult
import groovy.xml.XmlSlurper

class FieldTypeExample {

    /**
     * Works from version 7.1.5
     * This was not triggered because of the missing type, adding a 'def' or 'XmlSlurper' would fix the problem and
     * trigger the update:
     *     static def slurper = new XmlSlurper()
     *         or
     *     static XmlSlurper slurper = new XmlSlurper()
     * There is a CodeNarc rule to catch this:
     *     https://codenarc.org/codenarc-rules-convention.html#fieldtyperequired-rule
     */
    static slurper = new XmlSlurper()

    GPathResult fooBar() {
        return slurper.parseText('<data><message>Hello world!</message></data>')
    }

}