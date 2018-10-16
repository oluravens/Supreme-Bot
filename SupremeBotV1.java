package ai;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SupremeBotV1 {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver","C:\\\\selenium-3.14.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    
        String baseUrl = "https://www.supremenewyork.com/shop/all";
        
        String category;
        
        Scanner input = new Scanner(System.in);
        
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
        
        //pick the section of the website
        System.out.println("Enter the item category: ");
        category = input.next();
        
        if(category.equals("jackets")) {
        	driver.get(baseUrl + "/jackets");
        }
        else if(category.equals("shirts")) {
        	driver.get(baseUrl + "/shirts");
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
        //close Chrome
        //driver.quit();
       
    }

}
