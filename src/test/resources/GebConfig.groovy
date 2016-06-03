import org.openqa.selenium.firefox.FirefoxDriver

waiting {
    timeout = 2
}

driver = { new FirefoxDriver() }

reportsDir = new File("target/geb-reports")

