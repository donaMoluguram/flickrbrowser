package com.tigerspike.flickrbrowser.app.drivers_factory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MobileDriverImpl implements MobileDriver {

    private static IOSDriver driver;

    public MobileDriverImpl() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    @Override
    public MobileDriverImpl openApp() {
        driver = new IOSDriver(remoteURL(), capabilities());
        return this;
    }

    @Override
    public void killApp() {
        driver.closeApp();
    }

    @Override
    public DesiredCapabilities capabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Set<Map.Entry<Object, Object>> properties = loadProperties("capabilities").entrySet();

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("automationName", "XCUITest");
        for (Map.Entry<Object, Object> key : properties) {
            capabilities.setCapability((String) key.getKey(), key.getValue());
        }
        return capabilities;
    }

    @Override
    public URL remoteURL() {
        URL remoteUrl;
        try {
            remoteUrl = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Check server is started or not ....");
        }
        return remoteUrl;
    }

    @Override
    public void applyImplicitWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private Properties loadProperties(String using) {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/" + using+".properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Cannot load %s files ", using));
        }
        return properties;
    }
}
