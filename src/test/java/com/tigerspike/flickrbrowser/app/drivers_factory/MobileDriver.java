package com.tigerspike.flickrbrowser.app.drivers_factory;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public interface MobileDriver {

    MobileDriverImpl openApp();

    void killApp();

    DesiredCapabilities capabilities();

    URL remoteURL();

    void applyImplicitWait();
}
