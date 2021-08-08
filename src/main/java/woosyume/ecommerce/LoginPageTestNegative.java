package woosyume.ecommerce;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import woosyume.factory.DriverFactory;

public class LoginPageTestNegative {
    private static AndroidDriver<AndroidElement> androidDriver = null;

    public static void main(String[] args) throws MalformedURLException {
        androidDriver = DriverFactory.getDriverFactory().getAndroidDriver("emulator");
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // androidDriver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
        // androidDriver.hideKeyboard();
        
        androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"Female\")")).click();

        // Set nationality
        androidDriver.findElement(By.id("android:id/text1")).click();
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        androidDriver.findElement(By.xpath("//*[@text='Argentina']")).click();

        androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        String toastMessage = androidDriver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
        System.out.println(toastMessage);
    }
}
