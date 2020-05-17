package webpage.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import excel_and_txt.TxtUtils;
import webpage.objects.Registration;

public class RegistrationTest {

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
	
	@AfterClass
	public void close() {
		driver.quit();
	}

	// this is test for trying to log in without registering first

	@Test
	public void logInWithoutReg() {
		String username = "blablabla";
		String password = "Blabla123";

		Registration.goToWebSite(driver);
		Registration.enterLoginUsername(driver, username);
		Registration.enterLoginPassword(driver, password);
		Registration.clickLoginBtn(driver);

		String current = driver.getCurrentUrl();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(current, "https://sandbox.2checkout.com/sandbox/login");
		sa.assertAll();
		

	}
	// this is test for trying to log in without username

	@Test
	public void logInWithoutUsername() {
		String username = "";
		String password = "Blabla123";

		Registration.goToWebSite(driver);
		Registration.enterLoginUsername(driver, username);
		Registration.enterLoginPassword(driver, password);
		Registration.clickLoginBtn(driver);

		String current = driver.getCurrentUrl();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(current, "https://sandbox.2checkout.com/sandbox/login");
		sa.assertAll();
	}

	// this is test for trying to log in without password

	@Test
	public void logInWithoutPassword() {
		String username = "blablabla";
		String password = "";

		Registration.goToWebSite(driver);
		Registration.enterLoginUsername(driver, username);
		Registration.enterLoginPassword(driver, password);
		Registration.clickLoginBtn(driver);

		String current = driver.getCurrentUrl();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(current, "https://sandbox.2checkout.com/sandbox/login");
		sa.assertAll();

	}

	//// this is test for trying to log in without username and password

	@Test
	public void logInWithoutUsernameAndPassword() {
		String username = "";
		String password = "";

		Registration.goToWebSite(driver);
		Registration.enterLoginUsername(driver, username);
		Registration.enterLoginPassword(driver, password);
		Registration.clickLoginBtn(driver);

		String current = driver.getCurrentUrl();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(current, "https://sandbox.2checkout.com/sandbox/login");
		sa.assertAll();
	}

	// this is test for registering one user

	@Test
	public void userRegistration() {
		String username = "nikolani";
		String password = "Nikola123";
		String email = "dadadada@sharklasers.com";
		String about = "I don't have a website";

		Registration.goToWebSite(driver);
		Registration.clickSignUp(driver);
		Registration.enterRegUsername(driver, username);
		Registration.enterRegEmail(driver, email);
		Registration.enterRegPassword(driver, password);
		Registration.confirmRegPassword(driver, password);
		Registration.selectRegAboutMe(driver, about);
		Registration.clickRegSubmit(driver);

		String current = driver.getCurrentUrl();
		String expected = "https://sandbox.2checkout.com/sandbox/home/dashboard";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(current, expected);
		sa.assertAll();
		Registration.clickLogout(driver);
	}

	@Test

	// this is test for loging one user

	public void checkLogin() {
		String username = "nikolani";
		String password = "Nikola123";
		Registration.goToWebSite(driver);
		Registration.enterLoginUsername(driver, username);
		Registration.enterLoginPassword(driver, password);
		Registration.clickLoginBtn(driver);
		String current = driver.getCurrentUrl();
		String expected = "https://sandbox.2checkout.com/sandbox/home/dashboard";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(current, expected);
		sa.assertAll();
		Registration.clickLogout(driver);
		
		
	}

	// trying to registers without entering username

	@Test
	public void userRegWithoutUsername() {
		String password = "Nikola123";
		String email = "dadadada@sharklasers.com";
		String about = "I don't have a website";

		Registration.goToWebSite(driver);
		Registration.clickSignUp(driver);
		Registration.enterRegEmail(driver, email);
		Registration.enterRegPassword(driver, password);
		Registration.confirmRegPassword(driver, password);
		Registration.selectRegAboutMe(driver, about);
		Registration.clickRegSubmit(driver);

		String current = driver.getCurrentUrl();
		String expected = "https://sandbox.2checkout.com/sandbox/signup";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(current, expected);
		sa.assertAll();

	}

	// trying to registers without entering password
	@Test
	public void userRegWithoutPassword() {
		String username = "nikolanid";
		String password = "Nikola123";
		String email = "dadadada@sharklasers.com";
		String about = "I don't have a website";

		Registration.goToWebSite(driver);
		Registration.clickSignUp(driver);
		Registration.enterRegUsername(driver, username);
		Registration.enterRegEmail(driver, email);
		Registration.confirmRegPassword(driver, password);
		Registration.selectRegAboutMe(driver, about);
		Registration.clickRegSubmit(driver);

		String current = driver.getCurrentUrl();
		String expected = "https://sandbox.2checkout.com/sandbox/signup";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(current, expected);
		sa.assertAll();
	}

	// trying to registers without entering password confirmation

	@Test
	public void userRegWithoutPasswordConfirm() {
		String username = "nikolanid";
		String password = "Nikola123";
		String email = "dadadada@sharklasers.com";
		String about = "I don't have a website";

		Registration.goToWebSite(driver);
		Registration.clickSignUp(driver);
		Registration.enterRegUsername(driver, username);
		Registration.enterRegEmail(driver, email);
		Registration.enterRegPassword(driver, password);
		Registration.selectRegAboutMe(driver, about);
		Registration.clickRegSubmit(driver);

		String current = driver.getCurrentUrl();
		String expected = "https://sandbox.2checkout.com/sandbox/signup";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(current, expected);
		sa.assertAll();
	}

	// trying to registers without entering email adress

	@Test
	public void userRegWithoutEmail() {
		String username = "nikolanid";
		String password = "Nikola123";
		String about = "I don't have a website";

		Registration.goToWebSite(driver);
		Registration.clickSignUp(driver);
		Registration.enterRegUsername(driver, username);
		Registration.enterRegPassword(driver, password);
		Registration.confirmRegPassword(driver, password);
		Registration.selectRegAboutMe(driver, about);
		Registration.clickRegSubmit(driver);

		String current = driver.getCurrentUrl();
		String expected = "https://sandbox.2checkout.com/sandbox/signup";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(current, expected);
		sa.assertAll();
	}

	// trying to registers without selecting about me

	@Test
	public void userRegWithoutAboutMe() {
		String username = "nikolanid";
		String password = "Nikola123";
		String email = "dadadada@sharklasers.com";

		Registration.goToWebSite(driver);
		Registration.clickSignUp(driver);
		Registration.enterRegUsername(driver, username);
		Registration.enterRegEmail(driver, email);
		Registration.enterRegPassword(driver, password);
		Registration.confirmRegPassword(driver, password);
		Registration.clickRegSubmit(driver);

		String current = driver.getCurrentUrl();
		String expected = "https://sandbox.2checkout.com/sandbox/signup";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(current, expected);
		sa.assertAll();
	}
}
