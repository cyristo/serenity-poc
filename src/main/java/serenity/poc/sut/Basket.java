package serenity.poc.sut;

public class Basket {
	
	private static final String BANANA_FRUIT = "banana";
	private static final String APPLE_FRUIT = "apple";
	private static final String ARTICLE_NOT_SUPPORTED_MESSAGE = "article not supported";
	private static final String WRONG_QUANTITY_MESSAGE = "wrong quantity";
	private double bananaPrice = 0;
	private double applePrice = 0;
	private double totalPrice = 0;
	private int nbBanana = 0;
	private int nbApple = 0;
    
	
	public void setPrice(String article, double price) {
		if (article.equals(BANANA_FRUIT)) {
			bananaPrice = price;
		} else if (article.equals(APPLE_FRUIT)) {
			applePrice = price;
		}
	}
	
    public void add(String article, int count) throws BasketException { 
    	if (!article.equals(BANANA_FRUIT) && !article.equals(APPLE_FRUIT)) {
    		throw new BasketException(ARTICLE_NOT_SUPPORTED_MESSAGE);
    	}
    	double price;
    	if (article.equals(BANANA_FRUIT)) {
    		price = bananaPrice;
    		nbBanana++;
    	}
		else {
			price = applePrice;
			nbApple++;
		}
    	totalPrice += (count * price);
    }
    
    public void remove(String article, int count) throws BasketException { 
    	if (!article.equals(BANANA_FRUIT) && !article.equals(APPLE_FRUIT)) {
    		throw new BasketException(ARTICLE_NOT_SUPPORTED_MESSAGE);
    	}
    	double price;
    	if (article.equals(BANANA_FRUIT)) {
    		if (nbBanana - count < 0) {
    			throw new BasketException(WRONG_QUANTITY_MESSAGE);
    		}
    		nbBanana--;
    		price = bananaPrice;
    	}
		else {
    		if (nbApple - count < 0) {
    			throw new BasketException(WRONG_QUANTITY_MESSAGE);
    		}
    		nbApple--;
			price = applePrice;
		}
    	totalPrice -= (count * price);
    }

    public double total() { 
        return totalPrice;
    }
    
}