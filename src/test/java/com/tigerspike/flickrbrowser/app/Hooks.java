package com.tigerspike.flickrbrowser.app;


import com.tigerspike.flickrbrowser.app.drivers_factory.MobileDriverImpl;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {

    MobileDriverImpl mobileDriver ;

    public Hooks(MobileDriverImpl diMobileDriver){
        this.mobileDriver=diMobileDriver;
    }

    @Before
    public void setUp() {
        mobileDriver.openApp().applyImplicitWait();
    }

    @After
    public void tearDown(){
        mobileDriver.killApp();
    }
}
