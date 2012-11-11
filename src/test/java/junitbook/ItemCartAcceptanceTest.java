package junitbook;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

/**
 * @author shuji.w6e
 */
@RunWith(Cucumber.class)
@Cucumber.Options(format = { "pretty" }, monochrome = true)
public class ItemCartAcceptanceTest {
}
