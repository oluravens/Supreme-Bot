package bot;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class SupremeBotV1 {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver","C:\\\\selenium-3.14.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		File data = new File("D:\\eclipse\\workspace\\Supreme Bot\\src\\data");
		ArrayList<String> dataList = new ArrayList<String>();
        
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
		        
		//fields needed for finding objects
		String category = dataList.get(0);
		String keyword = dataList.get(1);
		
        //form fields
        String name = dataList.get(2);
        String email = dataList.get(3);
        String telNumber = dataList.get(4);
        String address = dataList.get(5); 
//        String aptUnit = dataList.get(6);
        String zip = dataList.get(7);
//        String city = dataList.get(8);
//        String state = dataList.get(9);
        String credit = dataList.get(10);
        String creditMonth = dataList.get(11);
        String creditYear = dataList.get(12);
        String cvv = dataList.get(13);
        
        // launch Chrome and direct it to the Base URL
        String baseUrl = "https://www.supremenewyork.com/shop/all";
        driver.get(baseUrl);
        
        if(dataList.equals("jackets")) {
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
        
        
        //System.out.println("Enter a keyword: ");
       // keyword = input.nextLine();
        
        if(keyword.length() > 0) {
        	driver.findElement(By.partialLinkText(keyword)).click();
        }
        
        String currentLink = driver.getCurrentUrl();
        driver.get(currentLink);
        		
		WebElement AddToCart = driver.findElement(By.name("commit"));
//		  WebElement AddToCart = driver.findElement(By.id("cart-controls-add"));
//        WebElement AddToCart = driver.findElement(By.xpath("//input[@name='commit']"));
//        List<WebElement> buttons = driver.findElements(By.className("button"));
//        WebElement AddToCart = buttons.get(0);
        AddToCart.click();
        
        driver.get("https://www.supremenewyork.com/checkout");
        driver.get("https://www.supremenewyork.com/checkout");

        
        //ENTERING CHECKOUT INFO
        //name and address info
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"order_billing_name\"]"));
        nameInput.click();
        nameInput.sendKeys(name);        
        
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"order_email\"]"));
        emailInput.click();
        emailInput.sendKeys(email);
        
        WebElement phoneInput = driver.findElement(By.xpath("//*[@id=\"order_tel\"]"));
        phoneInput.click();
        phoneInput.sendKeys(telNumber);
        
        WebElement addressInput = driver.findElement(By.xpath("//*[@id=\"bo\"]"));
        addressInput.click();
        addressInput.sendKeys(address);
        
//        WebElement aptInput = driver.findElement(By.xpath("//*[@id=\"address_row\"]/div[2]"));
//        aptInput.click();
//        aptInput.sendKeys(aptUnit);
        
        WebElement zipInput = driver.findElement(By.xpath("//*[@id=\"order_billing_zip\"]"));
        zipInput.click();
        zipInput.sendKeys(zip);
      
//        WebElement cityInput = driver.findElement(By.xpath("//*[@id=\"order_billing_city\"]"));
//        cityInput.click();
//        cityInput.sendKeys(city);
        
        WebElement cardNumInput = driver.findElement(By.xpath("//*[@id=\"nnaerb\"]"));
        cardNumInput.click();
        cardNumInput.sendKeys(credit);
        
        
        //credit card input
        WebElement cvvInput = driver.findElement(By.xpath("//*[@id=\"orcer\"]"));
        cvvInput.click();
        cvvInput.sendKeys(cvv);
        
		Select creditMonthDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"credit_card_month\"]")));
		creditMonthDropdown.selectByVisibleText(creditMonth);
		
		Select creditYearDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"credit_card_year\"]")));
		creditYearDropdown.selectByVisibleText(creditYear);
		
		//clicks the check box
		driver.findElement(By.xpath("//*[@id=\"order_terms\"]")).click();
		
		driver.quit();
       
    }

}
