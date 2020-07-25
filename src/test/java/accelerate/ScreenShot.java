package accelerate;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShot {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = null ;
		String browser= "chrome";
		
		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver","C:\\Webdrivers\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    	
	    	break;
	    	
		case "firefox":
			System.setProperty("webdriver.gecko.driver","C:\\Webdrivers\\geckodriver.exe");
	    	driver = new FirefoxDriver();
	    	break;
	    	
		case "ie":
			System.setProperty("webdriver.ie.driver","C:\\Webdrivers\\IEDriverServer.exe");
	    	driver = new InternetExplorerDriver();
	    	break;
	    	
		case "edge":
			System.setProperty("webdriver.edge.driver","C:\\Webdrivers\\msedgedriver.exe");
	    	driver = new EdgeDriver();
	    	break;
	    	
		case "opera":
			System.setProperty("webdriver.opera.driver","C:\\Webdrivers\\operadriver.exe");
	    	driver = new OperaDriver();
	    	break;
		}
		
    	
        driver.get("http://www.filippobello.com/portfolio");
        driver.manage().window().maximize();     
     	Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE, 1000, true).save("E:\\NewElementScreenshot.jpeg");  
        driver.close();
        
        

	}

}