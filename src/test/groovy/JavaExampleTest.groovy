import com.medidata.MyJavaClass
import spock.lang.Specification

class JavaExampleTest extends Specification {


    def "can test java"() {
        given:
        def java = new MyJavaClass()

        expect:
        java.value == "Hello World!"
        java.getValue() == "Hello World!"
    }

}
