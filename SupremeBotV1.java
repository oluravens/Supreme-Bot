package ai;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SupremeBotV1 {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver","C:\\\\selenium-3.14.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    
        String baseUrl = "https://www.supremenewyork.com/shop/all";
        
        String category = "";
        
        //form fields
        String name;
        String email;
        String telNumber;
        String adress; 
        String aptUnit;
        String zip;
        String city;
        //String state;
        String credit;
        //String creditMonth;
        //String creditYear;
        String cvv;
        
        // launch Chrome and direct it to the Base URL
        driver.get(baseUrl);
        if(category.equals("jackets")) {
        	driver.get(baseUrl + "/jackets");
        }
        else if(category.equals("shirts")) {
        	
        }
        else if(category.equals("tops")) {
        	
        }
        else if(category.equals("sweatshirts")) {
        	
        }
        else if(category.equals("pants")){
        	
        }
        else if(category.equals("hats")) {
        	
        }
        else if(category.equals("bags")) {
        	
        }
        else if(category.equals("skate")){
        	
        }
        //close Chrome
        driver.quit();
       
    }

}
