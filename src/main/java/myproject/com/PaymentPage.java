package myproject.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PaymentPage extends AbstractPage {
    private String pageTitle = "Trip Itinerary & Payment — 12Go Asia";
    private By mobilePhoneField = By.id("contact[mobile]");
    private String mobileNumber = "+380669311635";
    private String email = "ivan.petrov@gmail.com";
    private By emailField = By.id("contact[email]");
    private String fullNameValue = "Ivan Petrov";
    private By fullNameField = By.id("passenger[0][full_name]");
    private By daySelect = By.id("passenger[0][dob][day]");
    private By monthSelect = By.id("passenger[0][dob][month]");
    private By yearSelect = By.id("passenger[0][dob][year]");
    private By passportField = By.id("passenger[0][id_no]");
    private By countrySelect = By.id("passenger[0][country_id]");
    private String dayValue = "10";
    private String monthValue = "April";
    private String yearValue = "2017";
    private String countryValue = "Turkey";
    private String passportValue = "CA673467";
    private By pickUpTimeSelect = By.className("time");
    private String pickUpTimeValue = "14:00 PM";
    private By numberOfLuggageSelect = By.className("number_luggage");
    private String numberOfLuggageValue = "2";
    private By airlineField = By.className("airline");
    private String airlineValue = "UML";
    private By airFlightNumberField = By.className("flight_no");
    private String airFlightNumberValue = "FK437";
    private By flightArrivalTimeFiled = By.className("flight_arr_time");
    private String flightArrivalTimeValue = "13:00 PM";
    private By addressField = By.className("comment");
    private String addressValue = "some address";
    private By termsCheckbox = By.name("misc[terms]");
    private By cancelationCheckbox = By.name("misc[cancelation_policy]");
    private By confirmtripCheckbox = By.name("misc[confirm_trip]");
    private By cardNumberFiled = By.name("number");
    private String cardNumberValue = "4444444444444448";
    private By cardholderNameFiled = By.name("name");
    private String cardholderNameValue = "Ivan Petrov";
    private By expireCardFiled = By.name("expiry");
    private String expireCardValue = "09/19";
    private By cvcFiled = By.name("cvc");
    private String cvcValue = "123";
    private By payBtn = By.className("btn-pay");



    public PaymentPage(WebDriver driver){
        super(driver);
        waitForPageLoad(driver);
    }

    public TicketPage itineraryPayment(){
        driver.findElement(mobilePhoneField).sendKeys(mobileNumber);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(fullNameField).sendKeys(fullNameValue);
        new Select(driver.findElement(daySelect)).selectByVisibleText(dayValue);
        new Select(driver.findElement(monthSelect)).selectByVisibleText(monthValue);
        new Select(driver.findElement(yearSelect)).selectByVisibleText(yearValue);
        new Select(driver.findElement(countrySelect)).selectByVisibleText(countryValue);
        driver.findElement(passportField).sendKeys(passportValue);
        new Select(driver.findElement(pickUpTimeSelect)).selectByVisibleText(pickUpTimeValue);
        driver.findElement(airlineField).sendKeys(airlineValue);
        new Select(driver.findElement(numberOfLuggageSelect)).selectByVisibleText(numberOfLuggageValue);
        driver.findElement(airFlightNumberField).sendKeys(airFlightNumberValue);
        new Select(driver.findElement(flightArrivalTimeFiled)).selectByVisibleText(flightArrivalTimeValue);
        driver.findElement(addressField).sendKeys(addressValue);
        driver.findElement(termsCheckbox).click();
        driver.findElement(cancelationCheckbox).click();
        driver.findElement(confirmtripCheckbox).click();
        driver.findElement(cardNumberFiled).sendKeys(cardNumberValue);
        driver.findElement(cardholderNameFiled).sendKeys(cardholderNameValue);
        driver.findElement(expireCardFiled).sendKeys(expireCardValue);
        driver.findElement(cvcFiled).sendKeys(cvcValue);
        driver.findElement(payBtn).click();
        return new TicketPage(driver);
    }

    private void waitForPageLoad(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.titleContains(pageTitle));
    }
}
