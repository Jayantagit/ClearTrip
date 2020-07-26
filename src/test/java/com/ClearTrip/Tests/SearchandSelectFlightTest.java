package com.ClearTrip.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchandSelectFlightTest {

	//public WebDriver driver = null;
	public WebDriver driver;
	public String baseUrl = "http://www.cleartrip.com/";

	@BeforeClass
	public void setup() {
		String path = System.getProperty("user.dir");
		//System.setProperty("webdriver.chrome.driver", path + "\\resource\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		//Webdriver.chromedriver.setup();
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 0)
	public void clearTripSearchFlight() throws Exception {
		// WebDriverWait wait = new WebDriverWait(driver,10);
		// Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		// alert.accept();
		driver.findElement(By.id("RoundTrip")).click();
		driver.findElement(By.id("FromTag")).clear();
		driver.findElement(By.id("FromTag")).sendKeys("Bangalore, IN - Kempegowda International Airport (BLR)");
		driver.findElement(By.xpath("//*[@id=\"ToTag\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"ToTag\"]")).sendKeys("New Delhi, IN - Indira Gandhi Airport (DEL)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"DepartDate\"]")).sendKeys("Tue, 21 Jul, 2020");
		driver.findElement(By.xpath("//*[@id=\"ReturnDate\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"ReturnDate\"]")).sendKeys("Fri, 31 Jul, 2020");
		
		WebElement dd_adult = driver.findElement(By.xpath("//*[@id='Adults']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dd_adult);
		
		dd_adult.click();
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", dd_adult);
		Select adult = new Select(dd_adult);
		adult.selectByValue("1");
		WebElement dd_child = driver.findElement(By.xpath("//*[@id='Childrens']"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dd_child);
		dd_child.click();
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", dd_child);
		Select child = new Select(dd_child);
		child.selectByValue("1");
		
		WebElement searchBtn=driver.findElement(By.id("SearchBtn"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
		//searchBtn.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);

	}

	@Test(dependsOnMethods = {"clearTripSearchFlight"})
	public void clearTripSelectFlight()
	{
		//Click on All Flight Link
		WebElement allflightLnk=driver.findElement(By.xpath("//a[text()='All flights']"));
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='All flights']")));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", allflightLnk);

	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}

}
