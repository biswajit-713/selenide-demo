package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.page;


public class HomePage {
    public ProductListingPage navigateToWomenDresses(){
        $(By.cssSelector("div#block_top_menu a[title='Women']")).click();
        return page(ProductListingPage.class);
    }
}
