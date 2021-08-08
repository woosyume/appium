package woosyume.ecommerce;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import woosyume.factory.DriverFactory;

public class ProductPageTestPositive {
    private static AndroidDriver<AndroidElement> androidDriver = null;

    public static void main(String[] args) throws MalformedURLException {
        androidDriver = DriverFactory.getDriverFactory().getAndroidDriver("emulator");
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
        androidDriver.hideKeyboard();
        
        androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"Female\")")).click();

        // Set nationality
        androidDriver.findElement(By.id("android:id/text1")).click();
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        androidDriver.findElement(By.xpath("//*[@text='Argentina']")).click();

        androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PG 3\"));");

        List<AndroidElement> names = androidDriver.findElements(By.id("com.androidsample.generalstore:id/productName"));
        List<AndroidElement> carts = androidDriver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
        int count = names.size();
        for (int i = 0; i < count; i++) {
            String productName = names.get(i).getAttribute("name");
            if (productName.equals("PG 3")) {
                carts.get(i).click();
                break;
            }
        }

        // Go to cart
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    }
}
