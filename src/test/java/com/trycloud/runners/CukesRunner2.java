package com.trycloud.runners;

import com.trycloud.utilities.Driver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;





@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt" ,
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/trycloud/stepDef",
        dryRun = false,
        tags = "@miniRegression2",
        publish = true
)
public class CukesRunner2 extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {

            return super.scenarios();
        }

        @Parameters("Browser")
        @BeforeMethod
        public void before(String browser) {
            Driver.setupDriver(browser);
        }


        @AfterMethod
        public void tearDown() {

            Driver.quitDriver();
        }
    }

