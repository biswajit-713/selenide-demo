package selenideTestBase;

import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CustomeWebDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");

        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}
