package myproject.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketPage extends AbstractPage{
    private String pageTitle = "Ticket — 12Go Asia";
    private By successBuy = By.className("alert-success");
    private String successBuyText = "Thank you for payment!";

    public TicketPage(WebDriver driver){
            super(driver);
            waitForPageLoad(driver);
        }

    public String isSuccessBuy(){

        return driver.findElement(successBuy).getText();
    }

    public String getSuccessBuyText() {
        return successBuyText;
    }

    private void waitForPageLoad(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
        webDriverWait.until(ExpectedConditions.titleContains(pageTitle));
    }
}
