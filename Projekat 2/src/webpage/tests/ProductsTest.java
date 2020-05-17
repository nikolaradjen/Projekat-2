package webpage.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import excel_and_txt.ExcelUtils;
import excel_and_txt.TxtUtils;
import webpage.objects.Products;
import webpage.objects.Registration;

public class ProductsTest {

	private static WebDriver driver;
	

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/rara/Downloads/chromedriver");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@BeforeClass
	public void initializeReader() throws IOException {
		TxtUtils.initTxtReader();
	}

	// this method tests creating 5 products with data from Excel and checking if
	// they are created

	
	@AfterClass
	public void close() {
		driver.quit();
	}
	
	@Test (priority = 1)
	public void creatingProduct() throws Exception {
		String username = "nikolani";
		String password = "Nikola123";
		SoftAssert sa = new SoftAssert();
		Registration.goToWebSite(driver);
		Registration.enterLoginUsername(driver, username);
		Registration.enterLoginPassword(driver, password);
		Registration.clickLoginBtn(driver);
		for (int i = 1; i <= 5; i++) {
			Products.clickOnProductTab(driver);
			Products.clickOnAddNewProductBtn(driver);
			Products.enterProductName(driver, ExcelUtils.getCellData(i, 1));
			Products.enterProductID(driver, ExcelUtils.getCellData(i, 2));
			Products.enterShortDescription(driver, ExcelUtils.getCellData(i, 3));
			Products.enterLongDescription(driver, ExcelUtils.getCellData(i, 4));
			Products.enterPrice(driver, ExcelUtils.getCellData(i, 5));
			Products.enterApprovedURL(driver, ExcelUtils.getCellData(i, 6));
			Products.clickSaveChanges(driver);
		}
		Products.clickOnProductTab(driver);
		String catchProdCount = driver.findElement(By.xpath(Products.PRODUCT_COUNT)).getText();
		sa.assertEquals(catchProdCount, "1 - 5");
		sa.assertAll();
		Registration.clickLogout(driver);
		
	}

	// this test raises prices for products and then checks if it was raised
	@Test (priority = 2)
	public void priceChange() throws Exception {
		String username = "nikolani";
		String password = "Nikola123";
		SoftAssert sa = new SoftAssert();
		Registration.goToWebSite(driver);
		Registration.enterLoginUsername(driver, username);
		Registration.enterLoginPassword(driver, password);
		Registration.clickLoginBtn(driver);
		Products.clickOnProductTab(driver);
		Products.clickEditProducts(driver);

		for (int i = 2; i < 7; i++) {

			String num = String.valueOf(i);
			WebElement locateProduct = driver.findElement(By.xpath("//tr[" + num + "]//td[6]//input[1]"));
			String priceCurrent = locateProduct.getAttribute("value");
			double priceRaise = Double.parseDouble(priceCurrent) + 100;
			String priceUpdated = Double.toString(priceRaise);
			Actions action = new Actions(driver);
			action.doubleClick(locateProduct).sendKeys(priceUpdated).build().perform();
		}
		Products.clickSaveProductChangesBtn(driver);
		Products.clickOnProductTab(driver);
		Products.clickEditProducts(driver);

		for (int i = 2; i < 7; i++) {
			WebElement locateProduct1 = driver
					.findElement(By.xpath("//tr[" + String.valueOf(i) + "]//td[6]//input[1]"));
			String priceCurrent1 = locateProduct1.getAttribute("value");
			sa.assertEquals(priceCurrent1, ExcelUtils.getCellData(i - 1, 7));
		}
		sa.assertAll();
		Registration.clickLogout(driver);
	}

}
