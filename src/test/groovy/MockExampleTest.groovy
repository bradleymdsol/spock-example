import com.medidata.Composed
import com.medidata.Composer
import spock.lang.Specification

class MockExampleTest extends Specification {
    def composed = Mock(Composed)
    def composed2 = Mock(Composed)
    def writer = Mock(PrintWriter)

    def composer = new Composer(composed, composed2, writer)

    def "verify"(){
        when:
        composer.execute();

        then:
        1 * composed.run()
    }

    def "verify no interaction"(){
        when:
        composer.execute();

        then:
        0 * composed2.run() //or
        0 * composed2._
    }

    def "verify multiple times"(){
        when:
        composer.executeLots();

        then:
        5 * composed2.run() //or
    }

    def "failure"(){
        when:
        composer.execute();

        then:
        0 * composed.run()
    }

    def "stubbing"(){
        given:
        composed.run() >> "Hello"

        when:
        composer.write()

        then:
        1 * writer.write("Hello")
    }

}
