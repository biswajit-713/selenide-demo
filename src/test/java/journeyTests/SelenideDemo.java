package journeyTests;

import org.junit.*;
import page.*;
import selenideTestBase.SelenideTestBase;

import java.util.Map;
import static com.codeborne.selenide.Selenide.open;

public class SelenideDemo extends SelenideTestBase{

    @Ignore
    @Test
    public void shouldBeAbleToBookFlight(){
        ReserveFlight reserveFlight = SearchFlight.findFlightBetweenCities("Paris", "London");
        reserveFlight.verifyFlightsAvailable("Paris", "London");
        Map<String, String> flightDetails = reserveFlight.getSelectedFlightDetails();
        BookFlight bookFlight = reserveFlight.selectFlight();
        bookFlight.verifyFlightDetails(flightDetails);
    }

    @Ignore
    @Test
    public void dummyTest(){
        assert 1==2;
    }

    @Test
    public void checkoutProductOnPDP(){
        HomePage homePage = open("/", HomePage.class);
        ProductListingPage plp = homePage.navigateToWomenDresses();
        plp.selectOrangeDress();
    }
}
