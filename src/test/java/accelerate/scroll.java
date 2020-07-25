package accelerate;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class scroll {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver ;
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\achat\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
    	driver = new FirefoxDriver();

    	driver.get("http://www.bbc.com");       
    	driver.manage().window().maximize();
    	System.out.println(driver.getTitle());
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("E:\\chromedriver\\scr3.png"));  
    	WebElement elements = driver.findElement(By.xpath(".//*[@id='page']/section[6]/div/div/div[1]/ul/li[3]/div/div[2]/h3/a"));    
    	Thread.sleep(3000L);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	int yPosition = elements.getLocation().getY();
    	js.executeScript("window.scroll (0, " + yPosition + ") ");       
    	Thread.sleep(3000L);         
    	File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile1, new File("E:\\chromedriver\\scr4.png"));
    	driver.close();

        
//        Thread.sleep(10000);
        
        driver.close();
        
        

	}

}
