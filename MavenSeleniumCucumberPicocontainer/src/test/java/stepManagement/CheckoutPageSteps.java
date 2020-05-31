package stepManagement;

import com.MavenSeleniumCucumberPicocontainer.TextContext;

import fileReaderManagement.FileReaderManager;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pojoJavaClasses.Customer;

public class CheckoutPageSteps {
	TextContext testContext;
	CheckoutPage checkoutPage;
	
	public CheckoutPageSteps(TextContext context) {
		testContext = context;
		checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
	}
	
	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page(){
		checkoutPage.fill_PersonalDetails();	
	}
	
	@When("^select same delivery address$")
	public void select_same_delivery_address(){
		checkoutPage.check_ShipToDifferentAddress(false);
	}
	
	@When("^select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_payment(String arg1){
		checkoutPage.select_PaymentMethod("CheckPayment");
	}

	@When("^place the order$")
	public void place_the_order() {
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.clickOn_PlaceOrder();		
		testContext.getWebDriverManager().closeDriver();
	}
	
	/*@When("^enter \\\"(.*)\\\" personal details on checkout page$")
	public void enter_personal_details_on_checkout_page(String customerName){
		Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
		checkoutPage.fill_PersonalDetails(customer);	
	}*/
}
