package com.tigerspike.flickrbrowser.app.screen_objects;

import com.tigerspike.flickrbrowser.app.drivers_factory.MobileDriverImpl;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.Keys;

public class HomeScreen extends MobileDriverImpl {

    @iOSFindBy(xpath = "//XCUIElementTypeSearchField")
    private MobileElement searchTxtBox;

    public boolean isOnHomePage() {
        return searchTxtBox.isDisplayed();
    }

    public ResultsScreen doSearch(String using){
        searchTxtBox.sendKeys(using);
        searchTxtBox.sendKeys(Keys.ENTER);
       return new ResultsScreen();
    }
}
