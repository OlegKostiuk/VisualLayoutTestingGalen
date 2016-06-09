package com.epam.kostiuk.galen;

import com.galenframework.testng.GalenTestNgTestBase;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.util.Arrays.asList;

/**
 * @author okostiuk
 */
public class HomePageLayoutTest extends GalenTestNgTestBase {

	public static final String HOME_PAGE_URL = "http://www.droid-life.com/";
	public static final String SPECS_HOME_PAGE = "specs/homePage.gspec";

	@DataProvider
	public Object[][] resolutionData() {
		return new Object[][] {
				{ 1366, 768, asList("desktop")},
				{ 500, 800, asList("mobile")},
		};
	}

	@Override
	public WebDriver createDriver(Object[] args) {
		return new FirefoxDriver();
	}

	@Test(dataProvider = "resolutionData")
	public void homePageTest(int width, int height, List<String> includedTags) throws IOException {
//		getDriver().manage().window().setSize(new Dimension(width, height));
		load(HOME_PAGE_URL, width, height);
		checkLayout(SPECS_HOME_PAGE, includedTags);
	}

}