package myproject.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private By searchFieldFrom = By.id("search_from");
    private By searchFieldTo = By.id("search_to");
    private By passengerAmount = By.id("passenger-amount");
    private By submitSearch = By.className("btn.btn-primary.btn-block");
    private By homePageTitle = By.className("page-title");
    private By nextMonth = By.className("next");
    private By dateOFCalendar = By.xpath("//table/tbody/tr[2]/td[4]");
    private By searchBtn = By.className("ticket-search-button");
    private String titleText = "Travel planning in South East Asia - buses, ferries, flights, railways";
    private String tripSearchFrom = "Noi Bai Airport";
    private String tripSearchTo = "Pattaya";
    private By listPassengerAmout = By.className("tt-dataset-tt-places");
    private String amountPerson = "1 Person";


    public HomePage(WebDriver driver) {
        super(driver);
        waitForPageLoad(driver);
    }

    public SearchResultPage searchTrip(){
        driver.findElement(searchFieldFrom).click();
        driver.findElement(searchFieldFrom).sendKeys(tripSearchFrom);
        driver.findElement(By.xpath("//span[text()='"+tripSearchFrom+"']")).click();
        driver.findElement(searchFieldTo).click();
        driver.findElement(searchFieldTo).sendKeys(tripSearchTo);
        driver.findElement(By.xpath("//span[text()='"+tripSearchTo+"']")).click();
        driver.findElement(nextMonth).click();
        driver.findElement(dateOFCalendar).click();
        driver.findElement(passengerAmount).click();
        driver.findElement(listPassengerAmout).findElement(By.xpath("//span[text()='"+amountPerson+"']")).click();
        driver.findElement(searchBtn).click();
        return new SearchResultPage(driver);
    }


    private void waitForPageLoad(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.textToBe(homePageTitle, titleText));
    }
}
