import com.medidata.ExpensiveResource
import com.medidata.MyJavaClass
import spock.lang.Shared
import spock.lang.Specification

class FixturesExampleTest extends Specification {

    @Shared
    static ExpensiveResource expensive = new ExpensiveResource()
    static MyJavaClass justOnce
    MyJavaClass eachTest

    // run before the first feature method
    def setupSpec() {
        justOnce = new MyJavaClass()
    }

    // run before every feature method
    def setup() {
        eachTest = new MyJavaClass()
    }

    def "test"() {
        expect:
        true
    }

    // run after every feature method
    def cleanup() {
        eachTest.clean()
    }

    // run after the last feature method
    def cleanupSpec() {
        justOnce.clean()
    }

}
