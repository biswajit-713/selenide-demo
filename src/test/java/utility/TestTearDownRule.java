package utility;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static com.codeborne.selenide.Selenide.screenshot;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class TestTearDownRule extends TestWatcher{
    @Override
    protected void failed(Throwable e, Description description){
        screenshot("/test-results/" + description.getClassName() + "-" +
                    description.getMethodName());
    }

    @Override
    protected void succeeded(Description description){
    }

    @Override
    protected void finished(Description description){
        closeWebDriver();
    }
}
