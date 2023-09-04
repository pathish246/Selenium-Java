package com.sample.base;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class basePage {

	WebDriver driver;

	public basePage(WebDriver driver) {
		this.driver = driver;
	}

	public void isElementPresent(WebElement element) {
		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofSeconds(5L))
				.ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(element));

	}
}
