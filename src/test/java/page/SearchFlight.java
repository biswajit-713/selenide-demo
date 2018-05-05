package page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.refresh;


public class SearchFlight {
    public static ReserveFlight findFlightBetweenCities(String departureCity, String destinationCity){
        $(By.name("fromPort")).selectOptionByValue(departureCity);
        $(By.name("toPort")).selectOptionByValue(destinationCity);
        $(By.cssSelector("input[value='Find Flights']")).click();

        return page(ReserveFlight.class);
    }
}
