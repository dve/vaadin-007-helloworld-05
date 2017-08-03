package junit.org.rapidpm.vaadin.helloworld.server.junit4.base;

import org.junit.runner.RunWith;

import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.Chrome;
import com.github.webdriverextensions.junitrunner.annotations.Firefox;
import com.github.webdriverextensions.junitrunner.annotations.ScreenshotsPath;
import com.github.webdriverextensions.junitrunner.annotations.TakeScreenshotOnFailure;

/**
 *
 */
@Chrome
@Firefox
@RunWith(WebDriverRunner.class)
@TakeScreenshotOnFailure
@ScreenshotsPath("target/surefire-reports/screenshots")
public class BaseSeleniumTest extends BaseTest {
	// Base class, so we don't need to put the annotation to every test
}
