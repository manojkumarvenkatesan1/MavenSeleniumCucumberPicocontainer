package stepManagement;

import com.MavenSeleniumCucumberPicocontainer.TextContext;

import cucumber.api.java.en.When;
import pages.CartPage;

public class CartPageSteps {
	TextContext testContext;
	CartPage cartPage;
	
	public CartPageSteps(TextContext context) {
		testContext = context;
		cartPage = testContext.getPageObjectManager().getCartPage();
	}
	
	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart(){
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();	
	}
	
}
