package woosyume.chromebrowsertest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import woosyume.factory.DriverFactory;

public class ChromeTest {
    private static AndroidDriver<AndroidElement> driver = null;

    public static void main(String[] args) throws MalformedURLException {
        driver = DriverFactory.getDriverFactory().getAndroidChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://ranking.rakuten.co.jp");
    }
}
