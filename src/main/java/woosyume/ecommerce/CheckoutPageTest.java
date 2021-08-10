package woosyume.ecommerce;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import woosyume.factory.DriverFactory;

public class CheckoutPageTest {
    private static AndroidDriver<AndroidElement> androidDriver = null;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
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

        List<AndroidElement> items = androidDriver.findElements(MobileBy.AndroidUIAutomator("text(\"ADD TO CART\")"));
        items.get(0).click();
        items.get(0).click(); // On line 34, one of the button is removed. That's why ciick 0 index 2 times.

        // Go to cart
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        // To secure loading time.
        Thread.sleep(4000);

        List<AndroidElement> prices = androidDriver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        double price1 = Double.parseDouble(prices.get(0).getText().replace("$", ""));
        double price2 = Double.parseDouble(prices.get(1).getText().replace("$", ""));

        System.out.println(price1 + price2); // 280.97

        double total = Double.parseDouble(androidDriver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().replace("$", ""));
        // Do compare!
        System.out.println("total=" + total);

        WebElement checkbox = androidDriver.findElement(By.className("android.widget.CheckBox"));
        TouchAction action = new TouchAction<>(androidDriver);
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(checkbox))).perform();

        WebElement term = androidDriver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(term)).withDuration(Duration.ofSeconds(2))).release().perform();
        androidDriver.findElement(By.id("android:id/button1")).click();

        androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
    }
}
