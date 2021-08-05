package woosyume.factory.excercise;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import woosyume.factory.DriverFactory;

public class Excercise {
    private static AndroidDriver<AndroidElement> androidDriver = null;

    public static void main(String[] args) throws MalformedURLException {
        androidDriver = DriverFactory.getDriverFactory().getAndroidDriver();
        androidDriver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        androidDriver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

        androidDriver.findElementById("android:id/checkbox").click();
        androidDriver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();

        androidDriver.findElementByClassName("android.widget.EditText").sendKeys("hello_woosyume");
        androidDriver.findElementsByClassName("android.widget.Button").get(1).click();
    }
}
