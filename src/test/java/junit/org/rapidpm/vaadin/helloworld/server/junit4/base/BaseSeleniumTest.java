package junit.org.rapidpm.vaadin.helloworld.server.junit4.base;

import static java.util.Optional.ofNullable;
import static org.openqa.selenium.By.id;
import static org.rapidpm.vaadin.helloworld.server.MyUI.BUTTON_ID;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_A;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_B;
import static org.rapidpm.vaadin.helloworld.server.MyUI.OUTPUT_ID;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.webdriverextensions.Bot;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.Chrome;
import com.github.webdriverextensions.junitrunner.annotations.ScreenshotsPath;
import com.github.webdriverextensions.junitrunner.annotations.TakeScreenshotOnFailure;

/**
 *
 */
@Chrome
@RunWith(WebDriverRunner.class)
@TakeScreenshotOnFailure
@ScreenshotsPath("target/surefire-reports/screenshots")
public class BaseSeleniumTest extends BaseTest {

  protected Optional<WebDriver> driver;

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

		driver = Optional.of(Bot.driver());

  }


  @Override
  @After
  public void tearDown() throws Exception {
    System.out.println("BaseSeleniumTest.tearDown !! ");

    driver = Optional.empty();
    super.tearDown();
  }


  //generic version - need it later
  public BiFunction<WebDriver, String, Optional<WebElement>> elementFor
      = (driver, id) -> ofNullable(driver.findElement(id(id)));

  //localized version
  private Function<String, WebElement> element
      = (id) -> driver
      .flatMap(driverOptional -> elementFor.apply(driverOptional, id))
      .orElseThrow(()-> new RuntimeException("WebElement with the ID " + id +" is not available"));

  protected Supplier<WebElement> button = () -> element.apply(BUTTON_ID);
  protected Supplier<WebElement> output = () -> element.apply(OUTPUT_ID);
  protected Supplier<WebElement> inputA = () -> element.apply(INPUT_ID_A);
  protected Supplier<WebElement> inputB = () -> element.apply(INPUT_ID_B);

}
