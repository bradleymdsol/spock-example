import geb.spock.GebReportingSpec

class GebExampleTest extends GebReportingSpec {


    def "bbc new homepage"(){
        to BbcNewsHomePage

        when:
        menu.world.click()

        then:
        title == "World - BBC News"
    }

    def "dynamic content"(){
        to BbcNewsHomePage

        when:
        mostWatched.click()

        then:
        waitFor {
            mostPopular.text().contains('I killed too many to count')
        }
    }


}
