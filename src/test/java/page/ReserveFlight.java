package page;

import com.codeborne.selenide.Condition;

import org.openqa.selenium.By;
import utility.TestUtilities;


import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.CollectionCondition.*;


public class ReserveFlight {
    private Integer flightToBeSelected = 0;

    public void verifyFlightsAvailable(String departureCity, String destinationCity){
        $(By.cssSelector("div.container>h3")).shouldHave(
                Condition.text("Flights from " + departureCity + " to " + destinationCity + ": "));
        $$(By.cssSelector("div.container tbody tr")).shouldHave(size(5));
    }

    public Map<String, String> getSelectedFlightDetails() {
        this.flightToBeSelected = TestUtilities.getRandomNumberInRange(1, 5);

        Map<String, String> reservedFlightDetails = new HashMap<>();
        reservedFlightDetails.put("flightCode",
                $(By.cssSelector("div.container tr:nth-of-type(" + flightToBeSelected + ")" +
                        " td:nth-of-type(2)")).getText());
        reservedFlightDetails.put("airline",
                $(By.cssSelector("div.container tr:nth-of-type(" + flightToBeSelected + ")" +
                        " td:nth-of-type(3)")).getText());
        reservedFlightDetails.put("departureTime",
                $(By.cssSelector("div.container tr:nth-of-type(" + flightToBeSelected + ")" +
                        " td:nth-of-type(4)")).getText());
        reservedFlightDetails.put("arrivalTime",
                $(By.cssSelector("div.container tr:nth-of-type(" + flightToBeSelected + ")" +
                        " td:nth-of-type(5)")).getText());
        reservedFlightDetails.put("ticketPrice",
                $(By.cssSelector("div.container tr:nth-of-type(" + flightToBeSelected + ")" +
                        " td:nth-of-type(6)")).getText());

        return reservedFlightDetails;
    }

    public BookFlight selectFlight(){
        $(By.cssSelector("div.container tr:nth-of-type(" + flightToBeSelected + ")" +
                " input[value='Choose This Flight']")).click();

        return page(BookFlight.class);
    }

}
