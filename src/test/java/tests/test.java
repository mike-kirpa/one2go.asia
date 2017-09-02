package tests;

import myproject.com.HomePage;
import myproject.com.PaymentPage;
import myproject.com.SearchResultPage;
import myproject.com.TicketPage;
import myproject.com.utils.Property;
import org.testng.Assert;
import org.testng.annotations.Test;


public class test extends BaseTest {

    private HomePage homePage;

    @Test(description = "Покупка билета")
    public void openHomePage(){
        driver.navigate().to(Property.getUrls("base.url"));
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchPage = homePage.searchTrip();
        PaymentPage paymentpage = searchPage.buyCheapTicket();
        TicketPage ticketPage = paymentpage.itineraryPayment();
        Assert.assertTrue(ticketPage.isSuccessBuy().contains(ticketPage.getSuccessBuyText()));
    }
}
