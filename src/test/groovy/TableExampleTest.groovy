import com.medidata.MyJavaClass
import spock.lang.Specification
import spock.lang.Unroll

class TableExampleTest extends Specification {

    def "table where"() {
        given:
        def java = new MyJavaClass()

        when:
        def actual = java.square(number)

        then:
        actual == expected

        where:
        number | expected
        2      | 4
        3      | 9
        4      | 16
        5      | 25

    }

    def "table where input/output"() {
        given:
        def java = new MyJavaClass()

        when:
        def actual = java.multiply(a, b)

        then:
        actual == result

        where:
        a | b  || result
        2 | 2  || 4
        3 | 5  || 15
        4 | 3  || 12
        9 | 10 || 90

    }

    @Unroll
    def "unroll table where"() {
        given:
        def java = new MyJavaClass()

        when:
        def actual = java.multiply(a, b)

        then:
        actual == result

        where:
        a | b  || result
        2 | 2  || 4
        3 | 5  || 15
        4 | 3  || 12
        9 | 10 || 90

    }


}
