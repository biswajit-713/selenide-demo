package page;

import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class BookFlight {
    public void verifyFlightDetails(Map<String, String> flightDetails){
        Assert.assertTrue("Airline does not match",
                $(By.cssSelector("div.container p:nth-of-type(1)")).getText().contains(flightDetails.get("airline")));
        Assert.assertTrue("Flight number does not match",
                $(By.cssSelector("div.container p:nth-of-type(2)")).getText().contains(flightDetails.get("flightCode")));
        Assert.assertTrue("Price number does not match",
                $(By.cssSelector("div.container p:nth-of-type(3)")).getText().contains(flightDetails.get("ticketPrice").substring(1)));
    }
}
