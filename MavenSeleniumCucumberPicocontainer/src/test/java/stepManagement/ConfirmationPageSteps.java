package stepManagement;

import org.junit.Assert;

import com.MavenSeleniumCucumberPicocontainer.Context;
import com.MavenSeleniumCucumberPicocontainer.TextContext;

import io.cucumber.java.en.Then;
import pages.ConfirmationPage;

public class ConfirmationPageSteps {
	TextContext testContext;
	 ConfirmationPage confirmationPage;
	 
	 public ConfirmationPageSteps(TextContext context) {
	 testContext = context;
	 confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
	 }
	 
	 @Then("^verify the order details$")
	 public void verify_the_order_details(){
	 String productName = (String)testContext.scenarioContext.getContext(Context.PRODUCT_NAME);
	 Assert.assertTrue(confirmationPage.getProductNames().stream().filter(x -> x.contains(productName)).findFirst().get().length()>0); 
	 }
}
