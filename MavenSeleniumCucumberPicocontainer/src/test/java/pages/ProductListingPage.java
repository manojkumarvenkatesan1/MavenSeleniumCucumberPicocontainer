package pages;

import org.openqa.selenium.WebDriver;

public class ProductListingPage {
	 WebDriver driver;
	 
	 public ProductListingPage(WebDriver driver) {
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(how = How.CSS, using = "button.single_add_to_cart_button") 
	 private WebElement btn_AddToCart;
	 
	 @FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
	 private List<WebElement> prd_List; 
	 
	 public void clickOn_AddToCart() {
	 btn_AddToCart.click();
	 }
	 
	 public void select_Product(int productNumber) {
	 prd_List.get(productNumber).click();
	 }
}
