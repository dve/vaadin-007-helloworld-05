package junit.org.rapidpm.vaadin.helloworld.server.junit4.rules;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Optional;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 *
 */
public class ScreenshotTestRule implements TestRule {

  protected Optional<WebDriver> driverOptional;

  public void setDriverOptional(Optional<WebDriver> driverOptional) {
    this.driverOptional = driverOptional;
  }

  public Statement apply(Statement statement, Description description) {

    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        try {
          statement.evaluate();
        } catch (Throwable t) {
          System.out.println("ScreenshotTestRule.evaluate -> catch !! ");
          String methodName = description.getMethodName();
          captureScreenshot(methodName);
          throw t; // rethrow to allow the failure to be reported to JUnit
        }
      }

      public void captureScreenshot(String testname) {
        if (! driverOptional.isPresent()) System.out.println("no WebDriver available for Screenshots " + testname);
        driverOptional.ifPresent(driver -> {
          try {
            new File("target/surefire-reports/").mkdirs(); // Insure directory is there
            FileOutputStream out = new FileOutputStream("target/surefire-reports/failed_screenshot-" + testname + ".png");
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
          } catch (Exception e) {
            // No need to crash the tests if the screenshot fails
            System.out.println("e = " + e);
          }
        });
      }
    };
  }
}
