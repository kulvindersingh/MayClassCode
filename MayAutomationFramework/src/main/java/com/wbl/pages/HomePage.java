package com.wbl.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.wbl.base.CommonPage;

public class HomePage extends CommonPage{

	@FindBy(how=How.CSS,using=".TempoCategoryTile-tile-overlay")
	List<WebElement> imagesList;
	
	@FindBy(how=How.CSS,using=".ClickThroughImage")
	List<WebElement> slidersList;
	

	@FindBy(how=How.CSS,using=".header-GlobalSearch-submit.btn")
	WebElement searchButton;
	
	@FindBy(how=How.ID,using="global-search-input")
	WebElement searchBox;
	
	//Page classes are dependent on driver object  and we need to inject driver to all page classes -dependency injection
	//Dependency injection using constructor
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public SearchResultsPage search(String searchdata){
		searchBox.sendKeys(searchdata);
		searchButton.click();
		return new SearchResultsPage(driver);
	}
	public int imagesList(){
		return imagesList.size();
	}
	

	public int sliderImages(){
		return slidersList.size();
	}
}
