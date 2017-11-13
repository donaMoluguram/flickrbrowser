package com.tigerspike.flickrbrowser.app;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".", strict = true,dryRun = false)
public class RunCukesTest {

}
