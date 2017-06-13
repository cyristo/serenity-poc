package serenity.poc.at;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import serenity.poc.pageobjects.GooglePage;

@RunWith(SerenityRunner.class)
public class GoogleTest {

	private String searchString = "data outdoor";
	
	private static String x = System.setProperty("webdriver.chrome.driver","D:\\Dev\\chromedriver.exe");
	
	@Managed(driver="chrome")
	private WebDriver driver;
	
	@Steps
    private GooglePage googlePage;
	
	@Test
    public void shouldHaveProperTitlePage() {

    	//Given I open the browser
        googlePage.open();

        //When I search for "data outdoor"
        googlePage.searchFor(searchString);

        //Then the page tile should be "data outdoor - Recherche Google"
        googlePage.checkTitle(searchString + " - Recherche Google");

    }

}
