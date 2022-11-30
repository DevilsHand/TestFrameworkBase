package test.core.web.enums;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import test.core.logger.LogWritter;

public enum DriverTypeFactory {
    GECKO_DRIVER("webDriver/geckodriver", "webdriver.gecko.driver"),
    CHROME_DRIVER("webDriver/chromedriver", "webdriver.chrome.driver"),
    WIN_GECKO_DRIVER("webDriver/geckodriver.exe", "webdriver.gecko.driver"),
    WIN_CHROME_DRIVER("webDriver/chromedriver.exe", "webdriver.chrome.driver");

    private DriverTypeFactory(String path, String proprerty) {
        this.path = path;
        this.property = proprerty;
    }
    private String path;
    private String property;

    public static WebDriver getDriver(DriverTypeFactory typeFactory) {
        System.setProperty(typeFactory.property, typeFactory.path);
        WebDriver driver = null;
        try {
            switch (typeFactory) {
                case GECKO_DRIVER:
                case WIN_GECKO_DRIVER:
                    driver = new FirefoxDriver();
                    break;
                case CHROME_DRIVER:
                case WIN_CHROME_DRIVER:
                    driver = new ChromeDriver();
                    break;
            }
        } catch (Exception e) {
            LogWritter.getLogger().error(e.getMessage());
        }
        return driver;
    }
}
