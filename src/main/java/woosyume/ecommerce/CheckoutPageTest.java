package woosyume.ecommerce;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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

        // Change context for using WebView
        Thread.sleep(7000);
        // Set<String> contexts = androidDriver.getContextHandles();
        // for (String context : contexts) {
        //     System.out.println(context);
        // }
        /**
         *  NATIVE_APP
         *  WEBVIEW_com.androidsample.generalstore
         */
        
        System.out.println("current context1=" + androidDriver.getContext());
        androidDriver.context("WEBVIEW_com.androidsample.generalstore");
        System.out.println("current context2=" + androidDriver.getContext());
        androidDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[1]/div/div[1]/input")).sendKeys("Hello Google"); // xpath or css selector is required after chrome 75. https://support.saucelabs.com/hc/en-us/articles/360057263354-Invalid-locator-error-on-Android-web-tests-using-Chrome-75-and-higher
        androidDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[1]/div/div[1]/input")).sendKeys(Keys.ENTER);

        // Go back to Native app.
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        androidDriver.context("NATIVE_APP");

        // ref. https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md
        // appium --allow-insecure chromedriver_autodownload
        // Automatically download proper chrome driver if you start appium with the above command.
    }
}
