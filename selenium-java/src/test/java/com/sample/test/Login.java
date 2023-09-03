package com.sample.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	Properties prop = new Properties();
	WebDriver driver = null;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		try {
			InputStream fis = new FileInputStream(System.getProperty("user.dir") + "/constants.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void launch() {
		driver = new ChromeDriver();
		System.out.println(prop.getProperty("URL"));
		driver.get(prop.getProperty("URL"));

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
