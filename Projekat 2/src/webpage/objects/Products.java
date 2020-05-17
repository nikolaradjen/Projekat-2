package webpage.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import excel_and_txt.TxtUtils;

public class Products {

	public static final String PRODUCT_BTN = TxtUtils.readLocator("PRODUCT_BTN");
	public static final String ADD_NEW_PRODUCT_BTN = TxtUtils.readLocator("ADD_NEW_PRODUCT_BTN");
	public static final String PRODUCT_NAME_FIELD = TxtUtils.readLocator("PRODUCT_NAME_FIELD");
	public static final String PRODUCT_ID_FIELD = TxtUtils.readLocator("PRODUCT_ID_FIELD");
	public static final String SHORT_DESCRIPTION_FIELD = TxtUtils.readLocator("SHORT_DESCRIPTION_FIELD");
	public static final String LONG_DESCRIPTION_FIELD = TxtUtils.readLocator("LONG_DESCRIPTION_FIELD");
	public static final String PRICE_FIELD =  TxtUtils.readLocator("PRICE_FIELD");
	public static final String APPROVED_URL_FIELD =  TxtUtils.readLocator("APPROVED_URL_FIELD");
	public static final String SAVE_CHANGES_BTN = TxtUtils.readLocator("SAVE_CHANGES_BTN");
	public static final String PRODUCT_COUNT = TxtUtils.readLocator("PRODUCT_COUNT");
	public static final String EDIT_PRODUCT_TAB =  TxtUtils.readLocator("EDIT_PRODUCT_TAB");
	public static final String SAVE_PRODUCT_CHANGE =  TxtUtils.readLocator("SAVE_PRODUCT_CHANGE");

	public static void clickOnProductTab(WebDriver driver) {
		driver.findElement(By.xpath(PRODUCT_BTN)).click();
	}

	public static void clickOnAddNewProductBtn(WebDriver driver) {
		driver.findElement(By.xpath(ADD_NEW_PRODUCT_BTN)).click();
	}

	public static void enterProductName(WebDriver driver, String productName) {
		driver.findElement(By.xpath(PRODUCT_NAME_FIELD)).click();
		driver.findElement(By.xpath(PRODUCT_NAME_FIELD)).sendKeys(productName);
	}

	public static void enterProductID(WebDriver driver, String productID) {
		driver.findElement(By.xpath(PRODUCT_ID_FIELD)).click();
		driver.findElement(By.xpath(PRODUCT_ID_FIELD)).sendKeys(productID);
	}

	public static void enterShortDescription(WebDriver driver, String shortDescription) {
		driver.findElement(By.xpath(SHORT_DESCRIPTION_FIELD)).click();
		driver.findElement(By.xpath(SHORT_DESCRIPTION_FIELD)).sendKeys(shortDescription);
	}

	public static void enterLongDescription(WebDriver driver, String longDescription) {
		driver.findElement(By.xpath(LONG_DESCRIPTION_FIELD)).click();
		driver.findElement(By.xpath(LONG_DESCRIPTION_FIELD)).sendKeys(longDescription);
	}

	public static void enterPrice(WebDriver driver, String price) {
		driver.findElement(By.xpath(PRICE_FIELD)).click();
		driver.findElement(By.xpath(PRICE_FIELD)).sendKeys(price);
	}

	public static void enterApprovedURL(WebDriver driver, String url) {
		driver.findElement(By.xpath(APPROVED_URL_FIELD)).click();
		driver.findElement(By.xpath(APPROVED_URL_FIELD)).sendKeys(url);
	}

	public static void clickSaveChanges(WebDriver driver) {
		driver.findElement(By.xpath(SAVE_CHANGES_BTN)).click();
	}

	public static void clickEditProducts(WebDriver driver) {
		driver.findElement(By.xpath(EDIT_PRODUCT_TAB)).click();
	}

	public static void clickSaveProductChangesBtn(WebDriver driver) {
		driver.findElement(By.xpath(SAVE_PRODUCT_CHANGE)).click();
	}

}
