package com.talpa.pages;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.talpa.pages.talpaPages;
import com.talpa.utils.utils;

public class talpaPages {
	
	/**
	 * @author : Srinivasa Ravi Chandra Muktavarapu
	 * @category : Talpa case Study
	 * @Task : Automation of given Scenario
	 * @date : 16/08/2021
	 */
	protected static RemoteWebDriver driver;

	/************************************************ Static variables to store Excel sheet data **************************************/
	static String testCaseID; 
	static String browser;
	static String url;
	
	/************************************************** Talpa Page Elements ******************************************************/

	String url1 = "//h3";
	String dynamicE1 = "//a[contains(@href, '/dynamic_loading/1')]";
	String dynamicE2 = "//a[contains(@href, '/dynamic_loading/2')]";
	String start = "//button";
	String challengeE1 = "//a[contains(@id,'4b50')]";
	String challengeE2 = "//a[contains(@id,'4b51')]";
	String challengeE3 = "//a[contains(@id,'4b52')]";
	String canvasPath = "//canvas";
	String tableH1 = "(//span[contains(text(), 'Last Name')])[1]";
	String tableH2 = "(//span[contains(text(), 'First Name')])[1]";
	String tableH3 = "(//span[contains(text(), 'Email')])[1]";
	String tableH4 = "(//span[contains(text(), 'Due')])[1]";
	String tableH5 = "(//span[contains(text(), 'Web Site')])[1]";
	String menuEnabled = "//a[contains(text(), 'Enabled')]";
	String menuDownloads = "//a[contains(text(), 'Downloads')]";
	String menuPDF = "//a[contains(text(), 'PDF')]";
	String menuCSV = "//a[contains(text(), 'CSV')]";
	String menuExcel = "//a[contains(text(), 'Excel')]";
	String dynamicV1 = "//a[contains(text(), 'Example 1')]";
	String dynamicV2 = "//a[contains(text(), 'Example 2')]";
	String finalOutput = "//h4[contains(text(), 'Hello World!')]";
	//String finalOutput = "//div[@id='finish']";
	

	/********************************************** Methods ******************************************************/

	/*..... Required class objects .....*/
	utils utilsOb = new utils();
	//talpaPages talpaOb = new talpaPages();
	org.apache.logging.log4j.Logger log = LogManager.getLogger(talpaPages.class);


	/*..... Browser System properties .....*/
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
	}

	/*..... This Method will read test data from provided excel sheet .....*/
	public void getSheetData(String testName){
		try {
			utils.getTestData(testName);
			testCaseID=utils.storeData("Test Case Name");
			System.out.println("Executing testCaseId...." + testCaseID );
			browser = utils.storeData("BROWSER");
			url = utils.storeData("Test URL");
			
		} catch (IOException e) {
			log.error("Error occured while reading the test data from excel sheet");
		}
	}

	/*.....This Method will Launch browser and launching talpa Dynamically loaded page elements URl. 
	 * Browser name and Website URl is passed from Test data excel sheet .....*/
	public WebDriver launchTalpaDynamicURL(){
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();                      
			}
			utilsOb.waitForElm(1);
			driver.get(url);		
			driver.manage().window().maximize();
			utilsOb.waitForElm(3);
			utilsOb.waitForGivenElem(driver, url1);
		} catch (Exception e) {
			log.error("Error occured while launching the talpa website in desired browser");
		}
		return driver;
	}
	
	/*.....This Method will click on the first example URL, so that user can observe the start label .....*/
	public WebDriver example01() {
		try {
			driver.findElementByXPath("//a[contains(@href, '/dynamic_loading/1')]").click();
		} catch (Exception e) {}
		return driver;
	}
	
	/*.....This Method will click on the second example URL, so that user can observe the start label .....*/
	public WebDriver example02() {
		try {
			driver.findElementByXPath("//a[contains(@href, '/dynamic_loading/2')]").click();
		} catch (Exception e) {}
		return driver;
	}
	
	/*.....This Method will click on Start label to see the desired text .....*/
	public WebDriver Start() {
		try {
			driver.findElementByXPath("//button").click();
			utilsOb.waitForElm(10);
		} catch (Exception e) {}
		return driver;
	}
	
	/*.....This Method will validate whether both the examples are loaded in the Dynamic Loaded Elements page .....*/
	public WebDriver dynamicValidation() {
		try {
			WebElement Link1 = driver.findElementByXPath(dynamicV1);
			WebElement Link2 = driver.findElementByXPath(dynamicV2);
			if(Link1.isDisplayed() && Link2.isDisplayed()) {
				System.out.println("Examples are displayed");
			}else {
				System.out.println("No examples are displayed");
			}
		} catch (Exception e) {}
		return driver;
	}
	
	/*.....This Method will validate whether the final output is as expected or not .....*/
	public WebDriver finalResult() {
		try {
			WebElement output = driver.findElementByXPath(finalOutput);
			String answer = output.getText();
			if(answer.contains("Hello World!")) {
				System.out.println("Result is as intended");
			}else {
				System.out.println("Error in the final result");
			}
			driver.quit();
		} catch (Exception e) {}
		return driver;
	}
	
	/*.....This Method will validate whether all examples are loaded in the Challenging DOM page .....*/
	public WebDriver challengeValidation() {
		try {
			WebElement c1 = driver.findElementByXPath(challengeE1);
			WebElement c2 = driver.findElementByXPath(challengeE2);
			WebElement c3 = driver.findElementByXPath(challengeE3);
			if(c1.isDisplayed() && c2.isDisplayed() && c3.isDisplayed()) {
				System.out.println("All challenges are displayed");
			}else {
				System.out.println("No challenges are displayed");
			}
		} catch (Exception e) {}
		return driver;
	}
	
	/*.....This Method will allow the user to navigate to url and click on the unique ids .....*/
	public WebDriver clickID() {
		try {
			driver.findElementByXPath(challengeE1).click();
			driver.findElementByXPath(challengeE2).click();
			driver.findElementByXPath(challengeE3).click();
		} catch (Exception e) {}
		return driver;
	}
	
	/*.....This Method will validate whether the intended output is displayed .....*/
	public WebDriver finalAnswer() {
		try {
			Thread.sleep(3000);
			WebElement ans = driver.findElementByXPath(canvasPath);
			if(ans.isDisplayed()) {
				System.out.println("Answer is displayed successfully");
			}
			else {
				System.out.println("The is output is failed");
			}
			driver.quit();
		} catch (Exception e) {}
		return driver;
	}
	
	/*.....This Method able to click on Enabled dropdown .....*/
	public WebDriver fileEnabled() {
		try {
			driver.findElementByXPath(menuEnabled).click();
		} catch (Exception e) {}
		return driver;
	}
	
	/*.....This Method able to click on downloads dropdown .....*/
	public WebDriver fileDownload() {
		try {
			Thread.sleep(3000);
			driver.findElementByXPath(menuDownloads).click();			
		} catch (Exception e) {}
		return driver;
	}
	
	/*.....This Method able to download the file .....*/
	public WebDriver formatDownload(String file) {
		try {
			utilsOb.waitForElm(3);
			String xp = null;
			if(file.contains("PDF")){
				xp = menuPDF;
			}else if(file.contains("CSV")){
				xp = menuCSV;
			}else if(file.contains("Excel")){
				xp = menuExcel;
			}
			driver.findElementByXPath(xp).click();
		} catch (Exception e) {}
		return driver;
	}
	
	/*..... This Method will close all the active session of browser .....*/
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	/*..... This Method will enter values in search criteria for trivago weekend portal. 
	 * Search criteria is passed from Test data excel sheet .....*/
//	public void enterSearchCriteria() {
//		utilsOb.waitAndClick(driver,1,currDrpButton);
//		utilsOb.selectElemByText(driver, SelectCurrncy, currency);
//		utilsOb.sendInput(driver, searchLocation, location);
//		utilsOb.waitAndClick(driver,1,appearedLocation);
//		utilsOb.waitAndClick(driver,2,searchRadius);
//		utilsOb.selectElemByText(driver, radiusValue, radius);
//		utilsOb.waitAndClick(driver,2, searchFrmDate);
//		utilsOb.selectElemByDateValue(driver, calendar, fromDate);
//		utilsOb.waitAndClick(driver,2, searchToDate);
//		utilsOb.selectElemByDateValue(driver, calendar, toDate);
//		utilsOb.waitAndClick(driver,1, searchGuest);
//		utilsOb.sendInput(driver, addAdult, adultGuestCount);
//		utilsOb.sendInput(driver, addChild, childGuestCount);
//		utilsOb.sendInput(driver, addRoom, roomCount);
//		utilsOb.waitAndClick(driver,2, applyButton);
//	}
//
//	/*..... This Method will verify the stays shown for nearest search destination results .....*/
//	public void verifyBestStays() {
//		utilsOb.switchToWindow(driver, 1);
//		utilsOb.waitAndClick(driver, 1, viewDealSearch);
//		utilsOb.selectDropDownByVisibleText(driver, sortBy, "Price & Recommended");
//		utilsOb.waitForElm(2);
//	}
//
//	/*..... This Method will choose the cheapest stay option shown for nearest search destination results and click on view deals button.....*/
//	public void verifySortedStaysAndClickOnViewDeal() {
//		String key = null;
//		String value = null;
//		int val =0;
//		try {
//			List <WebElement> sortedStay_box = driver.findElements(By.xpath(sortedStays));
//			List <WebElement> sorted_Prices = driver.findElements(By.xpath(sortedPrices));
//			Map<String, Integer> searchData = new HashMap<String, Integer>();
//			if(sortedStay_box.size()>0 && sorted_Prices.size()>0) {
//				for(int i=0;i<sortedStay_box.size();i++){
//					key = sortedStay_box.get(i).getText();
//					value = utilsOb.trimString(sorted_Prices.get(i).getText());
//					value = utilsOb.brkString(value, 1);
//					val = utilsOb.convertStringInt(value);
//					searchData.put(key, val);
//				}	 
//				log.info("Search result is found as : " + searchData);
//				String  cheapestPlace = utilsOb.getMinValKeyofMap(searchData);
//				cheapestPlace = utilsOb.brkStringByText(cheapestPlace, "to");
//				//System.out.println("***" + cheapestPlace + "***");
//				log.info("Best place to visit on desired weekend is :" + cheapestPlace);
//				for(int k=0;k<sortedStay_box.size();k++){
//					WebElement currElem = sortedStay_box.get(k);
//					String curPlace = currElem.getText();
//					//System.out.println(curPlace);
//					if(curPlace.contains(cheapestPlace)){
//						int currentThread = k+1;
//						currElem.findElement(By.xpath("("+viewDealButton+")["+currentThread+"]")).click();
//						booking_Partner = currElem.findElement(By.xpath("("+bookingPartner+")["+currentThread+"]")).getText();
//					}
//				}
//			}else {
//				utilsOb.verifyGivenWebElement(utilsOb.selectElement(driver, sortedStayPageHdrSec));
//			}			
//		}catch(Exception e) {
//			log.error("Error occured while verifying the sorted stays : " +e );
//		}
//	}
//
//	/*..... This Method will verify the header for the see more options page for nearest shown destination .....*/
//	public void verifySearchResult() {
//		utilsOb.verifyGivenWebElement(utilsOb.selectElement(driver, src_HdrContainer) );
//	}
//
//	/*..... This Method will verify the user is navigated to partners website successfully 
//	 * when clicked on view deal button and close the browser.....*/
//	public void verifyPartnerWebsiteIsOpnWithViewDeal() {
//		utilsOb.verifyPageTitle(driver, booking_Partner);
//		closeBrowser();
//	}
//
//	/*..... This Method will close all the active session of browser .....*/
//	public void closeBrowser() {
//		driver.quit();
//	}
//
//	/*..... This Method will choose the nearest shown destination and click on see more options link .....*/
//	@SuppressWarnings("null")
//	public void verifyAndClickNearestOption() {
//		String key = null;
//		String value = null;
//		int val =0;
//		try {
//			List <WebElement> placesHdr = driver.findElements(By.xpath(searchRsltHdr));
//			List <WebElement> src_PlHdrs = driver.findElements(By.xpath(src_HdrContainer));
//			List <WebElement> placeDist = driver.findElements(By.xpath(searchRsltDistance));
//			Map<String, Integer> searchData = new HashMap<String, Integer>();
//			if(placesHdr.size()>0 && placeDist.size()>0) {
//				for(int i=0;i<placesHdr.size();i++){
//					key = placesHdr.get(i).getText();
//					value = utilsOb.trimString(placeDist.get(i).getText());
//					val = utilsOb.convertStringInt(value);
//					searchData.put(key, val);
//				}	 
//				log.info("Search result is found as : " + searchData);
//				String  nearestPlace = utilsOb.getMinValKeyofMap(searchData);
//				log.info("Nearest place to visit on desired weekend is :" + nearestPlace);
//				for(int k=0;k<src_PlHdrs.size();k++){
//					WebElement currElem = src_PlHdrs.get(k);
//					String curPlace = currElem.getText();
//					if(curPlace.contains(nearestPlace)) {
//						int currThrd = k+1;
//						currElem.findElement(By.xpath("("+seeMoreStaysLink+")["+currThrd+"]")).click();
//					}else {
//			
//					}
//				}
//			}else {
//				utilsOb.verifyGivenWebElement(utilsOb.selectElement(driver, search_Tiles));
//
//			}			
//		}catch(Exception e) {
//			log.error("Error occured while verifying the search results");
//		}
//	}
}
