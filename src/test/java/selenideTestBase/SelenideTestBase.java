package selenideTestBase;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.TestTearDownRule;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTestBase{
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    @Rule
    public TestTearDownRule ruleOnFailure = new TestTearDownRule();

    @BeforeClass
    public static void setUpClass(){
        Configuration.browser = "Chrome";
        WebDriverRunner.setWebDriver(new CustomeWebDriverProvider().createDriver(null));
        Configuration.reportsFolder = "test-results/reports/" + Configuration.browser;

        timeout = 5000;
        collectionsTimeout = 5000;
        baseUrl = "http://automationpractice.com/index.php";
        startMaximized = true;
        browserSize = "1368x768";
    }

    @Before
    public void setUp(){
//        open("/");
    }


    @After
    public void tearDown(){
    }
}
