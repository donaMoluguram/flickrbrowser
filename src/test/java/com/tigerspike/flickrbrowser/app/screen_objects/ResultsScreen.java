package com.tigerspike.flickrbrowser.app.screen_objects;

import com.tigerspike.flickrbrowser.app.drivers_factory.MobileDriverImpl;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultsScreen extends MobileDriverImpl {

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText")
    private List<MobileElement> titles;


    public List<String> getListOfTitleFeeds() {
        List<String> allProductsList = new ArrayList<String>();
        for (WebElement title : titles) {
            allProductsList.add(title.getText());
        }
        if (allProductsList.size() == 0) {
            throw new RuntimeException("cannot read title on each feed can you retry once again");
        }
        return allProductsList;
    }

}
