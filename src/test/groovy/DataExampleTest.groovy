import groovy.json.JsonSlurper
import spock.lang.Specification

class DataExampleTest extends Specification {


    def "xml assertion"() {
        given:
        def xml = """
                    <xml>
                        <persons>
                            <person>
                                <name>Jim</name>
                            </person>
                        </persons>
                    </xml>
                   """

        when:
        def result = slurpXml(xml)

        then:
        result.persons.person[0].name.text() == "Jim"
    }

    def "xml assertion fails"() {
        given:
        def xml = """
                    <xml>
                        <persons>
                            <person>
                                <name>Harry</name>
                            </person>
                            <person>
                                <name>Jim</name>
                            </person>
                        </persons>
                    </xml>
       """

        when:
        def result = slurpXml(xml)

        then:
        result.persons.person[0].name.text() == "Jim"
    }

    def "json assertion"() {
        given:
        def json = """
        {
            "persons" : [
                {
                    "name": "Jim"
                }
            ]
        }
        """

        when:
        def result = slurpJson(json)

        then:
        result.persons[0].name == "Jim"
    }

    def "json failure"() {
        given:
        def json = """
        {
            "persons" : [
                {
                    "name": "Harry"
                },
                {
                    "name": "Jim"
                }
            ]
        }
        """

        when:
        def result = slurpJson(json)

        then:
        result.persons[0].name == "Jim"
    }


    def slurpJson(String xml) {
        new JsonSlurper().parseText(xml)
    }

    def slurpXml(String xml) {
        new XmlSlurper().parseText(xml)
    }

}
