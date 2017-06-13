package serenity.poc.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@DefaultUrl("http://www.google.com")
public class GooglePage extends PageObject {

    @FindBy(name="q")
    private WebElement search;

	@Step("When I search for {0}")
    public void searchFor(String keywords) {
        search.sendKeys(keywords, Keys.ENTER);
        waitFor(titleContains("Recherche Google"));
    }
	
	@Step("Then the title should be {0}")
	public void checkTitle(String title) {
        assertThat(getTitle(), is(equalTo(title)));
	}
	
}

