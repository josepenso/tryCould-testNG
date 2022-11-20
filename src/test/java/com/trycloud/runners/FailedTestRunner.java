package com.trycloud.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "com/trycloud/step_definitions"
)

public class FailedTestRunner extends AbstractTestNGCucumberTests {


}
