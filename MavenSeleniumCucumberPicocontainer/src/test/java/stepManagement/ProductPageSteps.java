package stepManagement;

import com.MavenSeleniumCucumberPicocontainer.TextContext;

import cucumber.api.java.en.When;
import pages.ProductListingPage;

public class ProductPageSteps {
	TextContext testContext;
	ProductListingPage productListingPage;
	
	public ProductPageSteps(TextContext context) {
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		productListingPage.select_Product(0);
		productListingPage.clickOn_AddToCart();		
	}
}
