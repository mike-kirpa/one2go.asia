package myproject.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by mike on 30.08.2017.
 */
public class SearchResultPage extends AbstractPage {
    private String pageTitle = "Noi Bai Airport to Pattaya @ flight";
    private By checkout = By.linkText("Checkout!");
    private By priceBlock = By.className("trip-ticket-total");
    private By priceValue = By.className("price");
    private By buyBtn =  By.className("buy-button-text");


    public SearchResultPage(WebDriver driver) {
        super(driver);
        waitForPageLoad(driver);
    }

    public PaymentPage buyCheapTicket(){
        List<WebElement> priceList = driver.findElements(priceBlock);
        WebElement minPriceWebElement = null;
        int minPrice = 0;
        for (WebElement value : priceList){
            int x = Integer.parseInt(value.findElement(priceValue).getText().replaceAll("[^0-9]",""));
            if(minPrice == 0) {minPrice = x; minPriceWebElement = value;}
            if(minPrice>x) {minPrice = x; minPriceWebElement = value;}
        }
        minPriceWebElement.findElement(buyBtn).click();
        driver.findElement(checkout).click();
        return new PaymentPage(driver);
    }

    private void waitForPageLoad(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.titleContains(pageTitle));
    }

}
