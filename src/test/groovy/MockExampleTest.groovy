import com.medidata.Composed
import com.medidata.Composer
import spock.lang.Specification

class MockExampleTest extends Specification {
    def composed = Mock(Composed)
    def composed2 = Mock(Composed)
    def writter = Mock(PrintWriter)

    def composer = new Composer(composed, composed2, writter)

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
        1 * writter.write("Hello")
    }

}
