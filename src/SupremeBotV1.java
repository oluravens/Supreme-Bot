import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SupremeBotV1 {

	private static ArrayList<String> dataList = new ArrayList<String>();

	/**
	 * Imports the data fields into a list from the data file
	 * adds fields to global ArrayList dataList
	 */
	public static void importDataFromFile() {

		File data = new File("data.txt");

		try{
			Scanner dataScanner = new Scanner(data);

			while(dataScanner.hasNextLine()) {
				dataList.add(dataScanner.nextLine());
			}

			dataScanner.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Logs in to google in order to pass Captcha
	 * to do- make work
	 */
	public static void loginToGoogle(WebDriver driver) {
		
		String username = dataList.get(0);
		String password = dataList.get(1);
		
		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    
	    driver.findElement(By.name("identifier")).sendKeys(username);
	    driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
	    driver.findElement(By.name("password")).sendKeys(password);
	    
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Next')]")));
	    element.click();

	}

	/**
	 * Uses the WebDriver to navigate to the Supreme web site and use inputed fields to get to checkout with desired item
	 *to do- allow checkout of multiple items
	 */
	public static void checkoutSupremeItem(WebDriver driver) {

		//fields needed for finding objects
		String category = dataList.get(14);
		String keyword = dataList.get(15);

		//form fields
		String name = dataList.get(2);
		String email = dataList.get(3);
		String telNumber = dataList.get(4);
		String address = dataList.get(5); 
//	        String aptUnit = dataList.get(6);
		String zip = dataList.get(7);
//	        String city = dataList.get(8);
//	        String state = dataList.get(9);
		String credit = dataList.get(10);
		String creditMonth = dataList.get(11);
		String creditYear = dataList.get(12);
		String cvv = dataList.get(13);

		// launch Chrome and direct it to the Base URL
		String baseUrl = "https://www.supremenewyork.com/shop/all";
		driver.get(baseUrl);

		if(category.equals("jackets")) {
			driver.get(baseUrl + "/jackets");
		}
		else if(category.equals("shirts")) {
			driver.get(baseUrl + "/shirts");
		}
		else if(category.equals("teeshirts")) {
			driver.get(baseUrl + "/t-shirts");
		}
		else if(category.equals("tops") || category.equals("sweaters")) {
			driver.get(baseUrl + "/tops_sweaters");
		}
		else if(category.equals("sweatshirts")) {
			driver.get(baseUrl + "/sweatshirts");
		}
		else if(category.equals("pants")){
			driver.get(baseUrl + "/pants");
		}
		else if(category.equals("hats")) {
			driver.get(baseUrl + "/hats");
		}
		else if(category.equals("bags")) {
			driver.get(baseUrl + "/bags");
		}
		else if(category.equals("skate")){
			driver.get(baseUrl + "/skate");
		}
		else if(category.equals("accessories")) {
			driver.get(baseUrl + "/accessories");
		}

		driver.findElement(By.partialLinkText(keyword)).click();

		String currentLink = driver.getCurrentUrl();
		driver.get(currentLink);

		WebElement AddToCart = driver.findElement(By.name("commit"));
		AddToCart.click();

		//to do: fix it not going to checkout 100% of the time
		driver.get("https://www.supremenewyork.com/checkout");
		driver.get("https://www.supremenewyork.com/checkout");

		//ENTERING CHECKOUT INFO
		//name and address info
		WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"order_billing_name\"]"));
		nameInput.sendKeys(name);        

		WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"order_email\"]"));
		emailInput.sendKeys(email);

		WebElement phoneInput = driver.findElement(By.xpath("//*[@id=\"order_tel\"]"));
		phoneInput.sendKeys(telNumber);

		WebElement addressInput = driver.findElement(By.xpath("//*[@id=\"bo\"]"));
		addressInput.sendKeys(address);

//	        WebElement aptInput = driver.findElement(By.xpath("//*[@id=\"address_row\"]/div[2]"));
//	        aptInput.sendKeys(aptUnit);

		WebElement zipInput = driver.findElement(By.xpath("//*[@id=\"order_billing_zip\"]"));
		zipInput.sendKeys(zip);

//	        WebElement cityInput = driver.findElement(By.xpath("//*[@id=\"order_billing_city\"]"));
//	        cityInput.sendKeys(city);

		WebElement cardNumInput = driver.findElement(By.xpath("//*[@id=\"nnaerb\"]"));
		cardNumInput.sendKeys(credit);


		//credit card input
		WebElement cvvInput = driver.findElement(By.xpath("//*[@id=\"orcer\"]"));
		cvvInput.sendKeys(cvv);

		Select creditMonthDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"credit_card_month\"]")));
		creditMonthDropdown.selectByVisibleText(creditMonth); 

		Select creditYearDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"credit_card_year\"]")));
		creditYearDropdown.selectByVisibleText(creditYear);

		//clicks the check box
		WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"cart-cc\"]/fieldset/p[2]/label/div"));
		checkBox.click();

		//final checkout button
		driver.findElement(By.name("commit")).click();

		//		driver.quit();
	}

	public static void main(String[] args) {

		String rootProjectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", rootProjectPath + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		importDataFromFile();
		//loginToGoogle(driver);
		checkoutSupremeItem(driver);

	}

}
