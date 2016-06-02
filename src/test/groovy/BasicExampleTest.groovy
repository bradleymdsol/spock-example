import com.medidata.MyJavaClass
import spock.lang.Specification

class BasicExampleTest extends Specification {

    def "assert"(){
        given:
        def mySetup = "setup"

        expect:
        mySetup == "setup"
    }


    def "given when then"(){
        given:
        
    }

    def "can test java"(){
        given:
        def java = new MyJavaClass()

        expect:
        java.value == "Hello World!"
        java.getValue() == "Hello World!"
    }

    def "this fails"(){
        given:
        def java = new MyJavaClass()

        expect:
        java.value == "HEl1o W0rld"
    }


}
