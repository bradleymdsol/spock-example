import geb.Module
import geb.Page

class BbcNewsHomePage extends Page {
    static url = "http://news.bbc.co.uk"

    static at = { title == "Home - BBC News" }

    static content = {
        menu { $(".navigation-wide-list").module(MenuModule) }
        mostWatched { $("#most-popular__tab-2") }
        mostPopular { $("#comp-most-popular") }
    }

}

class MenuModule extends Module {
    static content = {
        world { $("li a", text: 'World') }
    }
}
