package serenity.poc.steps;

import static org.junit.Assert.*;

import net.thucydides.core.annotations.Step;
import serenity.poc.sut.Basket;
import serenity.poc.sut.BasketException;

public class FruitBasketSteps {

	private Basket basket = new Basket();
	private double total;
	
	@Step("Given the price of a {0} is {1}")
	public void the_price_of_a_fruit_is(String fruit, Double i) {
		basket.setPrice(fruit, i);
		
	}
	

	@Step("Given I add {0} bananas to my basket")
	public void I_add_some_bananas_to_my_basket(Integer i) {
		try {
			basket.add("banana", i);
		} catch (BasketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Step("Given I add {0} apples to my basket")
	public void I_add_some_apples_to_my_basket(Integer i) {
		try {
			basket.add("apple", i);
		} catch (BasketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Step("When I checkout")
	public void I_checkout() {
		total = basket.total();
		
	}

	@Step("Then the basket total should be {0}")
	public void the_basket_total_should_be(Double i) {
		assertEquals(i, total, 0);
		
	}

}
