import com.medidata.Composed
import com.medidata.Composer
import spock.lang.IgnoreRest
import spock.lang.Specification

class MockExampleTest extends Specification {
    def composed = Mock(Composed)
    def composed2 = Mock(Composed)
    def writer = Mock(PrintWriter)

    def composer = new Composer(composed, composed2, writer)

//    @IgnoreRest
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

    def "verify types"(){
        when:
        composer.executeLots();

        then:
        5 * composed2.run() //or
        (3..7) * composed2.run() // 3 to 7 times
        (3.._) * composed2.run() // 3 or more times
        _ * composed2.run() // any time
        1 * _.run() // any mock
        1 * composed2./r.*n/() // call method matching pattern
        1 * _._ // call anything
        1 * _ // shorthand
        0 * _ // add for strict mocking
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

    def "sequence of values"(){
        given:
        composed.run() >>> ["Hello", "Everyone"]

        when:
        composer.writeMore()

        then:
        1 * writer.write("Hello")
        1 * writer.write("Everyone")
    }

}
