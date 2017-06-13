package serenity.poc.at;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import serenity.poc.steps.FruitBasketSteps;

@RunWith(SerenityParameterizedRunner.class)  
public class FruitBasketTest {

	@TestData                                                   
	public static Collection<Object[]> testData(){
		
		return Arrays.asList(new Object[][]{
			{20.0, 10.0, 1, 1, 30.0},
			{20.0, 10.0, 2, 0, 40.0}
		});
	}

	private Double bananaPrice = 10.0;
	private Double applePrice = 10.0;
	private Integer bananaQuantity = 1;
	private Integer appleQuantity = 1;
	private Double totalPrice = 20.0;


	public FruitBasketTest(Double bananaPrice,
			Double applePrice,
			Integer bananaQuantity,
			Integer appleQuantity,
			Double totalPrice) { 
		this.bananaPrice = bananaPrice;
		this.applePrice = applePrice;
		this.bananaQuantity = bananaQuantity;
		this.appleQuantity = appleQuantity;
		this.totalPrice = totalPrice;
	}

	@Qualifier
    public String qualifier() {
        return "TEST ID";
    }
	@Steps
	private FruitBasketSteps fruitBasketSteps;

	@Test
	@Title("Basket checkout with bananas and apples")
	public void basketCheckoutTest() {

		//Given
		fruitBasketSteps.the_price_of_a_fruit_is("banana", bananaPrice);
		fruitBasketSteps.the_price_of_a_fruit_is("apple", applePrice);
		fruitBasketSteps.I_add_some_bananas_to_my_basket(bananaQuantity);
		fruitBasketSteps.I_add_some_apples_to_my_basket(appleQuantity);

		//When
		fruitBasketSteps.I_checkout();

		//Then
		fruitBasketSteps.the_basket_total_should_be(totalPrice);

	}

}
