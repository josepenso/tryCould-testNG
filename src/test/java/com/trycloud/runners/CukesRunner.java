package com.trycloud.runners;

import com.trycloud.utils.Driver;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.*;

@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt" ,
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/trycloud/stepDef",
        dryRun = false,
        tags = "@ui",
        publish = true
)



public class CukesRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {

        return super.scenarios();
    }

    @Parameters("Browser")
    @BeforeMethod
    public void before( String browser) {
        Driver.setupDriver(browser);
    }


    @AfterMethod
    public void tearDown(){

        Driver.quitDriver();
    }



}
