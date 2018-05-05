package page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class ProductListingPage {
    public void selectOrangeDress(){
        $(By.cssSelector("h1.product-listing")).waitUntil(Condition.visible, Configuration.timeout);
        $(By.xpath("//div[@class='block_content']//a[text()='Dresses']")).click();
        $(By.cssSelector("div#enabled_filters")).waitUntil(Condition.visible, Configuration.timeout);
        $(By.partialLinkText("Orange")).click();
        String colorLabel = $(By.partialLinkText("Orange")).getText();
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(colorLabel);

        while (matcher.find()){
            assert matcher.group().equals("2") == true;
        }

        $$(By.cssSelector(".product-container")).shouldHave(CollectionCondition.size(2));
        $$(By.cssSelector(".product-container")).get(0).find(".product-name").click();
        $("#image-block").waitUntil(Condition.visible, 5000);

        //enter the buying quantity to 2 and select size as L
        $("input#quantity_wanted").val("2");
        $("#group_1").selectOption("L");

        $("p#add_to_cart button[name='Submit']").click();

        $("#layer_cart .clearfix").waitUntil(Condition.visible, 5000);
        $("#layer_cart .clearfix").find("h2").waitUntil(
                Condition.text("Product successfully added to your shopping cart"),
                1000);
        $("a[title='Proceed to checkout']").click();
        $$("a[title='Proceed to checkout']").get(1).waitUntil(Condition.visible, 2000);

    }
}
