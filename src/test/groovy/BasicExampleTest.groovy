import com.medidata.MyGroovyClass
import com.medidata.MyJavaClass
import spock.lang.Specification

class BasicExampleTest extends Specification {

    def "assert"() {
        given:
        def mySetup = "setup"

        expect:
        mySetup == "setup"
    }

    def "given when then"() {
        given:
        def groovy = new MyGroovyClass()

        when:
        groovy.value = "banana"

        then:
        groovy.value == "banana"
    }

    def "this fails - nice output"() {
        given:
        def java = new MyJavaClass()

        expect:
        java.value == "HEl1o W0rld"
    }

    def "chained failure - nice output"() {
        given:
        def solarSystems = [name: "solar system", planets: ["mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune"]]

        expect:
        solarSystems.planets[3] == "earth"
    }

}
