package calC;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class calculer {
	public static AppiumDriver<MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "ultron");
		cap.setCapability("udid", "59d5b4c6");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6.0.1");
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<MobileElement>driver=new AndroidDriver<MobileElement>(url,cap);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement a=driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
		a.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

		Thread.sleep(3000);
		String result=driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
		Thread.sleep(3000);
		System.out.println(result);
	}
}
