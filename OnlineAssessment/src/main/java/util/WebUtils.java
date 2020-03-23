package util;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class WebUtils extends RemoteWebDriver {
	protected static WebDriver driver;
	protected static String browserName;
	protected static String browserProfilePath;
	static String projectConfigPath = getRoot() + "/src/main/resources/config/initialConfig.properties";
	public static String userName;
	public static String password;
	static String URL;
	protected static DesiredCapabilities desired = null;
	

	public static String getRoot() {
		String testRoot = StringUtils
				.defaultString(Thread.currentThread().getContextClassLoader().getResource(".").getPath());
		if (StringUtils.contains(testRoot, ":/")) {
			testRoot = StringUtils.substring(testRoot, 1);
		}

		return testRoot.replace("/target/classes/", "");
	}

	public void implecitWait() {
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	}

	public void frameworkInitiate() throws IOException {
		// get browser name
		browserName = System.getenv("browser.name");
		if (StringUtils.isBlank(browserName) || browserName == null) {
			browserName = FileUtils.getConfigValue(projectConfigPath, "browser.name");
		}

		userName = FileUtils.getConfigValue(projectConfigPath, "user.name");
		password = FileUtils.getConfigValue(projectConfigPath, "user.password");
		URL = FileUtils.getConfigValue(projectConfigPath, "application.url");
	}

	public void startSeleniumServerAndBrowser() throws IOException {
		WebUtils ui = new WebUtils();
		ui.frameworkInitiate();
		if (browserName.equalsIgnoreCase("chrome")) {
			try {
				ChromeOptions options = new ChromeOptions();
				options.addArguments();

				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
						+ "\\src\\main\\resources\\config\\browser\\chrome\\chromedriver.exe");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();

				if (desired == null) {
					desired = DesiredCapabilities.chrome();
					desired.setCapability(ChromeOptions.CAPABILITY, options);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Start automation testing failed due to driver is null !");
		}

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);

	}

	public void scrollDown() {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollDownToElement(By element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
	}

	public void waitForElementPresent(By objname, int time) {
		try {
			WebDriverWait newWait = new WebDriverWait(driver, time);
			newWait.until(ExpectedConditions.visibilityOfElementLocated(objname));
		} catch (Exception e) {
			Assert.fail("timeout error: element '" + objname + "' not present");
		}
	}

	
	  public void frameSwitch(WebElement element) { 
		  driver.switchTo().frame(element);
	  }
	 
	  public void mainWindow() { 
		  driver.switchTo().defaultContent();
	  }
	  
	  public void enterText(By element, String text) {
			  waitForElementPresent(element, 30);
			  driver.findElement(element).clear();
			  driver.findElement(element).sendKeys(text);	  
	  }
	  
	  public void clickOnButton(By element) {
		  waitForElementPresent(element, 30);
		  driver.findElement(element).click();
	  }
	  
	  public String getText(By element) {
		  waitForElementPresent(element, 30);
		  return driver.findElement(element).getText();
	  }
	  
	  public String getCellDatata(WebElement _webTable, int rowIDx, int colIdx) throws NoSuchElementException{
		  try
		  {
			  List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
			  WebElement currentRow = tableRows.get(rowIDx-1);
			  List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
			  WebElement currentCol = tableCols.get(colIdx);
			  List<WebElement> currentcellvalue = currentCol.findElements(By.tagName("a"));
			  
              return currentcellvalue.get(0).getText();
		  }
		  catch(NoSuchElementException e)
		  {
			  throw new NoSuchElementException("Failed to get cell");
		  }
	  }

	  public int getRowCount(WebElement _webTable){	
		  return _webTable.findElements(By.tagName("tr")).size();	
	  }
	  
	  @AfterSuite
	  public void closeBrowser(){
		  driver.quit();
	  }
}
