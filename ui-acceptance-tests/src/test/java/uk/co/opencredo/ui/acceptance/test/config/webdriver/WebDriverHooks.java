package uk.co.opencredo.ui.acceptance.test.config.webdriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import uk.co.opencredo.ui.acceptance.test.common.World;
import uk.co.opencredo.ui.acceptance.test.config.spring.TestConfig;

/**
 * Perform actions before and after execution of each test with cucumber hooks
 */
@ContextConfiguration(classes = TestConfig.class)
public class WebDriverHooks {

    @Autowired
    private SharedDriver sharedDriver;

    @Autowired
    private World world;

    /**
     * Delete all cookies at the start of each ui scenario to avoid
     * shared state between tests
     */
    @Before
    public void deleteAllCookies() {
        this.sharedDriver.manage().deleteAllCookies();
    }

    /**
     * Embed a screenshot in test report if a ui scenario is marked as failed
     */
    @After()
    public void embedScreenshotIfFailed(Scenario scenario) {
        this.sharedDriver.embedScreenshotIfFailed(scenario);
    }
}
