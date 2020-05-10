package com.zoopla;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseLogin {

			public static void main(String[] args) throws Throwable {

				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
				Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);			
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
			
				
				driver.get("https://www.zoopla.co.uk");
				WebElement allcookies= driver.findElement(By.xpath("//*[@class='ui-button-primary ui-cookie-accept-all-medium-large']"));
				JavascriptExecutor js = (JavascriptExecutor) driver; 
				js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", allcookies);
				allcookies.click();
				WebDriverWait obj = new WebDriverWait(driver, 30);
				obj.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@class='ui-button-primary ui-cookie-accept-all-medium-large']"), 0));
				
				System.out.println(driver.getTitle());
				WebElement signin= driver.findElement(By.xpath("//*[@class='button button--tertiary-dark account-link__text']"));
				js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", signin);
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				signin.click();
				System.out.println(driver.getCurrentUrl());
				WebElement email= driver.findElement(By.xpath("//*[@type='email']"));
				js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", email);
				email.sendKeys("arif123@gmail.com");
				WebElement password= driver.findElement(By.xpath("//*[@type='password']"));
				js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", password);
				password.sendKeys("arif12345");
				WebElement login= driver.findElement(By.xpath("//*[@id='signin_submit']"));
				js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", login);
				login.submit();
				System.out.println(driver.getTitle());
				
			
			}
		
			}


