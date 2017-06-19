package junit.org.rapidpm.vaadin.helloworld.server.junit4;

import static java.lang.System.out;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 *
 */
public class DemoTests {

  @BeforeClass public static void beforeclass() { out.println("beforeclass"); }
  @AfterClass public static void afterclass() { out.println("afterclass"); }

  @Before public void setUp() { out.println("setUp"); }
  @After public void tearDown() { out.println("tearDown - orig"); }


  @Test public void test001() { out.println("test001 - non failing"); }

  @Test public void test002() {
    out.println("test002 - failing");
    fail();
  }


  @Rule
  public TakeScreenShotRule takeScreenShotRule = new TakeScreenShotRule();

  public static class TakeScreenShotRule implements TestRule {

    public class ScreenshotStatement extends Statement {

      private Statement baseStatement;

      public ScreenshotStatement(Statement b) {
        baseStatement = b;
      }

      @Override
      public void evaluate() throws Throwable {
        try {
          baseStatement.evaluate();
        } catch (Error e) {
          out.println("screenshot");
          throw e;
        } finally {
          tearDownManually();
        }
      }

      //Put your after code in this method!
      public void tearDownManually() {
        out.print("tearDownManually - now delegating - ");
        out.println("release resources from baseStatement");
        out.println("###############");
      }
    }

    public Statement apply(Statement base, Description description) {
      return new ScreenshotStatement(base);

    }
  }
}
