package com.sample.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sample.base.basePage;

public class search extends basePage {

	WebDriver driver;

	public search(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//textarea[@type=\"search\"]")
	WebElement textbox_search;

	public void googleSearch(String search_phrase) {
		isElementPresent(textbox_search);
		textbox_search.sendKeys(search_phrase);
	}

}
