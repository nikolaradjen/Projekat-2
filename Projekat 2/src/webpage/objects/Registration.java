package webpage.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import excel_and_txt.TxtUtils;

public class Registration {

	public static final String HOME_URL = TxtUtils.readLocator("HOME_URL");
	public static final String SIGN_UP_BTN = TxtUtils.readLocator("SIGN_UP_BTN");
	public static final String REG_USERNAME_FIELD = TxtUtils.readLocator("REG_USERNAME_FIELD");
	public static final String REG_EMAIL_FIELD = TxtUtils.readLocator("REG_EMAIL_FIELD");
	public static final String REG_PASSWORD_FIELD = TxtUtils.readLocator("REG_PASSWORD_FIELD");
	public static final String REG_CONFIRM_PASSWORD_FIELD = TxtUtils.readLocator("REG_CONFIRM_PASSWORD_FIELD");
	public static final String REG_ABOUT_FIELD = TxtUtils.readLocator("REG_ABOUT_FIELD");
	public static final String REG_SUBMIT_BTN = TxtUtils.readLocator("REG_SUBMIT_BTN");
	public static final String LOGIN_USERNAME = TxtUtils.readLocator("LOGIN_USERNAME");
	public static final String LOGIN_PASSWORD = TxtUtils.readLocator("LOGIN_PASSWORD");
	public static final String LOGIN_BTN = TxtUtils.readLocator("LOGIN_BTN");
	public static final String ACC_BTN = TxtUtils.readLocator("ACC_BTN");
	public static final String LOGOUT_BTN = TxtUtils.readLocator("LOGOUT_BTN");

	public static void goToWebSite(WebDriver driver) {
		driver.get(HOME_URL);
	}

	public static void enterLoginUsername(WebDriver driver, String username) {
		driver.findElement(By.xpath(LOGIN_USERNAME)).click();
		driver.findElement(By.xpath(LOGIN_USERNAME)).sendKeys(username);
	}

	public static void enterLoginPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath(LOGIN_PASSWORD)).click();
		driver.findElement(By.xpath(LOGIN_PASSWORD)).sendKeys(password);
	}

	public static void clickLoginBtn(WebDriver driver) {
		driver.findElement(By.xpath(LOGIN_BTN)).click();
	}

	public static void clickSignUp(WebDriver driver) {
		driver.findElement(By.xpath(SIGN_UP_BTN)).click();

	}

	public static void enterRegUsername(WebDriver driver, String username) {
		driver.findElement(By.xpath(REG_USERNAME_FIELD)).click();
		driver.findElement(By.xpath(REG_USERNAME_FIELD)).sendKeys(username);
	}

	public static void enterRegPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath(REG_PASSWORD_FIELD)).click();
		driver.findElement(By.xpath(REG_PASSWORD_FIELD)).sendKeys(password);
	}

	public static void confirmRegPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath(REG_CONFIRM_PASSWORD_FIELD)).click();
		driver.findElement(By.xpath(REG_CONFIRM_PASSWORD_FIELD)).sendKeys(password);
	}

	public static void enterRegEmail(WebDriver driver, String email) {
		driver.findElement(By.xpath(REG_EMAIL_FIELD)).click();
		driver.findElement(By.xpath(REG_EMAIL_FIELD)).sendKeys(email);
	}

	public static void selectRegAboutMe(WebDriver driver, String about) {
		WebElement about_menu = driver.findElement(By.xpath(REG_ABOUT_FIELD));
		Select select = new Select(about_menu);
		select.selectByVisibleText(about);
		about_menu.click();

	}

	public static void clickRegSubmit(WebDriver driver) {
		driver.findElement(By.xpath(REG_SUBMIT_BTN)).click();
	}
	
	public static void clickLogout (WebDriver driver) {
		driver.findElement(By.xpath(ACC_BTN)).click();
		driver.findElement(By.xpath(LOGOUT_BTN)).click();
	}

}
