package com.sample.test;

import org.testng.annotations.Test;

import com.sample.page.search;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
	public void launch() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.MAC);
		driver = new RemoteWebDriver(new URL("http://localhost:4444"),cap);
		driver.get(prop.getProperty("URL"));
		search objSearch = new search(driver);
		objSearch.googleSearch("test more...");
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
